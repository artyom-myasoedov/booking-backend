ALTER TABLE booking.room_photos
    ALTER COLUMN photo_url TYPE BYTEA USING photo_url::BYTEA;

ALTER TABLE booking.room_photos
    RENAME COLUMN photo_url TO photo;

ALTER TABLE booking.admins
    ALTER COLUMN photo_path TYPE BYTEA USING photo_path::BYTEA,
    ALTER COLUMN password TYPE VARCHAR(60);

ALTER TABLE booking.users
    ALTER COLUMN photo_path TYPE BYTEA USING photo_path::BYTEA,
    ALTER COLUMN password TYPE VARCHAR(60);

ALTER TABLE booking.admins
    RENAME COLUMN photo_path TO photo;

ALTER TABLE booking.users
    RENAME COLUMN photo_path TO photo;


