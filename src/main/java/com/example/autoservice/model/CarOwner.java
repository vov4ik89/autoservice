package com.example.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "car_owners")
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinTable(name = "car_owners_cars",
            joinColumns = @JoinColumn(name = "car_owner_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;
    @OneToMany
    @JoinTable(name = "car_owners_orders",
            joinColumns = @JoinColumn(name = "car_owner_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
}
