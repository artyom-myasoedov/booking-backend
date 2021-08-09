INSERT INTO booking.users
(user_id, username, first_name, last_name, password, phone_number, email, role_id)
VALUES (10, 'admin50', 'petya', 'ivanov', '$2a$10$grCDlguQjLpp2gWY6XlHCuQOJkv2EGG1VJQFR9EG91EsvVx8otE02', '+79009009999', 'aa@aa.com', 3);

INSERT INTO booking.users
(user_id, username, first_name, last_name, password, phone_number, email, role_id)
VALUES (11, 'landlord1212', 'petya', 'ivanov', '$2a$10$grCDlguQjLpp2gWY6XlHCuQOJkv2EGG1VJQFR9EG91EsvVx8otE02', '+79009009999', 'aa@aa.com', 1);

INSERT INTO booking.rooms (room_id, square, landlord_id, type, capacity, status, address, description,
                           min_rental_period, room_rating)
VALUES (3, 900, 10, 1, 80, DEFAULT, 'лажмлалмалм  оаа', 'ввьаьаа', 144, DEFAULT);

INSERT INTO booking.rooms (room_id, square, landlord_id, type, capacity, status, address, description,
                           min_rental_period, room_rating)
VALUES (4, 900, 11, 2, 80, DEFAULT, 'ejnfkhebhkbrkhf ewkbfkhw', 'qwertyuiop', 168, DEFAULT);

INSERT INTO booking.rooms_types_of_rent (room_id, type_of_rent_id, price)
VALUES (3, 2, 222.000);

INSERT INTO booking.rooms_types_of_rent (room_id, type_of_rent_id, price)
VALUES (4, 1, 1.000);

INSERT INTO booking.rooms_types_of_rent (room_id, type_of_rent_id, price)
VALUES (3, 3, 23232.000);

INSERT INTO booking.rooms_types_of_rent (room_id, type_of_rent_id, price)
VALUES (4, 4, 222.000);

INSERT INTO booking.rooms_equipments (room_id, equipment_name, description, equipment_id)
VALUES (3, 'TV', 'ddfffffff', 4);

INSERT INTO booking.rooms_equipments (room_id, equipment_name, description, equipment_id)
VALUES (3, 'TV', 'ddfffffff', 5);

INSERT INTO booking.rooms_equipments (room_id, equipment_name, description, equipment_id)
VALUES (4, 'TV', 'ddfffffff', 6);

INSERT INTO booking.bookings (booking_id, room_id, tenant_id, rental_period, rental_start_date, rental_end_date)
VALUES (1, 3, 4, 24, '2021-08-09 11:24:31.000000', '2021-08-10 11:24:49.000000');

INSERT INTO booking.bookings (booking_id, room_id, tenant_id, rental_period, rental_start_date, rental_end_date)
VALUES (2, 4, 4, 24, '2021-08-10 11:24:31.000000', '2021-08-12 11:24:49.000000');



