package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Commodity;
import com.example.autoservice.model.Maintenance;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.CommodityRepository;
import com.example.autoservice.repository.MaintenanceRepository;
import com.example.autoservice.service.CarService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final CommodityRepository commodityRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final CarService carService;

    public OrderMapper(CommodityRepository commodityRepository,
                       MaintenanceRepository maintenanceRepository,
                       CarService carService) {
        this.commodityRepository = commodityRepository;
        this.maintenanceRepository = maintenanceRepository;
        this.carService = carService;
    }

    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setDescription(dto.getDescription());
        order.setStatus(dto.getStatus());
        order.setCar(carService.get(dto.getCarId()));
        order.setFinalCost(dto.getFinalCost());
        order.setAcceptDate(dto.getAcceptDate());
        order.setEndDate(dto.getEndDate());
        order.setCommodities(dto.getCommodityIds().stream()
                .map(commodityRepository::getReferenceById)
                .collect(Collectors.toList()));
        order.setMaintenances(dto.getMaintenanceIds().stream()
                .map(maintenanceRepository::getReferenceById)
                .collect(Collectors.toList()));
        return order;
    }

    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setDescription(order.getDescription());
        dto.setStatus(order.getStatus());
        dto.setCarId(order.getCar().getId());
        dto.setFinalCost(order.getFinalCost());
        dto.setAcceptDate(order.getAcceptDate());
        dto.setEndDate(order.getEndDate());
        dto.setCommodityIds(order.getCommodities().stream()
                .map(Commodity::getId)
                .collect(Collectors.toList()));
        dto.setMaintenanceIds(order.getMaintenances().stream()
                .map(Maintenance::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
