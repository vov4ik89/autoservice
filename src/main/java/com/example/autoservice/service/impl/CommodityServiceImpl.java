package com.example.autoservice.service.impl;

import com.example.autoservice.model.Commodity;
import com.example.autoservice.repository.CommodityRepository;
import com.example.autoservice.service.CommodityService;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {
    private final CommodityRepository commodityRepository;

    public CommodityServiceImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public Commodity add(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    @Override
    public Commodity update(Commodity commodity) {
        return commodityRepository.save(commodity);
    }
}
