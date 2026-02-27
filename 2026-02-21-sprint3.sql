-- SPRINT 3 - Nouvelles tables pour Planification et Attribution Véhicules

USE hotel_reservation;

CREATE TABLE IF NOT EXISTS lieu (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    libelle VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table DISTANCE (distances entre lieux)
CREATE TABLE IF NOT EXISTS distance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_lieu_id BIGINT NOT NULL,
    to_lieu_id BIGINT NOT NULL,
    km_distance DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_distance_from FOREIGN KEY (from_lieu_id) REFERENCES lieu(id) ON DELETE CASCADE,
    CONSTRAINT fk_distance_to FOREIGN KEY (to_lieu_id) REFERENCES lieu(id) ON DELETE CASCADE,
    UNIQUE KEY unique_distance_pair (from_lieu_id, to_lieu_id)
);

-- Modification table RESERVATION (ajout lieu liaison + statut assignation)
ALTER TABLE reservation ADD COLUMN IF NOT EXISTS lieu_destination_id BIGINT;
ALTER TABLE reservation ADD COLUMN IF NOT EXISTS vehicule_id BIGINT;
ALTER TABLE reservation ADD COLUMN IF NOT EXISTS statut VARCHAR(50) DEFAULT 'NON_ASSIGNE';
ALTER TABLE reservation ADD COLUMN IF NOT EXISTS heure_depart TIMESTAMP;
ALTER TABLE reservation ADD COLUMN IF NOT EXISTS heure_arrivee TIMESTAMP;
ALTER TABLE reservation ADD COLUMN IF NOT EXISTS heure_retour TIMESTAMP;

-- Foreign keys pour reservation
ALTER TABLE reservation ADD CONSTRAINT IF NOT EXISTS fk_reservation_lieu 
    FOREIGN KEY (lieu_destination_id) REFERENCES lieu(id) ON DELETE SET NULL;
ALTER TABLE reservation ADD CONSTRAINT IF NOT EXISTS fk_reservation_vehicule 
    FOREIGN KEY (vehicule_id) REFERENCES vehicule(id) ON DELETE SET NULL;

-- Index pour optimisation requêtes
CREATE INDEX IF NOT EXISTS idx_reservation_statut ON reservation(statut);
CREATE INDEX IF NOT EXISTS idx_reservation_date_depart ON reservation(heure_depart);
CREATE INDEX IF NOT EXISTS idx_reservation_vehicule ON reservation(vehicule_id);
CREATE INDEX IF NOT EXISTS idx_lieu_code ON lieu(code);

-- ==========================================
-- DONNÉES DE TEST - SPRINT 3
-- ==========================================

INSERT INTO lieu (code, libelle) VALUES
('COLBERT', 'Colbert, Antananarivo'),
('IVATO', 'Ivato Airport, Antananarivo'),
('NOSY_BE', 'Nosy Be Airport'),
('SAINTE_MARIE', 'Sainte-Marie Airport'),
('ANTALAHA', 'Antalaha Airport'),
('SAMBAVA', 'Sambava Airport');

INSERT INTO distance (from_lieu_id, to_lieu_id, km_distance) VALUES
(1, 2, 35.50),   -- Colbert -> Ivato
(2, 1, 35.50),   -- Ivato -> Colbert
(1, 3, 250.00),  -- Colbert -> Nosy Be
(3, 1, 250.00),  -- Nosy Be -> Colbert
(1, 4, 180.00),  -- Colbert -> Sainte-Marie
(4, 1, 180.00),  -- Sainte-Marie -> Colbert
(2, 3, 285.00),  -- Ivato -> Nosy Be
(3, 2, 285.00);  -- Nosy Be -> Ivato

-- Données test réservation avec lieu
INSERT INTO reservation (hotel_id, customer_id, passenger_nbr, arrival_date, lieu_destination_id, statut, heure_depart, heure_arrivee, heure_retour)
SELECT 
    h.id,
    'CLI001',
    4,
    '2026-03-15 14:00:00',
    l.id,
    'NON_ASSIGNE',
    '2026-03-15 08:00:00',
    '2026-03-15 14:00:00',
    '2026-03-16 10:00:00'
FROM hotel h, lieu l 
WHERE h.name LIKE 'Hotel Colbert%' AND l.code = 'NOSY_BE' LIMIT 1;

-- Données test véhicule
INSERT IGNORE INTO vehicule (reference, nb_place, type_carburant) VALUES
('AV-001', 4, 'D'),
('AV-002', 4, 'Es'),
('AV-003', 7, 'D'),
('AV-004', 5, 'H'),
('AV-005', 8, 'D');

-- ==========================================
-- VÉRIFICATION DONNÉES
-- ==========================================

-- SELECT COUNT(*) as total_lieux FROM lieu;
-- SELECT COUNT(*) as total_distances FROM distance;
-- SELECT COUNT(*) as total_vehicules FROM vehicule;
-- SELECT COUNT(*) as total_reservations FROM reservation WHERE statut = 'NON_ASSIGNE';
