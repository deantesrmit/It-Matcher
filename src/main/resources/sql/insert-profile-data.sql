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

-- Insert a Profile for a Freelancer
INSERT INTO tblProfile(id, userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (100, 1, 'Palm Cove', '22 Test Street', 'Testville', 'QLD', '4444', 'I like to write programs', Null, NULL );
INSERT INTO tblProfile(id, userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (101, 5, 'Perth', '44 Test Street', 'Testville', 'WA', '7777', 'I like to write Java programs', Null, NULL );
INSERT INTO tblProfile(id, userID, location, address1, suburb, state, postCode, bio, education, workExperience)
VALUES (103, 2, 'Palm Cove', '22 Test Street', 'Testville', 'QLD', '4444', 'I like to write programs', Null, NULL );


