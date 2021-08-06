ALTER TABLE booking.rooms_equipments
    DROP CONSTRAINT rooms_equipments_pkey,
    ADD COLUMN equipment_id SERIAL PRIMARY KEY;
