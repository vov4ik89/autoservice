package com.example.autoservice.repository;

import com.example.autoservice.model.Maintenance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> getAllByMasterIdAndStatus(Long masterId, Maintenance.Status status);
}
