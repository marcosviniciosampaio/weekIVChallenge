package com.example.carregistrationservice.service;

import com.example.carregistrationservice.dto.CarDtoRequest;
import com.example.carregistrationservice.dto.CarDtoResponse;
import com.example.carregistrationservice.entity.Car;
import com.example.carregistrationservice.exception.ApiRequestException;
import com.example.carregistrationservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class CarService {

    @Autowired
    CarRepository carRepository;
    public Car save(CarDtoRequest carDtoRequest) {
          Car car = new Car(
                null,
                carDtoRequest.getName(),
                carDtoRequest.getBrand(),
                carDtoRequest.getColor(),
                carDtoRequest.getFabricationYear()
          );
          if(carDtoRequest.getName() != null && carDtoRequest.getBrand() != null && carDtoRequest.getColor() != null && carDtoRequest.getFabricationYear() != null) {
              if ((carDtoRequest.getBrand().equalsIgnoreCase(("ford")) ||
                      (carDtoRequest.getBrand().equalsIgnoreCase(("bmw"))) ||
                      (carDtoRequest.getBrand().equalsIgnoreCase(("chevrolet"))) ||
                      (carDtoRequest.getBrand().equalsIgnoreCase(("volvo"))))){
                  carRepository.save(car);
                  return car;
              }else{
                  throw new ApiRequestException(" Invalid brand.");
              }
        }else{
            throw new ApiRequestException("Null not allowed.");
          }
    }

    public CarDtoResponse getCarById(Long idChassi) {
        Car car =  carRepository
                .findById(idChassi)
                .orElseThrow(() -> new ApiRequestException("Car could not be found"));

        CarDtoResponse carDtoResponse = new CarDtoResponse(
                car.getIdChassi(),
                car.getName(),
                car.getBrand(),
                car.getColor(),
                car.getFabricationYear());
        return carDtoResponse;
    }

}
