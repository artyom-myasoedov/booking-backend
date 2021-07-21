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


CREATE TABLE booking.users
(
    user_id      SERIAL      NOT NULL PRIMARY KEY,
    username     VARCHAR(50) NOT NULL,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    password     VARCHAR(50) NOT NULL,
    photo_path   VARCHAR(255),
    phone_number VARCHAR(20) NULL,
    email        VARCHAR(50) NULL

);

CREATE TABLE booking.user_ratings
(
    user_rating_id SERIAL  NOT NULL PRIMARY KEY,
    target_user_id INTEGER NOT NULL REFERENCES booking.users (user_id),
    author_user_id INTEGER NOT NULL REFERENCES booking.users (user_id),
    rating         INTEGER NOT NULL,
    description    VARCHAR(1000)
);