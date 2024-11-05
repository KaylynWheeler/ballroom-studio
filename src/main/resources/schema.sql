DROP TABLE IF EXISTS instructors_students;
DROP TABLE IF EXISTS standard_style_dancing;
DROP TABLE IF EXISTS latin_style_dancing;
DROP TABLE IF EXISTS amenity;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS instructors;
DROP TABLE IF EXISTS ballroom_studio;


CREATE TABLE ballroom_studio(
	ballroom_studio_id int NOT NULL AUTO_INCREMENT,
	ballroom_studio_name varchar(256) NOT NULL,
	ballroom_studio_address varchar(128) NOT NULL,
	ballroom_studio_city varchar(60),
	ballroom_studio_state varchar(30),
	ballroom_studio_zip varchar(15),
	ballroom_studio_phone varchar (30),
    ballroom_studio_email varchar(128),
	PRIMARY KEY (ballroom_studio_id)
	);
	
CREATE TABLE instructors (
	instructors_id int NOT NULL AUTO_INCREMENT,
	ballroom_studio_id int NOT NULL,
	instructors_first_name varchar(60)NOT NULL,
	instructors_last_name varchar(60)NOT NULL,
	instructors_address varchar(128) NOT NULL,
	instructors_city varchar(60),
	instructors_state varchar(30),
	instructors_zip varchar(15),
	instructors_phone varchar (30),
	instructors_email varchar(128),
    PRIMARY KEY (instructors_id),
	FOREIGN KEY (ballroom_studio_id) REFERENCES ballroom_studio (ballroom_studio_id) ON DELETE CASCADE
);
CREATE TABLE  students (
	students_id int NOT NULL AUTO_INCREMENT,
	instructors_id int NOT NULL,
	students_first_name varchar(60)NOT NULL,
	students_last_name varchar(60)NOT NULL,
	students_address varchar(128) NOT NULL,
	students_city varchar(60),
	students_state varchar(30),
	students_zip varchar(15),
	students_phone varchar (30),
	students_email varchar(128),
	PRIMARY KEY (students_id),
	FOREIGN KEY (instructors_id) REFERENCES instructors (instructors_id) ON DELETE CASCADE

);

CREATE TABLE  amenity (
	amenity_id int NOT NULL AUTO_INCREMENT,
	amenity_name varchar(128),
	ballroom_studio_id int NOT NULL,
	PRIMARY KEY (amenity_id),
	FOREIGN KEY (ballroom_studio_id) REFERENCES ballroom_studio (ballroom_studio_id) ON DELETE CASCADE
);

CREATE TABLE  latin_style_dancing (
	latin_style_dancing_id int NOT NULL AUTO_INCREMENT,
	latin_style_name varchar(128),
	instructors_id int NOT NULL,
	PRIMARY KEY (latin_style_dancing_id),
	FOREIGN KEY (instructors_id) REFERENCES instructors (instructors_id) ON DELETE CASCADE
);
CREATE TABLE  standard_style_dancing (
    standard_style_dancing_id int NOT NULL AUTO_INCREMENT,
	standard_style_name varchar(128),
	instructors_id int NOT NULL,
	PRIMARY KEY (standard_style_dancing_id),
	FOREIGN KEY (instructors_id) REFERENCES instructors (instructors_id) ON DELETE CASCADE


);
CREATE TABLE  instructors_students (
	instructors_id int NOT NULL,
	students_id int NOT NULL,
	FOREIGN KEY (instructors_id) REFERENCES instructors (instructors_id) ON DELETE CASCADE,
	FOREIGN KEY (students_id) REFERENCES students (students_id) ON DELETE CASCADE
	);