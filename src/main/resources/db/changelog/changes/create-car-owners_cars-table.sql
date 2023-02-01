--liquibase formatted sql
--changeset <postgres>:<create-car-owners_cars-table>

CREATE TABLE IF NOT EXISTS car-owners_cars
(
    car-owner_id bigint not null CONSTRAINT car-owners_cars_co_fk REFERENCES car-owners,
    car_id   bigint not null CONSTRAINT car_uq UNIQUE
    CONSTRAINT car-owners_cars_c_fk REFERENCES cars
);

--rollback DROP TABLE car-owners_cars;