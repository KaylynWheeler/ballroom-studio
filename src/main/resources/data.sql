INSERT INTO ballroom_studio (ballroom_studio_name,ballroom_studio_address,ballroom_studio_city,ballroom_studio_state,ballroom_studio_zip ,ballroom_studio_phone)
VALUES('DelMar', '1231 O Street', 'LINCOLN','NE','68508','402 876 5309' );

INSERT INTO instructors (ballroom_studio_id ,instructors_first_name,instructors_last_name)VALUES(1,'Jim','Latino');
INSERT INTO instructors (ballroom_studio_id, instructors_first_name,instructors_last_name)VALUES(1,'Stan','Dred');
INSERT INTO instructors(ballroom_studio_id ,instructors_first_name,instructors_last_name)VALUES(1,'Amber','Fall');

INSERT INTO  latin_style_dancing(instructors_id ,latin_style_name)VALUES(1,'Samba');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(1,'Rumba');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(1,'Cha-Cha-Cha');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(1,'Paso Doble');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(1,'Jive');


INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(2,'Waltz');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(2,'Quickstep');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(2,'Tango');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(2,'Slow Foxtrot');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(2,'Viennese Waltz');

INSERT INTO  latin_style_dancing(instructors_id ,latin_style_name)VALUES(3,'Samba');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(3,'Rumba');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(3,'Cha-Cha-Cha');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(3,'Paso Doble');
INSERT INTO latin_style_dancing(instructors_id ,latin_style_name)VALUES(3,'Jive');


INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(3,'Waltz');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(3,'Quickstep');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(3,'Tango');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(3,'Slow Foxtrot');
INSERT INTO standard_style_dancing(instructors_id ,standard_style_name)VALUES(3,'Viennese Waltz');


INSERT INTO amenity (ballroom_studio_id ,amenity_name)VALUES(1,'ballroom floors');
INSERT INTO amenity (ballroom_studio_id ,amenity_name)VALUES(1,'stereo systems');
INSERT INTO amenity (ballroom_studio_id ,amenity_name)VALUES(1,'ballroom shoes');
INSERT INTO amenity (ballroom_studio_id ,amenity_name)VALUES(1,'bathrooms');
INSERT INTO amenity (ballroom_studio_id ,amenity_name)VALUES(1,'laptops');
INSERT INTO amenity (ballroom_studio_id ,amenity_name) VALUES(1,'reception area');
