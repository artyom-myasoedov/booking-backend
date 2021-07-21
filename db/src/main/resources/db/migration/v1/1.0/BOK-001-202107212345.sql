CREATE TABLE booking.room_types
(
    room_type_id   SERIAL      NOT NULL PRIMARY KEY,
    room_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE booking.room_statuses
(
    room_status_id   SERIAL      NOT NULL PRIMARY KEY,
    room_status_name VARCHAR(50) NOT NULL
);

ALTER TABLE booking.rooms
    RENAME COLUMN admin_confirmation to status;

ALTER TABLE booking.rooms
    ALTER COLUMN type TYPE INTEGER USING type::INTEGER,
    ALTER COLUMN status TYPE INTEGER USING rooms.status::INTEGER,
    ADD CONSTRAINT rooms_type_fkey
        FOREIGN KEY (type)
            REFERENCES booking.room_types (room_type_id),
    ADD CONSTRAINT rooms_status_fkey
        FOREIGN KEY (status)
            REFERENCES booking.room_statuses (room_status_id);