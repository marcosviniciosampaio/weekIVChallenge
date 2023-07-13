package com.example.carregistrationservice.service;

import com.example.carregistrationservice.entity.Car;
import com.example.carregistrationservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public Car save(Car car){
        carRepository.save(car);
        return car;
    }

    public static String getCarById() {
        return "Inside of Service";
    }

}
