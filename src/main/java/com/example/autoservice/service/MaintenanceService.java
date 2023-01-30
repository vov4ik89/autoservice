package com.example.autoservice.service;

import com.example.autoservice.model.Maintenance;
import java.util.List;

public interface MaintenanceService {
    Maintenance add(Maintenance maintenance);

    Maintenance update(Maintenance maintenance);

    void updateStatus(Long id, Maintenance.Status status);

    List<Maintenance> getAllByMasterIdAndStatus(Long masterId, Maintenance.Status status);
}
