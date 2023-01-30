package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.OrderRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper {
    private final OrderRepository orderRepository;

    public MasterMapper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Master mapToModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setName(dto.getName());
        master.setComplittedOrders(dto.getComplittedOrderIds().stream()
                .map(orderRepository::getReferenceById)
                .collect(Collectors.toList()));
        return master;
    }

    public MasterResponseDto mapToDto(Master master) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(master.getId());
        dto.setName(master.getName());
        dto.setComplittedOrderIds(master.getComplittedOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
