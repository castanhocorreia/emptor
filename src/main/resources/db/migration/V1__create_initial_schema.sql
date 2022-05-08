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

CREATE TABLE addresses
(
    id            UUID         NOT NULL,
    post_code     VARCHAR(255) NOT NULL,
    street_name   VARCHAR(255) NOT NULL,
    street_number VARCHAR(255),
    city          VARCHAR(255) NOT NULL,
    state         VARCHAR(255) NOT NULL,
    country       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_addresses PRIMARY KEY (id)
);

CREATE TABLE customers_addresses
(
    customer_id UUID NOT NULL,
    address_id  UUID NOT NULL,
    CONSTRAINT pk_customers_addresses PRIMARY KEY (customer_id, address_id)
);

ALTER TABLE customers_addresses
    ADD CONSTRAINT fk_customers_on_customers_addresses FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE customers_addresses
    ADD CONSTRAINT fk_addresses_on_customers_addresses FOREIGN KEY (address_id) REFERENCES addresses (id);