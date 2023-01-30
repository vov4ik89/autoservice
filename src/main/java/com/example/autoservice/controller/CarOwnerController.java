package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.CarOwnerMapper;
import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.request.CarOwnerRequestDto;
import com.example.autoservice.dto.response.CarOwnerResponseDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.CarOwner;
import com.example.autoservice.service.CarOwnerService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-owners")
public class CarOwnerController {
    private final CarOwnerService carOwnerService;
    private final CarOwnerMapper carOwnerMapper;
    private final OrderMapper orderMapper;

    public CarOwnerController(CarOwnerService carOwnerService,
                              CarOwnerMapper carOwnerMapper,
                              OrderMapper orderMapper) {
        this.carOwnerService = carOwnerService;
        this.carOwnerMapper = carOwnerMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    @ApiOperation("Add a new car owner")
    public CarOwnerResponseDto create(@RequestBody CarOwnerRequestDto requestDto) {
        CarOwner carOwner = carOwnerMapper.mapToModel(requestDto);
        carOwnerService.add(carOwner);
        return carOwnerMapper.mapToDto(carOwner);
    }

    @PostMapping("/{id}")
    @ApiOperation("Update car owner by id")
    public CarOwnerResponseDto update(@PathVariable Long id,
                                      @RequestBody CarOwnerRequestDto requestDto) {
        CarOwner carOwner = carOwnerMapper.mapToModel(requestDto);
        carOwner.setId(id);
        carOwnerService.update(carOwner);
        return carOwnerMapper.mapToDto(carOwner);
    }

    @PostMapping("/{id}/orders")
    @ApiOperation("Get all orders by car owner id")
    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
        return carOwnerService.getOrders(id)
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
