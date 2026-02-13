CREATE TABLE vehicule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reference VARCHAR(100) NOT NULL,
    nb_place INT NOT NULL,
    type_carburant ENUM('D','Es','H','El') NOT NULL
);

CREATE TABLE token (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(255) NOT NULL,
    date_expiration DATETIME NOT NULL
);

CREATE INDEX idx_token_value ON token(token);

