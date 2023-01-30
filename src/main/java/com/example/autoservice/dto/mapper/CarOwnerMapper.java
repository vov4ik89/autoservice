package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.CarOwnerRequestDto;
import com.example.autoservice.dto.response.CarOwnerResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.CarOwner;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.CarRepository;
import com.example.autoservice.repository.OrderRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarOwnerMapper {
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

    public CarOwnerMapper(CarRepository carRepository, OrderRepository orderRepository) {
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
    }

    public CarOwner mapToModel(CarOwnerRequestDto dto) {
        CarOwner carOwner = new CarOwner();
        carOwner.setCars(dto.getCarIds().stream()
                .map(carRepository::getReferenceById)
                .collect(Collectors.toList()));
        carOwner.setOrders(dto.getOrderIds().stream()
                .map(orderRepository::getReferenceById)
                .collect(Collectors.toList()));
        return carOwner;
    }

    public CarOwnerResponseDto mapToDto(CarOwner carOwner) {
        CarOwnerResponseDto dto = new CarOwnerResponseDto();
        dto.setId(carOwner.getId());
        dto.setCarIds(carOwner.getCars().stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        dto.setOrderIds(carOwner.getOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
