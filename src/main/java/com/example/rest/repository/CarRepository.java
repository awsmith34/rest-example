package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
