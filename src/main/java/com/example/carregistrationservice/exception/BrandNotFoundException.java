package com.example.carregistrationservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(String msg){
        super(msg);
    }
}
