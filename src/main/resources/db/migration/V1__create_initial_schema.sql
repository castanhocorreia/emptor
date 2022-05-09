CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE addresses
(
    id            UUID         NOT NULL,
    resident_id   UUID         NOT NULL,
    post_code     VARCHAR(255) NOT NULL,
    street_name   VARCHAR(255) NOT NULL,
    street_number VARCHAR(255),
    city          VARCHAR(255) NOT NULL,
    state         VARCHAR(255),
    country       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_addresses PRIMARY KEY (id)
);

CREATE TABLE customers
(
    id                 UUID         NOT NULL,
    full_name          VARCHAR(255) NOT NULL,
    birth_date         date         NOT NULL,
    email              VARCHAR(255) NOT NULL,
    phone_number       VARCHAR(255),
    created_date       TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    last_modified_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

ALTER TABLE addresses
    ADD CONSTRAINT FK_ADDRESSES_ON_RESIDENT FOREIGN KEY (resident_id) REFERENCES customers (id);