-- V1__create_table_vehicle.sql
-- This migration creates the 'vehicles' table to store vehicle information.

CREATE TABLE vehicles (
    id BIGSERIAL PRIMARY KEY,
    plate VARCHAR(20) NOT NULL,
    model VARCHAR(100) NOT NULL,
    color VARCHAR(50),
    chassis VARCHAR(50) UNIQUE NOT NULL,
    year INT NOT NULL CHECK (year > 1900),
    price NUMERIC(15, 2) NOT NULL CHECK (price > 0)
);