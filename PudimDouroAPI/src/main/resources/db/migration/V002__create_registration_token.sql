CREATE TABLE registration_token (
 id int NOT NULL,
 token varchar(10) NOT NULL,
 validate date NOT NULL,
PRIMARY KEY (id)
);