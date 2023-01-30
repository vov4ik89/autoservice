package com.example.autoservice.service;

import com.example.autoservice.model.Car;

public interface CarService {
    Car add(Car car);

    Car update(Car car);

    Car get(Long id);
}
