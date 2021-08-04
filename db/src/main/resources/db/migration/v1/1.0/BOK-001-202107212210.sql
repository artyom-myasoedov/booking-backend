ALTER TABLE booking.bookings
    DROP CONSTRAINT bookings_room_id_fkey,
    ADD CONSTRAINT bookings_room_id_fkey
        FOREIGN KEY (room_id)
            REFERENCES booking.rooms (room_id)
            ON DELETE CASCADE;

ALTER TABLE booking.bookings
    DROP CONSTRAINT bookings_tenant_id_fkey,
    ADD CONSTRAINT bookings_tenant_id_fkey
        FOREIGN KEY (tenant_id)
            REFERENCES booking.users (user_id)
            ON DELETE CASCADE;

ALTER TABLE booking.room_photos
    DROP CONSTRAINT room_photos_room_id_fkey,
    ADD CONSTRAINT room_photos_room_id_fkey
        FOREIGN KEY (room_id)
            REFERENCES booking.rooms (room_id)
            ON DELETE CASCADE;

ALTER TABLE booking.room_reviews
    ADD COLUMN author_user_id INTEGER NOT NULL REFERENCES booking.users (user_id);

ALTER TABLE booking.room_reviews
    DROP CONSTRAINT room_reviews_room_id_fkey,
    ADD CONSTRAINT room_reviews_room_id_fkey
        FOREIGN KEY (room_id)
            REFERENCES booking.rooms (room_id)
            ON DELETE CASCADE;

ALTER TABLE booking.rooms
    DROP COLUMN min_rental_period,
    ADD COLUMN min_rental_period INTEGER NOT NULL;

ALTER TABLE booking.rooms
    DROP CONSTRAINT rooms_landlord_id_fkey,
    ADD CONSTRAINT rooms_landlord_id_fkey
        FOREIGN KEY (landlord_id)
            REFERENCES booking.users (user_id)
            ON DELETE CASCADE;

ALTER TABLE booking.rooms_equipments
    DROP CONSTRAINT rooms_equipments_equipment_id_fkey,
    ADD CONSTRAINT rooms_equipments_equipment_id_fkey
        FOREIGN KEY (equipment_id)
            REFERENCES booking.equipments (equipment_id)
            ON DELETE CASCADE;

ALTER TABLE booking.rooms_equipments
    DROP CONSTRAINT rooms_equipments_room_id_fkey,
    ADD CONSTRAINT rooms_equipments_room_id_fkey
        FOREIGN KEY (room_id)
            REFERENCES booking.rooms (room_id)
            ON DELETE CASCADE;

ALTER TABLE booking.user_ratings
    DROP CONSTRAINT user_ratings_author_user_id_fkey,
    ADD CONSTRAINT user_ratings_author_user_id_fkey
        FOREIGN KEY (author_user_id)
            REFERENCES booking.users (user_id)
            ON DELETE CASCADE;

ALTER TABLE booking.types_of_rent
    DROP COLUMN room_id,
    DROP COLUMN price;

ALTER TABLE booking.types_of_rent
    RENAME COLUMN type_of_rent TO name_of_rent_type;

CREATE TABLE booking.rooms_types_of_rent
(
    room_id         INTEGER NOT NULL REFERENCES booking.rooms (room_id) ON DELETE CASCADE,
    type_of_rent_id INTEGER NOT NULL REFERENCES booking.types_of_rent (type_of_rent_id) ON DELETE CASCADE,
    price           INTEGER NOT NULL,
    PRIMARY KEY (room_id, type_of_rent_id)
);




