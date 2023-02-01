--liquibase formatted sql
--changeset <postgres>:<create-maintenances-table>

CREATE TABLE IF NOT EXISTS maintenances
(
    id        bigserial PRIMARY KEY,
    price     numeric(19, 2),
    status    varchar(255),
    master_id bigint CONSTRAINT maintenances_m_fk REFERENCES masters,
    order_id  bigint CONSTRAINT maintenances_o_fk REFERENCES orders
    );

--rollback DROP TABLE maintenances;