DROP TABLE IF EXISTS lottery CASCADE;
DROP TABLE IF EXISTS user_ticket CASCADE;
CREATE TABLE lottery
(
    ticket_id VARCHAR(6) PRIMARY KEY,
    price      INTEGER NOT NULL,
    amount     INTEGER NOT NULL
);

CREATE TABLE user_ticket
(
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(10) NOT NULL,
    ticket_id VARCHAR(6) NOT NULL
);
INSERT INTO lottery (ticket_id, price, amount) VALUES
('123456', 100, 10),
('654321', 200, 5);
INSERT INTO user_ticket (user_id, ticket_id) VALUES
('123456789', '123456'),
('987654321', '654321');
