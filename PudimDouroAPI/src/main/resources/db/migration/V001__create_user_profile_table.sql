CREATE TABLE user_profile (
 email varchar(50) NOT NULL,
 name varchar(50) NOT NULL,
 password varchar(20) NOT NULL,
 active boolean NOT NULL,
PRIMARY KEY (email)
);