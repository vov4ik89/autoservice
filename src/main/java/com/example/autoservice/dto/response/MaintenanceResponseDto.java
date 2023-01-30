package com.example.autoservice.dto.response;

import com.example.autoservice.model.Maintenance;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private Maintenance.Status status;
}
