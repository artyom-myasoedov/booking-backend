ALTER TABLE booking.rooms
    ADD COLUMN IF NOT EXISTS room_rating DECIMAL NOT NULL DEFAULT 0;

CREATE OR REPLACE FUNCTION update_rating() RETURNS TRIGGER AS
'
    DECLARE
        my_room_id INTEGER;
        temp_rate NUMERIC;
    BEGIN
        IF TG_OP = ''DELETE'' THEN
            my_room_id = OLD.rated_entity_id;
        END IF;
        IF TG_OP = ''UPDATE'' OR TG_OP = ''INSERT'' THEN
            my_room_id = NEW.rated_entity_id;
        END IF;
        temp_rate = AVG(rating)
                    FROM booking.reviews
                    WHERE rated_entity_id = my_room_id
                      AND review_target_id = 2;
        UPDATE booking.rooms
        SET room_rating = temp_rate WHERE room_id = my_room_id;
        IF TG_OP = ''DELETE'' THEN
            RETURN OLD;
        END IF;
        IF TG_OP = ''UPDATE'' OR TG_OP = ''INSERT'' THEN
            RETURN NEW;
        END IF;
    END;
'LANGUAGE plpgsql;

CREATE TRIGGER update_rating_trigger_new
    AFTER INSERT OR UPDATE OF rating
    ON booking.reviews
    FOR EACH ROW
    WHEN (NEW.review_target_id = 2)
EXECUTE
    FUNCTION update_rating();

CREATE TRIGGER update_rating_trigger_old
    AFTER DELETE
    ON booking.reviews
    FOR EACH ROW
    WHEN (OLD.review_target_id = 2)
EXECUTE
    FUNCTION update_rating();
