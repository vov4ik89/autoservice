package com.example.autoservice.service;

import com.example.autoservice.model.CarOwner;
import com.example.autoservice.model.Order;
import java.util.List;

public interface CarOwnerService {
    CarOwner add(CarOwner carOwner);

    CarOwner update(CarOwner carOwner);

    List<Order> getOrders(Long carOwnerId);
}
