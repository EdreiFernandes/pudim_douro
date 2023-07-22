CREATE TABLE scoreboard (
 id INTEGER NOT NULL auto_increment,
 user varchar(50) NOT NULL,
 gold_medal INTEGER NOT NULL,
 silver_medal INTEGER NOT NULL,
 bronze_medal INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(user) references user(email)
);