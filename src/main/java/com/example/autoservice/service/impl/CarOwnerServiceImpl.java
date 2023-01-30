package com.example.autoservice.service.impl;

import com.example.autoservice.model.CarOwner;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.CarOwnerRepository;
import com.example.autoservice.service.CarOwnerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {
    private final CarOwnerRepository carOwnerRepository;

    public CarOwnerServiceImpl(CarOwnerRepository carOwnerRepository) {
        this.carOwnerRepository = carOwnerRepository;
    }

    @Override
    public CarOwner add(CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    @Override
    public CarOwner update(CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    @Override
    public List<Order> getOrders(Long carOwnerId) {
        return carOwnerRepository.getReferenceById(carOwnerId).getOrders();
    }
}
