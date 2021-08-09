drop table if exists booking.reviews cascade;
drop table if exists booking.review_targets cascade;

create table booking.room_reviews
(
    review_id   serial        not null
        constraint room_reviews_pk primary key,
    room_id     integer       not null
        constraint room_reviews_room_id_fkey references booking.rooms on delete cascade,
    rating      integer       not null,
    description varchar(1000) not null,
    author_id   integer       not null
        constraint room_reviews_user_id_fkey references booking.users
);

alter table booking.room_reviews
    add constraint room_reviews_unique_pk unique (room_id, author_id);

create table booking.user_reviews
(
    review_id   serial        not null
        constraint user_reviews_pk primary key,
    user_id     integer       not null
        constraint room_reviews_user_id_fkey references booking.users on delete cascade,
    rating      integer       not null,
    description varchar(1000) not null,
    author_id   integer       not null
        constraint room_reviews_author_id_fkey references booking.users
);

alter table booking.user_reviews
    add constraint user_reviews_unique_pk unique (user_id, author_id);

CREATE OR REPLACE FUNCTION update_user_rating() RETURNS TRIGGER AS
'
    DECLARE
        my_user_id INTEGER;
        temp_rate  NUMERIC;
    BEGIN
        IF TG_OP = ''DELETE'' THEN
            my_user_id = OLD.user_id;
        END IF;
        IF TG_OP = ''UPDATE'' OR TG_OP = ''INSERT'' THEN
            my_user_id = NEW.user_id;
        END IF;
        temp_rate = AVG(rating)
                    FROM booking.user_reviews
                    WHERE user_id = my_user_id;
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
    ON booking.user_reviews
    FOR EACH ROW
EXECUTE
    FUNCTION update_user_rating();

CREATE TRIGGER update_rating_trigger_user_old
    AFTER DELETE
    ON booking.user_reviews
    FOR EACH ROW
EXECUTE
    FUNCTION update_user_rating();

CREATE OR REPLACE FUNCTION update_room_rating() RETURNS TRIGGER AS
'
    DECLARE
        my_room_id INTEGER;
        temp_rate  NUMERIC;
    BEGIN
        IF TG_OP = ''DELETE'' THEN
            my_room_id = OLD.room_id;
        END IF;
        IF TG_OP = ''UPDATE'' OR TG_OP = ''INSERT'' THEN
            my_room_id = NEW.room_id;
        END IF;
        temp_rate = AVG(rating)
                    FROM booking.room_reviews
                    WHERE room_id = my_room_id;
        UPDATE booking.rooms
        SET room_rating = temp_rate
        WHERE room_id = my_room_id;
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
    ON booking.room_reviews
    FOR EACH ROW
EXECUTE
    FUNCTION update_room_rating();

CREATE TRIGGER update_rating_trigger_old
    AFTER DELETE
    ON booking.room_reviews
    FOR EACH ROW
EXECUTE
    FUNCTION update_room_rating();