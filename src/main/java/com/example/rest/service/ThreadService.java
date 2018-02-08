package com.example.rest.service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {
	private static final Logger LOG = LoggerFactory.getLogger(ThreadService.class);
	
	private static final String DEADLOCK_MESSAGE = "Deadlock occurred in threads %s and %s";
	private static final String NO_DEADLOCK_MESSAGE = "Deadlock did not occur";

	public void startDeadlock() {
		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock1) {
					LOG.info("Thread1 obtained lock1");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						LOG.warn("Thread1 interrupted: {}", e.getMessage());
					}
					synchronized (lock2) {
						LOG.info("Thread1 obtained lock2");
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock2) {
					LOG.info("Thread2 obtained lock2");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						LOG.warn("Thread2 interrupted: {}", e.getMessage());
					}
					synchronized (lock1) {
						LOG.info("Thread2 obtained lock1");
					}
				}
			}
		});

		thread1.start();
		thread2.start();
	}

	public String detectDeadlock() {
		try {
			LOG.info("Waiting for deadlock to occur before detection");
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			LOG.warn("Deadlock detection interrupted: {}", e.getMessage());
		}

		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = threadBean.findDeadlockedThreads();
		if (threadIds == null || threadIds.length <= 1) {
			LOG.info(NO_DEADLOCK_MESSAGE);
			return NO_DEADLOCK_MESSAGE;
		}
		
		String message = String.format(DEADLOCK_MESSAGE, threadIds[0], threadIds[1]);
		LOG.info(message);
		return message;
	}
}
