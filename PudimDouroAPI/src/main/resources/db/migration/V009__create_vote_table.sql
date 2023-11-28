CREATE TABLE vote (
 id INTEGER NOT NULL auto_increment,
 `user` INTEGER NOT NULL,
 edition INTEGER NOT NULL,
 first_place INTEGER NOT NULL,
 second_place INTEGER NOT NULL,
 third_place INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(`user`) references `user`(id),
FOREIGN KEY(edition) references edition(id),
FOREIGN KEY(first_place) references `user`(id),
FOREIGN KEY(second_place) references `user`(id),
FOREIGN KEY(third_place) references `user`(id)
);