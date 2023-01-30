package com.example.autoservice.service;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface MasterService {
    Master add(Master master);

    Master update(Master master);

    List<Order> getOrders(Long masterId);

    BigDecimal getSalary(Long masterId);
}
