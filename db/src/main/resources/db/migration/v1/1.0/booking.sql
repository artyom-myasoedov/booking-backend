CREATE SCHEMA booking;

CREATE TABLE booking.admins
(
    id         SERIAL       NOT NULL,
    login      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    photo_path VARCHAR(255) NOT NULL,
    PRIMARY KEY (id, login)
);

CREATE TABLE booking.bookings
(
    id            SERIAL   NOT NULL,
    id_room       INT      NOT NULL,
    id_tenant     INT      NOT NULL,
    rental_period INT      NOT NULL,
    rental_start  TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT id_room
        FOREIGN KEY (id_room)
            REFERENCES booking.rooms (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION,
    CONSTRAINT id_tenant
        FOREIGN KEY (id_tenant)
            REFERENCES booking.tenants (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

CREATE TABLE booking.equipment
(
    id   SERIAL       NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE booking.landlord_ratings
(
    id          SERIAL NOT NULL,
    id_landlord INT    NOT NULL,
    rating      INT    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT id_landlord
        FOREIGN KEY (id_landlord)
            REFERENCES booking.landlords (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

CREATE TABLE booking.landlords
(
    id           SERIAL       NOT NULL,
    login        VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    photo_path   VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20)  NULL,
    email        VARCHAR(255) NULL,
    PRIMARY KEY (id, login)
);

CREATE TABLE booking.room_photos
(
    id      SERIAL       NOT NULL,
    id_room INT          NOT NULL,
    photo   VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT id_room
        FOREIGN KEY (id_room)
            REFERENCES booking.rooms (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

CREATE TABLE booking.room_reviews
(
    id          SERIAL NOT NULL,
    id_room     INT    NOT NULL,
    rating      INT    NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT id_room
        FOREIGN KEY (id_room)
            REFERENCES booking.rooms (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

CREATE TABLE booking.rooms
(
    id                 SERIAL       NOT NULL,
    size               INT          NOT NULL,
    id_landlord        INT          NOT NULL,
    type               VARCHAR(255) NOT NULL,
    number_of_people   INT          NOT NULL,
    admin_confirmation INT          NOT NULL,
    address            VARCHAR(255) NOT NULL,
    description        TEXT NOT NULL,
    min_rental_period  INT          NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT id_landlord
        FOREIGN KEY (id_landlord)
            REFERENCES booking.landlords (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

CREATE TABLE booking.rooms_equipments
(
    id_room      INT NOT NULL,
    id_equipment INT NOT NULL,
    number       INT NOT NULL,
    PRIMARY KEY (id_room, id_equipment),
    CONSTRAINT fk_rooms_has_equipment_rooms1
        FOREIGN KEY (id_room)
            REFERENCES booking.rooms (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_rooms_has_equipment_equipment1
        FOREIGN KEY (id_equipment)
            REFERENCES booking.equipment (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE booking.rooms_types_of_rent
(
    id_room         INT            NOT NULL,
    id_type_of_rent INT            NOT NULL,
    price           DECIMAL(12, 3) NOT NULL,
    PRIMARY KEY (id_room, id_type_of_rent),
    CONSTRAINT fk_rooms_has_types_of_rent_rooms1
        FOREIGN KEY (id_room)
            REFERENCES booking.rooms (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_rooms_has_types_of_rent_types_of_rent1
        FOREIGN KEY (id_type_of_rent)
            REFERENCES booking.types_of_rent (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE booking.tenant_ratings
(
    id          SERIAL NOT NULL,
    id_tenant   INT    NOT NULL,
    rating      INT    NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT id_tenant
        FOREIGN KEY (id_tenant)
            REFERENCES booking.tenants (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

CREATE TABLE booking.tenants
(
    id           SERIAL       NOT NULL,
    login        VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    photo_path   VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20)  NULL,
    email        VARCHAR(255) NULL,
    PRIMARY KEY (id, login)
);

CREATE TABLE booking.types_of_rent
(
    id              SERIAL       NOT NULL,
    name            VARCHAR(255) NOT NULL,
    period_in_hours INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX id_unique ON booking.admins (id ASC);
CREATE UNIQUE INDEX login_unique ON booking.admins (login ASC);

CREATE UNIQUE INDEX id_unique (id ASC) IBLE,
    INDEX         id_room_idx(id_room ASC),
    INDEX         id_tenant_idx(id_tenant ASC);

UNIQUE INDEX id_unique (id ASC) VISIBLE

UNIQUE INDEX id_unique (id ASC) VISIBLE,
    INDEX       id_landlord_idx(id_landlord ASC) VISIBLE,

 UNIQUE INDEX id_unique (id ASC) VISIBLE,
    UNIQUE INDEX login_unique (login ASC) VISIBLE

UNIQUE INDEX id_unique (id ASC) VISIBLE,
    INDEX   id_room_idx(id_room ASC) VISIBLE,

UNIQUE INDEX id_unique (id ASC) VISIBLE,
    INDEX       id_room_idx(id_room ASC) VISIBLE,

UNIQUE INDEX id_unique (` id ` ASC) VISIBLE,
    INDEX              id_landlord_idx(` id_landlord ` ASC) VISIBLE,

INDEX        fk_rooms_has_equipment_equipment1_idx(id_equipment ASC) VISIBLE,
    INDEX        fk_rooms_has_equipment_rooms1_idx(id_room ASC) VISIBLE,


    INDEX           fk_rooms_has_types_of_rent_types_of_rent1_idx(id_type_of_rent ASC) VISIBLE,
    INDEX           fk_rooms_has_types_of_rent_rooms1_idx(id_room ASC) VISIBLE,

UNIQUE INDEX id_unique (id ASC) VISIBLE,
    INDEX       id_tenant_idx(id_tenant ASC) VISIBLE,

UNIQUE INDEX id_unique (id ASC) VISIBLE

UNIQUE INDEX id_unique (id ASC) VISIBLE,
    UNIQUE INDEX login_unique (login ASC) VISIBLE



