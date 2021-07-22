DROP TABLE booking.user_ratings;
ALTER TABLE booking.room_reviews
    RENAME TO reviews;

CREATE TABLE booking.review_targets(
    review_target_id SERIAL NOT NULL PRIMARY KEY ,
    review_target_name VARCHAR(50) NOT NULL
);

ALTER TABLE booking.reviews
    RENAME COLUMN room_review_id TO review_id;

ALTER TABLE booking.reviews
    RENAME COLUMN room_id TO rated_entity_id;

ALTER TABLE booking.reviews
    RENAME COLUMN author_user_id TO author_id;

ALTER TABLE booking.reviews
    ADD COLUMN review_target_id INTEGER NOT NULL REFERENCES booking.review_targets(review_target_id);
