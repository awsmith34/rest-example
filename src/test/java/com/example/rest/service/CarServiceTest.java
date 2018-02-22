package com.example.rest.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.rest.model.Car;
import com.example.rest.model.Color;
import com.example.rest.repository.CarRepository;

import mockit.Mock;
import mockit.MockUp;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceTest {
	
	@Autowired
	private CarRepository repository;
	
	private static final long ID = 12;
	private static final String MAKE = "Honda";
	private static final String MODEL = "Accord";
	private static final short YEAR = 2016;
	private static final Color COLOR = Color.GREY;
	
	private CarService service;
	
	@Before
	public void setUp() {
		service = new CarService();
		service.setRepository(repository);
		
		Car car = initializeCar();
		
		new MockUp<JpaRepository<Car, Long>>() {
			@Mock
			Car save(Car car) {
				return car;
			}
			
			@Mock
			Car findOne(Long id) {
				return car;
			}
			
			@Mock
			void delete(Long id) {
			}
		};
	}

	@Test
	@Ignore
	public void createCar() {
		Car car = initializeCar();
		long id = service.create(car);
		assertEquals(ID, id);
	}
	
	@Test
	@Ignore
	public void updateCar() {
		Car car = initializeCar();
		service.update(car);
	}
	
	@Test
	@Ignore
	public void getCar() {
		Car car = service.get(ID);
		assertEquals(ID, car.getId());
		assertEquals(MAKE, car.getMake());
		assertEquals(MODEL, car.getModel());
		assertEquals(YEAR, car.getYear());
		assertEquals(COLOR, car.getColor());
	}

	@Test
	@Ignore
	public void deleteCar() {
		service.delete(ID);
	}
	
	private Car initializeCar() {
		Car car = new Car();
		car.setId(ID);
		car.setMake(MAKE);
		car.setModel(MODEL);
		car.setYear(YEAR);
		car.setColor(COLOR);
		return car;
	}
}
