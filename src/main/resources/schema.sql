DROP TABLE IF EXIST instructors_students;
DROP TABLE IF EXIST students;
DROP TABLE IF EXIST instructor;
DROP TABLE IF EXIST standardstyledancing;
DROP TABLE IF EXIST latinstyledancing;
DROP TABLE IF EXIST amenity;
DROP TABLE IF EXIST ballroomstudio;


CREATE TABLE ballroomstudio(
	ballroom_studio_id int NOT NULL AUTO_INCREMENT,
	ballroom_studio_name varchar(256) NOT NULL AUTO_INCREMENT,
	ballroom_studio_address varchar(128) NOT NULL AUTO_INCREMENT,
	ballroom_studio_city varchar(60),
	ballroom_studio_state varchar(30),
	ballroom_studio_phone varchar (30),
	PRIMARY KEY (ballroom_studio_id)
	);
CREATE TABLE  amenity (
	amenity_id int NOT NULL AUTO_INCREMENT,
	amenity_name varchar(128),
	PRIMARY KEY (amenity_id)
	FOREIGN KEY (ballroom_studio_id) REFERENCES location (ballroom_studio_id) ON DELETE CASCASDE
);

CREATE TABLE  latinstyledancing (
	latin_style_dancing_id int NOT NULL AUTO_INCREMENT,
	latin_style_name varchar(128),
	PRIMARY KEY (latin_style_dancing_id)
	FOREIGN KEY (instructors_id) REFERENCES location (instructors_id) ON DELETE CASCASDE
);
CCREATE TABLE  standardstyledancing (
    standard_style_dancing_id int NOT NULL AUTO_INCREMENT,
	standard_style_name varchar(128),
	PRIMARY KEY (standard_style_dancing_id)
	FOREIGN KEY (instructors_id) REFERENCES location (instructors_id) ON DELETE CASCASDE



CREATE TABLE instructors (
	instructors_id int NOT NULL AUTO_INCREMENT,
	ballroom_studio_id int NOT NULL
	instructors_first_name varchar(60)NOT NULL,
	instructors_last_name varchar(60)NOT NULL,
    PRIMARY KEY (instructors_id)
	FOREIGN KEY (ballroom_studio_id) REFERENCES location (ballroom_studio_id) ON DELETE CASCASDE
);
CREATE TABLE  students (
	students_id int NOT NULL AUTO_INCREMENT,
	instructors_id int NOT NULL
	students_first_name varchar(60)NOT NULL,
	students_last_name varchar(60)NOT NULL,
	PRIMARY KEY (students_id)
	FOREIGN KEY (instructors_id) REFERENCES location (instructors_id) ON DELETE CASCASDE

CREATE TABLE  instructors_students (
	instructors_id int NOT NULL,
	students_id int NOT NULL,
	FOREIGN KEY (instructors_id) REFERENCES instructors (instructors_id) ON DELETE CASCASDE,
	FOREIGN KEY (students_id) REFERENCES students (students_id) ON DELETE CASCASDE
	);