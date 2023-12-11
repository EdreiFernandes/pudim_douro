CREATE TABLE scoreboard (
 id SERIAL NOT NULL,
 user_profile INTEGER NOT NULL,
 gold_medal INTEGER NOT NULL,
 silver_medal INTEGER NOT NULL,
 brass_medal INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(user_profile) references user_profile(id)
);