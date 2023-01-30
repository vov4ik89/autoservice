package com.example.autoservice.dto.request;

import com.example.autoservice.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long carId;
    private String description;
    private LocalDate acceptDate;
    private BigDecimal finalCost;
    private LocalDate endDate;
    private List<Long> maintenanceIds;
    private List<Long> commodityIds;
    private Order.Status status;
}
