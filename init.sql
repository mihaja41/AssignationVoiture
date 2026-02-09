-- =========================
-- INIT DATABASE
-- =========================
DROP DATABASE IF EXISTS hotel_reservation;
CREATE DATABASE hotel_reservation;

\c hotel_reservation;

-- =========================
-- TABLE HOTEL
-- =========================
CREATE TABLE hotel (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- =========================
-- TABLE RESERVATION
-- =========================
DROP TABLE IF EXISTS reservation;

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    hotel_id INT NOT NULL,
    customer_id VARCHAR(10),
    passenger_nbr INT NOT NULL CHECK (passenger_nbr > 0),
    arrival_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT now(),

    CONSTRAINT fk_reservation_hotel
        FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);



SELECT * FROM hotel;
SELECT * FROM reservation;


