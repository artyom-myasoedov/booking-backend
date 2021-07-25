ALTER TABLE booking.rooms_types_of_rent
    ALTER COLUMN price TYPE DECIMAL(15, 3) USING price::decimal;