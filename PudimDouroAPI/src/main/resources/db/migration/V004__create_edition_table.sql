CREATE TABLE edition (
 id SERIAL NOT NULL,
 edition_year VARCHAR(4) NOT NULL,
 active boolean NOT NULL,
 first_place INTEGER,
 second_place INTEGER,
 third_place INTEGER,
PRIMARY KEY (id),
FOREIGN KEY(first_place) references user_profile(id),
FOREIGN KEY(second_place) references user_profile(id),
FOREIGN KEY(third_place) references user_profile(id)
);