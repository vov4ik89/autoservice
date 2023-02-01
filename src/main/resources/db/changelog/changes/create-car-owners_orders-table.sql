--liquibase formatted sql
--changeset <postgres>:<create-car-owners_orders-table>

CREATE TABLE IF NOT EXISTS car-owners_orders
(
    car-owner_id bigint not null CONSTRAINT car-owners_orders_coo_fk
    REFERENCES car-owners,
    order_id bigint not null CONSTRAINT order_uq UNIQUE
    CONSTRAINT car-owners_orders_coo_fk
    REFERENCES orders
);
--rollback DROP TABLE car-owners_orders;