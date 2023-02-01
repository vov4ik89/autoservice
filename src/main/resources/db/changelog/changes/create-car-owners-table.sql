--liquibase formatted sql
--changeset <postgres>:<create-car-owners-table>

CREATE TABLE IF NOT EXISTS car-owners
(
    id bigserial PRIMARY KEY
);

--rollback DROP TABLE car-owners;