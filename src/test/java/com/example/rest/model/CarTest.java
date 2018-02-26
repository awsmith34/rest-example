package com.example.rest.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	private static final int ID_1 = 25;
	private static final String MAKE_1 = "Nissan";
	private static final String MODEL_1 = "NSX";
	private static final short YEAR_1 = 2018;
	private static final Color COLOR_1 = Color.GREY;
	private static final Date CREATED_DATE_1 = new Date();
	private static final Date LAST_MODIFIED_DATE_1 = new Date();
	private static final int ID_2 = 43;
	private static final String MAKE_2 = "Mercedes";
	private static final String MODEL_2 = "E400";
	private static final short YEAR_2 = 2017;
	private static final Color COLOR_2 = Color.BLUE;
	
	private Car car1;
	
	@Before
	public void setUp() {
		car1 = new Car();
		car1.setId(ID_1);
		car1.setMake(MAKE_1);
		car1.setModel(MODEL_1);
		car1.setYear(YEAR_1);
		car1.setColor(COLOR_1);
		car1.setCreatedDate(CREATED_DATE_1);
		car1.setLastModifiedDate(LAST_MODIFIED_DATE_1);
	}

	@Test
	public void equalCars() {
		assertEquals(car1, car1);
		Car car2 = new Car();
		car2.setId(ID_1);
		car2.setMake(MAKE_1);
		car2.setModel(MODEL_1);
		car2.setYear(YEAR_1);
		car2.setColor(COLOR_1);
		car2.setCreatedDate(CREATED_DATE_1);
		car2.setLastModifiedDate(LAST_MODIFIED_DATE_1);
		assertEquals(car1, car2);
		assertEquals(car1.hashCode(), car2.hashCode());
	}

	@Test
	public void unequalCars() {
		Car car2 = new Car();
		car2.setId(ID_2);
		car2.setMake(MAKE_2);
		car2.setModel(MODEL_2);
		car2.setYear(YEAR_2);
		car2.setColor(COLOR_2);
		car2.setCreatedDate(new Date());
		car2.setLastModifiedDate(new Date());
		assertNotEquals(car1, car2);

		car2.setId(ID_1);
		assertNotEquals(car1, car2);
		car2.setMake(MAKE_1);
		assertNotEquals(car1, car2);
		car2.setModel(MODEL_1);
		assertNotEquals(car1, car2);
		car2.setYear(YEAR_1);
		assertNotEquals(car1, car2);
		car2.setColor(COLOR_1);
		assertNotEquals(car1, car2);
		car2.setCreatedDate(CREATED_DATE_1);
		assertNotEquals(car1, car2);
	}
	
	@Test
	public void equalsCarWithNulls() {
		Car car2 = new Car();
		car2.setId(ID_1);
		car2.setYear(YEAR_1);
		car1.setMake(null);
		car1.setModel(null);
		car1.setColor(null);
		car1.setCreatedDate(null);
		car1.setLastModifiedDate(null);
		assertEquals(car1, car1);
		assertEquals(car1, car2);
		assertEquals(car1.hashCode(), car2.hashCode());
	}
	
	@Test
	public void equalsNull() {
		assertFalse(car1.equals(null));
	}
	
	@Test
	public void equalsNoncar() {
		assertFalse(car1.equals(new Object()));
	}
}
