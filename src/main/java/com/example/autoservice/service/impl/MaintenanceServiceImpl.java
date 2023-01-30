package com.example.autoservice.service.impl;

import com.example.autoservice.model.Maintenance;
import com.example.autoservice.repository.MaintenanceRepository;
import com.example.autoservice.service.MaintenanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance add(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void updateStatus(Long id, Maintenance.Status status) {
        Maintenance maintenance = maintenanceRepository.getReferenceById(id);
        maintenance.setStatus(status);
        update(maintenance);
    }

    @Override
    public List<Maintenance> getAllByMasterIdAndStatus(Long masterId, Maintenance.Status status) {
        return maintenanceRepository.getAllByMasterIdAndStatus(masterId, status);
    }
}
