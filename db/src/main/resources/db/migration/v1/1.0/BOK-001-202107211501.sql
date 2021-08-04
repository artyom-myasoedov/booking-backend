CREATE TABLE booking.rooms
(
    room_id            SERIAL       NOT NULL PRIMARY KEY,
    square             INTEGER      NOT NULL,
    landlord_id        INTEGER      NOT NULL REFERENCES booking.users (user_id),
    type               VARCHAR(255) NOT NULL,
    capacity           INTEGER      NOT NULL,
    admin_confirmation VARCHAR(255) NOT NULL,
    address            VARCHAR(255) NOT NULL,
    description        VARCHAR(1000),
    min_rental_period  INTERVAL     NOT NULL
);

CREATE TABLE booking.bookings
(
    booking_id        SERIAL    NOT NULL PRIMARY KEY,
    room_id           INTEGER   NOT NULL REFERENCES booking.rooms (room_id),
    tenant_id         INTEGER   NOT NULL REFERENCES booking.users (user_id),
    rental_period     INTEGER   NOT NULL,
    rental_start_date TIMESTAMP NOT NULL
);

CREATE TABLE booking.types_of_rent
(
    type_of_rent_id SERIAL         NOT NULL PRIMARY KEY,
    room_id         INTEGER        NOT NULL REFERENCES booking.rooms (room_id),
    type_of_rent    VARCHAR(255)   NOT NULL,
    price           DECIMAL(12, 3) NOT NULL
);

CREATE TABLE booking.room_photos
(
    room_photo_id SERIAL       NOT NULL PRIMARY KEY,
    room_id       INTEGER      NOT NULL REFERENCES booking.rooms (room_id),
    photo_url     VARCHAR(255) NOT NULL
);
