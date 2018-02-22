package com.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.model.Car;
import com.example.rest.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;
	
	public void setRepository(CarRepository repository) {
		this.repository = repository;
	}
	
	public long create(Car car) {
		Car newCar = repository.save(car);
		return newCar.getId();
	}
	
	public void update(Car car) {
		repository.save(car);
	}
	
	public Car get(long id) {
		return repository.findOne(id);
	}
	
	public void delete(long id) {
		repository.delete(id);
	}
}
