package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.MaintenanceMapper;
import com.example.autoservice.dto.request.MaintenanceRequestDto;
import com.example.autoservice.dto.response.MaintenanceResponseDto;
import com.example.autoservice.model.Maintenance;
import com.example.autoservice.service.MaintenanceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;
    private final MaintenanceMapper maintenanceMapper;

    public MaintenanceController(MaintenanceService maintenanceService,
                                 MaintenanceMapper maintenanceMapper) {
        this.maintenanceService = maintenanceService;
        this.maintenanceMapper = maintenanceMapper;
    }

    @PostMapping
    @ApiOperation("Add a new maintenance")
    public MaintenanceResponseDto create(@RequestBody MaintenanceRequestDto requestDto) {
        Maintenance maintenance = maintenanceMapper.mapToModel(requestDto);
        maintenanceService.add(maintenance);
        return maintenanceMapper.mapToDto(maintenance);
    }

    @PostMapping("/{id}")
    @ApiOperation("Update maintenance by id")
    public MaintenanceResponseDto update(@PathVariable Long id,
                                         @RequestBody MaintenanceRequestDto requestDto) {
        Maintenance maintenance = maintenanceMapper.mapToModel(requestDto);
        maintenance.setId(id);
        maintenanceService.update(maintenance);
        return maintenanceMapper.mapToDto(maintenance);
    }

    @GetMapping("/{id}/status")
    @ApiOperation("Update status by maintenance id")
    public MaintenanceResponseDto updateStatus(@PathVariable Long id,
                                               @RequestBody MaintenanceRequestDto requestDto) {
        Maintenance status = maintenanceMapper.mapToModel(requestDto);
        maintenanceService.updateStatus(id, status.getStatus());
        return maintenanceMapper.mapToDto(status);
    }
}
