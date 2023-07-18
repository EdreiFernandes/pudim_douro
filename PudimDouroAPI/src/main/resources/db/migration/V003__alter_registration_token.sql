ALTER TABLE registration_token
MODIFY COLUMN id INT auto_increment;

ALTER TABLE registration_token
ADD active boolean NOT NULL DEFAULT 1;