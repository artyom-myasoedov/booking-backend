CREATE SCHEMA booking;

CREATE TABLE booking.admins
(
    admin_id   SERIAL      NOT NULL PRIMARY KEY,
    username   VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    password   VARCHAR(50) NOT NULL,
    photo_path VARCHAR(255)
);

CREATE TABLE booking.landlords
(
    landlord_id  SERIAL      NOT NULL PRIMARY KEY,
    username     VARCHAR(50) NOT NULL,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    password     VARCHAR(50) NOT NULL,
    photo_path   VARCHAR(255),
    phone_number VARCHAR(20) NULL,
    email        VARCHAR(50) NULL
);

CREATE TABLE booking.landlord_ratings
(
    landlord_rating_id SERIAL  NOT NULL PRIMARY KEY,
    landlord_id        INTEGER NOT NULL REFERENCES booking.landlords (landlord_id),
    rating             INTEGER NOT NULL,
    description        VARCHAR(1000)
);

CREATE TABLE booking.clients
(
    client_id    SERIAL      NOT NULL PRIMARY KEY,
    username     VARCHAR(50) NOT NULL,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    password     VARCHAR(50) NOT NULL,
    photo_path   VARCHAR(255),
    phone_number VARCHAR(20) NULL,
    email        VARCHAR(50) NULL
);

CREATE TABLE booking.client_ratings
(
    client_rating_id SERIAL  NOT NULL PRIMARY KEY,
    client_id        INTEGER NOT NULL REFERENCES booking.clients (client_id),
    rating           INTEGER NOT NULL,
    description      VARCHAR(1000)
);
