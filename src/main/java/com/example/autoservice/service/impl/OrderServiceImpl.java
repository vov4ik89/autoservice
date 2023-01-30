package com.example.autoservice.service.impl;

import com.example.autoservice.model.Commodity;
import com.example.autoservice.model.Maintenance;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.OrderRepository;
import com.example.autoservice.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private static final double COMMODITY_DISCOUNT = 0.01;
    private static final double MAINTENANCE_DISCOUNT = 0.02;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addCommodity(Long orderId, Commodity commodity) {
        Order order = orderRepository.getReferenceById(orderId);
        order.getCommodities().add(commodity);
        return update(order);
    }

    @Override
    public void updateStatus(Long id, Order.Status status) {
        Order order = orderRepository.getReferenceById(id);
        if (status.equals(Order.Status.COMPLETED)
                || status.equals(Order.Status.NOT_COMPLETED)) {
            order.setEndDate(LocalDate.now());
        }
        order.setStatus(status);
        update(order);
    }

    @Override
    public BigDecimal calculatePrice(Long orderId) {
        Order order = orderRepository.getReferenceById(orderId);
        BigDecimal price = calculatePriceAfterDiscount(order);
        order.setFinalCost(price);
        update(order);
        return price;
    }

    private BigDecimal calculatePriceAfterDiscount(Order order) {
        int amountOrders = order.getCar().getOwner().getOrders().size();
        double commodityDiscount = amountOrders * COMMODITY_DISCOUNT;
        double maintenanceDiscount = amountOrders * MAINTENANCE_DISCOUNT;
        BigDecimal commodityPriceAfterDiscount = order.getCommodities().stream()
                .map(Commodity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal(1.0 - commodityDiscount));
        if (order.getMaintenances().size() > 0) {
            return order.getMaintenances().stream()
                    .map(Maintenance::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .multiply(new BigDecimal(1.0 - maintenanceDiscount))
                    .add(commodityPriceAfterDiscount);
        }
        return commodityPriceAfterDiscount;
    }
}
