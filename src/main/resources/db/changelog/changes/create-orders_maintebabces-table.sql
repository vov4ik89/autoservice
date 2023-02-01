--liquibase formatted sql
--changeset <postgres>:<create-orders_maintenances-table>

CREATE TABLE IF NOT EXISTS orders_maintenances
(
    order_id   bigint not null CONSTRAINT orders_m_o_fk REFERENCES orders,
    maintenance_id bigint not null CONSTRAINT maintenances_uq UNIQUE
    CONSTRAINT orders_m_m_fk REFERENCES maintenances
);

--rollback DROP TABLE orders_maintenances;