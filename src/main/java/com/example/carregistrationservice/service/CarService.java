package com.example.carregistrationservice.service;

import com.example.carregistrationservice.dto.CarDtoRequest;
import com.example.carregistrationservice.dto.CarDtoResponse;
import com.example.carregistrationservice.entity.Car;
import com.example.carregistrationservice.exception.CarNotFoundException;
import com.example.carregistrationservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {


    @Autowired
    CarRepository carRepository;
    CarDtoResponse carDtoResponse;
    Car car;

    public Car save(CarDtoRequest carDtoRequest){

        Car car = new Car(
                null,
                carDtoRequest.getName(),
                carDtoRequest.getBrand(),
                carDtoRequest.getColor(),
                carDtoRequest.getFabricationYear()
        );

        carRepository.save(car);
        return car;
    }

    public CarDtoResponse getCarById(Long idChassi) {
        Car car =  carRepository
                .findById(idChassi)
                .orElseThrow(() -> new CarNotFoundException("Car could not be found"));

        CarDtoResponse carDtoResponse = new CarDtoResponse(
                car.getIdChassi(),
                car.getName(),
                car.getBrand(),
                car.getColor(),
                car.getFabricationYear());
        return carDtoResponse;
    }

}
