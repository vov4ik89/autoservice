package com.example.autoservice.dto.response;

import com.example.autoservice.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String description;
    private LocalDate acceptDate;
    private BigDecimal finalCost;
    private LocalDate endDate;
    private List<Long> maintenanceIds;
    private List<Long> commodityIds;
    private Order.Status status;
}
