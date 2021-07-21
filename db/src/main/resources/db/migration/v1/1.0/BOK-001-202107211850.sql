CREATE TABLE booking.roles
(
    role_id   SERIAL NOT NULL PRIMARY KEY,
    role_name VARCHAR(50)
);

ALTER TABLE booking.users
    ADD COLUMN role_id INTEGER REFERENCES booking.roles (role_id);

CREATE TABLE booking.equipments
(
    equipment_id   SERIAL NOT NULL PRIMARY KEY,
    equipment_name VARCHAR(255)
);

CREATE TABLE booking.rooms_equipments
(
    room_id      INTEGER NOT NULL REFERENCES booking.rooms (room_id),
    equipment_id INTEGER NOT NULL REFERENCES booking.equipments (equipment_id),
    number       INTEGER NOT NULL,
    PRIMARY KEY (room_id, equipment_id)
);

CREATE TABLE booking.room_reviews
(
    room_review_id SERIAL        NOT NULL PRIMARY KEY,
    room_id        INTEGER       NOT NULL REFERENCES booking.rooms (room_id),
    rating         INTEGER       NOT NULL,
    description    VARCHAR(1000) NOT NULL
);
