package com.example.autoservice.dto.request;

import java.util.List;
import lombok.Getter;

@Getter
public class MasterRequestDto {
    private String name;
    private List<Long> complittedOrderIds;
}
