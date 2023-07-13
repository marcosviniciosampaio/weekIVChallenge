package com.example.carregistrationservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "CAR_TB")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChassi;
    private String name;

    public Car() {
    }

    public Car(long idChassi, String name) {
        this.idChassi = idChassi;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(long idChassi) {
        this.idChassi = idChassi;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idChassi=" + idChassi +
                ", name='" + name + '\'' +
                '}';
    }
}
