CREATE TABLE registration_token (
 id SERIAL NOT NULL,
 token varchar(10) NOT NULL,
 validate date NOT NULL,
 active boolean NOT NULL DEFAULT TRUE,
PRIMARY KEY (id)
);