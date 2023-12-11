CREATE TABLE inscription (
 id SERIAL NOT NULL,
 user_profile INTEGER NOT NULL,
 edition INTEGER,
PRIMARY KEY (id),
FOREIGN KEY(edition) references edition(id),
FOREIGN KEY(user_profile) references user_profile(id)
);