CREATE TABLE vote (
 id SERIAL NOT NULL,
 user_profile INTEGER NOT NULL,
 edition INTEGER NOT NULL,
 first_place INTEGER NOT NULL,
 second_place INTEGER NOT NULL,
 third_place INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(user_profile) references user_profile(id),
FOREIGN KEY(edition) references edition(id),
FOREIGN KEY(first_place) references user_profile(id),
FOREIGN KEY(second_place) references user_profile(id),
FOREIGN KEY(third_place) references user_profile(id)
);