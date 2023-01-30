package com.example.autoservice.service.impl;

import com.example.autoservice.model.Maintenance;
import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.service.MaintenanceService;
import com.example.autoservice.service.MasterService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private static final double SALARY_PERCENT = 0.4;
    private final MasterRepository masterRepository;
    private final MaintenanceService maintenanceService;

    public MasterServiceImpl(MasterRepository masterRepository,
                             MaintenanceService maintenanceService) {
        this.masterRepository = masterRepository;
        this.maintenanceService = maintenanceService;
    }

    @Override
    public Master add(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public List<Order> getOrders(Long masterId) {
        return masterRepository.getReferenceById(masterId).getComplittedOrders();
    }

    @Override
    public BigDecimal getSalary(Long masterId) {
        List<Maintenance> maintenances = maintenanceService
                .getAllByMasterIdAndStatus(masterId, Maintenance.Status.NOT_PAID);
        maintenances.forEach(maintenance ->
                maintenanceService.updateStatus(maintenance.getId(), Maintenance.Status.PAID));
        return maintenances.stream()
                .map(Maintenance::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal(SALARY_PERCENT));
    }
}
