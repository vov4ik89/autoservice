package com.example.autoservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private String description;
    @Column(name = "accept_time")
    private LocalDate acceptDate;
    @OneToMany
    @JoinTable(name = "orders_maintenances",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "maintenance_id"))
    private List<Maintenance> maintenances;
    @OneToMany
    @JoinTable(name = "orders_commodities",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "commodity_id"))
    private List<Commodity> commodities;
    private Status status;
    private BigDecimal finalCost;
    @Column(name = "end_time")
    private LocalDate endDate;

    public enum Status {
        ACCEPT,
        PROGRESS,
        COMPLETED,
        NOT_COMPLETED,
        PAID
    }
}
