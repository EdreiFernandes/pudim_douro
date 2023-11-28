CREATE TABLE inscription (
 id INTEGER NOT NULL auto_increment,
 `user` varchar(50) NOT NULL,
 edition INTEGER,
PRIMARY KEY (id),
FOREIGN KEY(edition) references edition(id)
);