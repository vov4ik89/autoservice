package com.example.autoservice.service;

import com.example.autoservice.model.Commodity;
import com.example.autoservice.model.Order;
import java.math.BigDecimal;

public interface OrderService {
    Order add(Order order);

    Order update(Order order);

    Order addCommodity(Long orderId, Commodity commodity);

    void updateStatus(Long orderId, Order.Status status);

    BigDecimal calculatePrice(Long orderId);
}
