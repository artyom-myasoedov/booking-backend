DROP TABLE booking.equipments CASCADE;

ALTER TABLE booking.rooms_equipments
    ALTER COLUMN number TYPE VARCHAR(250) USING number::VARCHAR,
    ALTER COLUMN equipment_id TYPE VARCHAR(250) USING equipment_id::VARCHAR;

ALTER TABLE booking.rooms_equipments
    RENAME COLUMN number TO description;

ALTER TABLE booking.rooms_equipments
    RENAME COLUMN equipment_id TO equipment_name;