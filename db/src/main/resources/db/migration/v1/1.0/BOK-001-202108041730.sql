INSERT INTO booking.admins
    (username, first_name, last_name, password)
VALUES ('Admin', 'admin', 'admin', 'password');

INSERT INTO booking.review_targets
    (review_target_id, review_target_name)
VALUES (1, 'USER');

INSERT INTO booking.review_targets
    (review_target_id, review_target_name)
VALUES (2, 'ROOM');

INSERT INTO booking.roles
    (role_id, role_name)
VALUES (1, 'LANDLORD');

INSERT INTO booking.roles
    (role_id, role_name)
VALUES (2, 'CLIENT');

INSERT INTO booking.room_statuses
    (room_status_id, room_status_name)
VALUES (1, 'AVAILABLE');

INSERT INTO booking.room_statuses
    (room_status_id, room_status_name)
VALUES (2, 'NOT_CONFIRMED');

INSERT INTO booking.room_statuses
    (room_status_id, room_status_name)
VALUES (3, 'OCCUPIED');

INSERT INTO booking.room_types
    (room_type_id, room_type_name)
VALUES (1, 'CLASS');

INSERT INTO booking.room_types
    (room_type_id, room_type_name)
VALUES (2, 'THEATRE');

INSERT INTO booking.room_types
    (room_type_id, room_type_name)
VALUES (3, 'ROUND_TABLE');

INSERT INTO booking.room_types
    (room_type_id, room_type_name)
VALUES (4, 'CONVERSATION');

INSERT INTO booking.types_of_rent
    (type_of_rent_id, name_of_rent_type)
VALUES (1, 'BY_HOUR');

INSERT INTO booking.types_of_rent
    (type_of_rent_id, name_of_rent_type)
VALUES (2, 'BY_DAY');

INSERT INTO booking.types_of_rent
    (type_of_rent_id, name_of_rent_type)
VALUES (3, 'BY_WEEK');

INSERT INTO booking.types_of_rent
    (type_of_rent_id, name_of_rent_type)
VALUES (4, 'BY_MONTH');

INSERT INTO booking.users
(username, first_name, last_name, password, phone_number, email, role_id)
VALUES ('landlord1', 'vasya', 'bojko', 'password', '+79009009999', 'aa@aa.com', 1);

INSERT INTO booking.users
(username, first_name, last_name, password, phone_number, email, role_id)
VALUES ('client1', 'peter', 'mikhno', 'password', '+78008008888', 'bb@bb.com', 2);

INSERT INTO booking.users
(username, first_name, last_name, password, phone_number, email, role_id)
VALUES ('landlord2', 'john', 'wick', 'password', '+77777777777', 'ab@ba.com', 1);

INSERT INTO booking.users
(username, first_name, last_name, password, phone_number, email, role_id)
VALUES ('client2', 'donald', 'trump', 'password', '+76666666666', 'cc@cc.com', 2);

INSERT INTO booking.rooms
(square, landlord_id, type, capacity, address, description, min_rental_period)
VALUES (100, 1, 1, 14, 'some address', 'some description', 24);

INSERT INTO booking.rooms
(square, landlord_id, type, capacity, address, description, min_rental_period)
VALUES (150, 2, 3, 20, 'some2 address2', 'some2 description2', 72);

INSERT INTO booking.rooms_equipments
(room_id, equipment_name, description)
VALUES (1, 'TV', 'great TV');

INSERT INTO booking.rooms_equipments
(room_id, equipment_name, description)
VALUES (1, 'WIFI', '2.4ghz wifi');

INSERT INTO booking.rooms_equipments
(room_id, equipment_name, description)
VALUES (1, 'chairs', '12 chairs');


