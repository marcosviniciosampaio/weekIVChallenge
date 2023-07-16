package com.example.carregistrationservice.controller;

import com.example.carregistrationservice.dto.CarDtoRequest;
import com.example.carregistrationservice.dto.CarDtoResponse;
import com.example.carregistrationservice.entity.Car;
import com.example.carregistrationservice.exception.ApiRequestException;
import com.example.carregistrationservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/post")
    public Car post(@RequestBody CarDtoRequest carDtoRequest){
        if (carDtoRequest.getBrand().equalsIgnoreCase(("ford")) || (carDtoRequest.getBrand().equalsIgnoreCase(("bmw"))) || (carDtoRequest.getBrand().equalsIgnoreCase(("chevrolet"))) || (carDtoRequest.getBrand().equalsIgnoreCase(("volvo")))) {
            return carService.save(carDtoRequest);
        }else{
            throw new ApiRequestException(" Invalid Brand. ");
        }
    }

    @GetMapping ("/get/{id}")
    public CarDtoResponse get(@PathVariable Long id) {
        return carService.getCarById(id);
    }
}
