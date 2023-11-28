CREATE TABLE edition (
 id INTEGER NOT NULL auto_increment,
 edition_year YEAR(4) NOT NULL,
 active boolean NOT NULL,
 first_place varchar(50),
 second_place varchar(50),
 third_place varchar(50),
PRIMARY KEY (id),
FOREIGN KEY(first_place) references user_profile(email),
FOREIGN KEY(second_place) references user_profile(email),
FOREIGN KEY(third_place) references user_profile(email)
);