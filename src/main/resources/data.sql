
INSERT INTO address (street, postal, city, country) VALUES
            ('Första stigen 77', '28472', 'Avesta', 'Sverige'),
            ('Högra kullen 3', '91245', 'Skuggedal', 'Sverige'),
            ('Koskenkorva 9', '52953', 'Helsingfors', 'Finland'),
            ('Stonehenge 33', '19283', 'Wiltshire', 'England');

INSERT INTO user (first_name, last_name, email, phone, member_type, address_id) VALUES
            ('Inge', 'Hår', 'no@hair.com', '0704327512', 'premium', 1),
            ('Mye', 'Hår', 'toomuch@hair.com', '0701234567', 'standard', 1),
            ('Max', 'Flyt', 'good@luck.com', '0736447382', 'enhanced', 2),
            ('Mumin', 'Trollet', 'kanske@finns.se', '0792758372', 'premium', 3),
            ('Michael', 'Smith', '180@darts.se', '0737483912', 'standard', 4);

INSERT INTO post (message) VALUES
            ('Jag har ätit pannkaka.'),
            ('I´ll be back.'),
            ('Mango Chutney kan vara gott ibland. Tycker Jag i alla fall.'),
            ('Java är både gott och roligt.'),
            ('Snart är det sommarlov.');