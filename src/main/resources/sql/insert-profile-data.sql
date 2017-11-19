-- Insert Three Freelancer Records
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (1, 'Free','lancer','freelancer', 'freelancer@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (3, 'Free','lancer2','freelancer2', 'freelancer2@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (5, 'Free','lancer3','freelancer3', 'freelancer3@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (1, 'Perth', '44 Test Street', 'Testville', 'WA', '7777', 'I like to write Java programs', Null, NULL );
INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (3, 'Perth', '44 Test Street', 'Testville', 'WA', '7777', 'I like to write Java programs', Null, NULL );
INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (5, 'Perth', '44 Test Street', 'Testville', 'WA', '7777', 'I like to write Java programs', Null, NULL );

-- Insert Job Poster Records
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (2, 'Job', 'poster', 'poster', 'poster@test.com', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (4, 'Job', 'poster2', 'poster2', 'poster2@test.com', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (6, 'Job', 'John', 'Smith', 'JohnTester@gmail.com', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');

-- Insert a Profile for a Freelancer
INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES ( 2, 'Palm Cove', '22 Test Street', 'Testville', 'QLD', '4444', 'I like to write programs', 1, NULL );
INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (4, 'Palm Cove', '22 Test Street', 'Testville', 'QLD', '4444', 'I like to write programs', 1, NULL );
INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (6, 'Sydney', '123 Fake Street', 'Sydney', 'NSW', '2000', 'I am a web development specialist.', 1, NULL );


-- Insert the list of skills into the skills table
INSERT INTO tblSkills(id, value) VALUES (1, 'HTML/CSS');
INSERT INTO tblSkills(id, value) VALUES (2, 'PHP');
INSERT INTO tblSkills(id, value) VALUES (3, 'Java');
INSERT INTO tblSkills(id, value) VALUES (4, 'Javascript');
INSERT INTO tblSkills(id, value) VALUES (5, 'Ruby');
INSERT INTO tblSkills(id, value) VALUES (6, 'C++');
INSERT INTO tblSkills(id, value) VALUES (7, 'Python');
INSERT INTO tblSkills(id, value) VALUES (8, 'Perl');
INSERT INTO tblSkills(id, value) VALUES (9, 'PC#');
INSERT INTO tblSkills(id, value) VALUES (10, 'C');
INSERT INTO tblSkills(id, value) VALUES (11, 'Go');
INSERT INTO tblSkills(id, value) VALUES (12, 'R');
INSERT INTO tblSkills(id, value) VALUES (13, 'SQL');
INSERT INTO tblSkills(id, value) VALUES (14, 'iOS: Swift');
INSERT INTO tblSkills(id, value) VALUES (15, 'iOS: C Objective');
INSERT INTO tblSkills(id, value) VALUES (16, 'Wordpress');
INSERT INTO tblSkills(id, value) VALUES (17, 'SEO');
INSERT INTO tblSkills(id, value) VALUES (18, 'Mobile Phone');
INSERT INTO tblSkills(id, value) VALUES (19, 'Android');
INSERT INTO tblSkills(id, value) VALUES (20, 'Graphic Design');
INSERT INTO tblSkills(id, value) VALUES (21, 'Internet Marketing');
INSERT INTO tblSkills(id, value) VALUES (22, 'Database Design');


-- Insert Skills for some freelancers
-- Freelancer 1
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (1, 1, 1);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (2, 1, 2);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (3, 1, 3);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (4, 1, 4);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (5, 1, 5);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (6, 1, 6);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (7, 1, 7);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (8, 1, 8);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (9, 1, 9);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (10, 1, 10);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (11, 1, 11);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (12, 1, 12);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (13, 1, 13);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (14, 1, 14);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (15, 1, 15);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (16, 1, 16);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (17, 1, 17);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (18, 1, 18);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (19, 1, 19);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (20, 1, 20);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (21, 1, 21);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (22, 1, 22);
-- Freelancer 2
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (23, 3, 1);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (24, 3, 3);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (25, 3, 5);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (26, 3, 7);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (27, 3, 9);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (28, 3, 11);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (29, 3, 13);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (30, 3, 15);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (31, 3, 17);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (32, 3, 19);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (33, 3, 21);
-- Freelancer 3                        
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (34, 5, 2);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (35, 5, 4);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (36, 5, 5);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (37, 5, 6);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (38, 5, 10);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (39, 5, 12);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (40, 5, 13);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (41, 5, 16);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (42, 5, 18);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (43, 5, 20);
INSERT INTO tblSkills_User(ID, userID, skillID) VALUES (44, 5, 22);


