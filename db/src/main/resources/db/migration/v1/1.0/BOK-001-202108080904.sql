ALTER TABLE booking.users
    ADD COLUMN IF NOT EXISTS user_rating DECIMAL NOT NULL DEFAULT 0;

CREATE OR REPLACE FUNCTION update_user_rating() RETURNS TRIGGER AS
'
    DECLARE
        my_user_id INTEGER;
        temp_rate  NUMERIC;
    BEGIN
        IF TG_OP = ''DELETE'' THEN
            my_user_id = OLD.rated_entity_id;
        END IF;
        IF TG_OP = ''UPDATE'' OR TG_OP = ''INSERT'' THEN
            my_user_id = NEW.rated_entity_id;
        END IF;
        temp_rate = AVG(rating)
                    FROM booking.reviews
                    WHERE rated_entity_id = my_user_id
                      AND review_target_id = 1;
        UPDATE booking.users
        SET user_rating = temp_rate
        WHERE user_id = my_user_id;
        IF TG_OP = ''DELETE'' THEN
            RETURN OLD;
        END IF;
        IF TG_OP = ''UPDATE'' OR TG_OP = ''INSERT'' THEN
            RETURN NEW;
        END IF;
    END;
'LANGUAGE plpgsql;

CREATE TRIGGER update_rating_trigger_user_new
    AFTER INSERT OR UPDATE OF rating
    ON booking.reviews
    FOR EACH ROW
    WHEN (NEW.review_target_id = 1)
EXECUTE
    FUNCTION update_user_rating();

CREATE TRIGGER update_rating_trigger_user_old
    AFTER DELETE
    ON booking.reviews
    FOR EACH ROW
    WHEN (OLD.review_target_id = 1)
EXECUTE
    FUNCTION update_user_rating();
