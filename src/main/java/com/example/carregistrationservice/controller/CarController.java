package com.example.carregistrationservice.controller;

import com.example.carregistrationservice.entity.Car;
import com.example.carregistrationservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/get")
    public String test(){
        return CarService.getCarById();
    }

    @PostMapping("/post")
    public Car post(@RequestBody Car car){
        return carService.save(car);
    }

}
