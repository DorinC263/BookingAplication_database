--create table for accommodation
CREATE TABLE accommodation
(
    id          SERIAL PRIMARY KEY,
    type        VARCHAR(32),
    bed_type    VARCHAR(32),
    max_guests  INT,
    description VARCHAR(512)
);

--create table for room_fair
CREATE TABLE room_fair
(
    id     SERIAL PRIMARY KEY,
    value  DOUBLE PRECISION,
    season VARCHAR(32)
);

--create relation table for room-fair and accommodation table
CREATE TABLE accommodation_room_fair_relation
(
    id               SERIAL PRIMARY KEY,
    accommodation_id INT,
    room_fair_id     INT,
    FOREIGN KEY (accommodation_id) REFERENCES accommodation (id),
    FOREIGN KEY (room_fair_id) REFERENCES room_fair (id)
);

--insert data into accommodation table
INSERT INTO accommodation (type, bed_type, max_guests, description)
VALUES (''Hotel Room'', ''Queen'', 2, ''Cozy room with a view''),
       (''Apartment'', ''King'', 4, ''Spacious apartment in the middle of the city'');

-- Insert data into room_fair
INSERT INTO room_fair (value, season)
VALUES (100.00, ''Summer''),
       (120.00, ''Winter'');