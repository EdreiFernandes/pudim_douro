-- Removendo foreign key user
-- scoreboard
ALTER TABLE scoreboard
DROP FOREIGN KEY scoreboard_ibfk_1,
MODIFY COLUMN user_profile INTEGER;

-- edition
ALTER TABLE edition
DROP FOREIGN KEY edition_ibfk_1,
DROP FOREIGN KEY edition_ibfk_2,
DROP FOREIGN KEY edition_ibfk_3,
MODIFY COLUMN first_place INTEGER,
MODIFY COLUMN second_place INTEGER,
MODIFY COLUMN third_place INTEGER;

-- inscription
ALTER TABLE inscription
MODIFY COLUMN user_profile INTEGER;
-- -------------------------------------------------

-- Alterando primary key do user
ALTER TABLE user_profile
DROP PRIMARY KEY,
ADD id INTEGER auto_increment, ADD PRIMARY KEY (id);
-- -------------------------------------------------

-- Alterando foreign keys
-- scoreboard
ALTER TABLE scoreboard
ADD FOREIGN KEY(user_profile) references user_profile(id);

-- edition
ALTER TABLE edition
ADD FOREIGN KEY(first_place) references user_profile(id),
ADD FOREIGN KEY(second_place) references user_profile(id),
ADD FOREIGN KEY(third_place) references user_profile(id);

-- inscription
ALTER TABLE inscription
ADD FOREIGN KEY(user_profile) references user_profile(id);
-- -------------------------------------------------