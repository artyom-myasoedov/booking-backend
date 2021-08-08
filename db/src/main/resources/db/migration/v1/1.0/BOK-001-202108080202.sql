alter table booking.reviews
    add constraint reviews_pk
        unique (rated_entity_id, author_id, review_target_id);

