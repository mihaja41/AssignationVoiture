create database hotel_reservation;
\c hotel_reservation;

CREATE TABLE hotel (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);


drop table if exists reservation;
CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    hotel_id INT NOT NULL,
    customer_id varchar(10) NULL,
    passenger_nbr INT NOT NULL CHECK (passenger_nbr > 0),
    arrival_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT now(),

    CONSTRAINT fk_reservation_hotel
        FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);

insert into reservation (hotel_id, customer_id, passenger_nbr, arrival_date) values
(3, '4631', 11, '2026-02-05 00:01:00'),
(3, '4394', 1, '2026-02-05 23:55:00'),
(1, '8054', 2, '2026-02-09 10:17:00'),
(2, '1432', 4, '2026-02-01 15:25:00'),
(1, '7861', 4, '2026-01-28 07:11:00'),
(1, '3308', 5, '2026-01-28 07:45:00'),
(2, '4484', 13, '2026-02-28 08:25:00'),
(2, '9687', 8, '2026-02-28 13:00:00'),
(1, '6302', 7, '2026-02-15 13:00:00'),
(4, '8640', 1, '2026-02-18 22:55:00');

INSERT INTO hotel (name) VALUES
('Hotel Colbert, Antananarivo'),
('Novotel Madagascar, Antananarivo'),
('Ibis Madagascar, Antananarivo'),
('Lokanga Madagascar, Antananarivo') ; 