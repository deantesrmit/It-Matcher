-- Insert Three Freelancer Records
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (1, 'Free','lancer','freelancer', 'freelancer@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (3, 'Free','lancer2','freelancer2', 'freelancer2@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (5, 'Free','lancer3','freelancer3', 'freelancer3@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');

-- Insert Two Job Poster Records
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (2, 'Job', 'poster', 'poster', 'poster@test.com', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
VALUES (4, 'Job', 'poster2', 'poster2', 'poster2@test.com', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra', '$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');


-- Insert the list of skills into the skills table
INSERT INTO tblSkills(id, skillName) VALUES (1, 'HTML/CSS');
INSERT INTO tblSkills(id, skillName) VALUES (2, 'PHP');
INSERT INTO tblSkills(id, skillName) VALUES (3, 'Java');
INSERT INTO tblSkills(id, skillName) VALUES (4, 'Javascript');
INSERT INTO tblSkills(id, skillName) VALUES (5, 'Ruby');
INSERT INTO tblSkills(id, skillName) VALUES (6, 'C++');
INSERT INTO tblSkills(id, skillName) VALUES (7, 'Python');
INSERT INTO tblSkills(id, skillName) VALUES (8, 'Perl');
INSERT INTO tblSkills(id, skillName) VALUES (9, 'PC#');
INSERT INTO tblSkills(id, skillName) VALUES (10, 'C');
INSERT INTO tblSkills(id, skillName) VALUES (11, 'Go');
INSERT INTO tblSkills(id, skillName) VALUES (12, 'R');
INSERT INTO tblSkills(id, skillName) VALUES (13, 'SQL');
INSERT INTO tblSkills(id, skillName) VALUES (14, 'iOS: Swift');
INSERT INTO tblSkills(id, skillName) VALUES (15, 'iOS: C Objective');
INSERT INTO tblSkills(id, skillName) VALUES (16, 'Wordpress');
INSERT INTO tblSkills(id, skillName) VALUES (17, 'SEO');
INSERT INTO tblSkills(id, skillName) VALUES (18, 'Mobile Phone');
INSERT INTO tblSkills(id, skillName) VALUES (19, 'Android');
INSERT INTO tblSkills(id, skillName) VALUES (20, 'Graphic Design');
INSERT INTO tblSkills(id, skillName) VALUES (21, 'Internet Marketing');
INSERT INTO tblSkills(id, skillName) VALUES (22, 'Database Design');


-- Insert Skills for some freelancers
-- Freelancer 1
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (1, 1, 1);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (2, 1, 2);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (3, 1, 3);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (4, 1, 4);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (5, 1, 5);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (6, 1, 6);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (7, 1, 7);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (8, 1, 8);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (9, 1, 9);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (10, 1, 10);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (11, 1, 11);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (12, 1, 12);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (13, 1, 13);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (14, 1, 14);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (15, 1, 15);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (16, 1, 16);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (17, 1, 17);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (18, 1, 18);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (19, 1, 19);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (20, 1, 20);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (21, 1, 21);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (22, 1, 22);
-- Freelancer 2
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (23, 3, 1);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (24, 3, 3);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (25, 3, 5);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (26, 3, 7);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (27, 3, 9);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (28, 3, 11);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (29, 3, 13);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (30, 3, 15);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (31, 3, 17);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (32, 3, 19);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (33, 3, 21);
-- Freelancer 3
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (34, 5, 2);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (35, 5, 4);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (36, 5, 5);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (37, 5, 6);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (38, 5, 10);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (39, 5, 12);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (40, 5, 13);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (41, 5, 16);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (42, 5, 18);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (43, 5, 20);
INSERT INTO tblSkills_User(id, userid, skillid) VALUES (44, 5, 22);

-- Insert a Profile for a Freelancer
INSERT INTO tblProfile(profileid, userid, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (100, 1, 'Palm Cove', '22 Test Street', 'Testville', 'QLD', '4444', 'I like to write programs', Null, NULL );
INSERT INTO tblProfile(profileid, userid, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (101, 5, 'Perth', '44 Test Street', 'Testville', 'WA', '7777', 'I like to write Java programs', Null, NULL );

