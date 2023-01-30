package com.example.autoservice.dto.request;

import com.example.autoservice.model.Maintenance;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class MaintenanceRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private Maintenance.Status status;
}
