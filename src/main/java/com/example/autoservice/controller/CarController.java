package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.CarMapper;
import com.example.autoservice.dto.request.CarRequestDto;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    @ApiOperation("Add a new car")
    public CarResponseDto create(@RequestBody CarRequestDto requestDto) {
        Car car = carMapper.mapToModel(requestDto);
        carService.add(car);
        return carMapper.mapToDto(car);
    }

    @PostMapping("/{id}")
    @ApiOperation("Update car by id")
    public CarResponseDto update(@PathVariable Long id,
                                 @RequestBody CarRequestDto requestDto) {
        Car car = carMapper.mapToModel(requestDto);
        car.setId(id);
        carService.update(car);
        return carMapper.mapToDto(car);
    }
}
