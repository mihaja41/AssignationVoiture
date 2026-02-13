\c postgres;
drop table if exists reservation;
create database hotel_reservation;
\c hotel_reservation;

CREATE TABLE hotel (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

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
 
INSERT INTO hotel (name) VALUES
('Hotel Colbert, Antananarivo'),
('Carlton Madagascar, Antananarivo'),
('Palissandre Hotel & Spa, Antananarivo'),
('Royal Beach Hotel, Nosy Be'),
('Vanila Hotel & Spa, Nosy Be'),
('Anjajavy Le Lodge'),
('Princesse Bora Lodge & Spa, Sainte-Marie'),
('Isalo Rock Lodge'),
('Eden Lodge, Nosy Be'),
('La Varangue, Antananarivo');
