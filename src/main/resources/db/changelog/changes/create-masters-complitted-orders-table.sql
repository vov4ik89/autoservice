--liquibase formatted sql
--changeset <postgres>:<create-masters-complitted-orders-table>

CREATE TABLE IF NOT EXISTS masters_orders
(
    master_id bigint NOT NULL CONSTRAINT master_fk REFERENCES masters,
    complitted_order_id bigint NOT NULL CONSTRAINT order_fk REFERENCES orders
);

--rollback DROP TABLE masters_complitted_orders;