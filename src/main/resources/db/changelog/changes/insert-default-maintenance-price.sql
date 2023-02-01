--liquibase formatted sql
--changeset <postgres>:<insert-default-maintenance-price.sql>

insert into maintenances (price) values (500);

--rollback DELETE FROM maintenances WHERE id = 1;
