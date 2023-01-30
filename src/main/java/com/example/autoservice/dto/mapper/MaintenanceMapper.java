package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.MaintenanceRequestDto;
import com.example.autoservice.dto.response.MaintenanceResponseDto;
import com.example.autoservice.model.Maintenance;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceMapper {
    private final MasterRepository masterRepository;
    private final OrderRepository orderRepository;

    public MaintenanceMapper(MasterRepository masterRepository,
                             OrderRepository orderRepository) {
        this.masterRepository = masterRepository;
        this.orderRepository = orderRepository;
    }

    public Maintenance mapToModel(MaintenanceRequestDto dto) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaster(masterRepository.getReferenceById(dto.getMasterId()));
        maintenance.setOrder(orderRepository.getReferenceById(dto.getOrderId()));
        maintenance.setPrice(dto.getPrice());
        maintenance.setStatus(dto.getStatus());
        return maintenance;
    }

    public MaintenanceResponseDto mapToDto(Maintenance maintenance) {
        MaintenanceResponseDto dto = new MaintenanceResponseDto();
        dto.setId(maintenance.getId());
        dto.setMasterId(maintenance.getMaster().getId());
        dto.setOrderId(maintenance.getOrder().getId());
        dto.setPrice(maintenance.getPrice());
        dto.setStatus(maintenance.getStatus());
        return dto;
    }
}
