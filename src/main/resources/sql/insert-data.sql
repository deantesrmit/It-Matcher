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

-- INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (7, 'Daffy','Duck','daffy.duck@acme.com','dd',2);
-- INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (8, 'Elma','Fudd','elma.fudd@acme.com','ef',2);

-- Insert some skills for three Freelancers
INSERT INTO tblSkills(skillID, freelancerID, jobsID, skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10)
  VALUES (1, 1, Null, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO tblSkills(skillID, freelancerID, jobsID, skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10)
  VALUES (2, 3, Null, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1);
INSERT INTO tblSkills(skillID, freelancerID, jobsID, skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10)
  VALUES (3, 5, Null, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
-- Insert some skills required for Job 100
INSERT INTO tblSkills(skillID, freelancerID, jobsID, skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10)
  VALUES (4, Null, 100, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1);


-- Insert Three Job Records
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDesc, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (100, Null, 2, 'Job No 1 Description', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDesc, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (101, Null, 2, 'Job No 2 Description', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDesc, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (102, Null, 4, 'Job No 3 Description', 0, Null, 0, Null, 0);

-- Insert a Profile for a Freelancer
INSERT INTO tblProfile(profileID, userID, location, address1, suburb, state, postCode, bio, education, workExperience)
  VALUES (100, 1, 'Palm Cove', '22 Test Street', 'Testville', 'QLD', '4444', 'I like to write programs', 'Bach', '5 Years');
INSERT INTO tblProfile(profileID, userID, location, address1, suburb, state, postCode, bio, education, workExperience)
  VALUES (101, 5, 'Perth', '44 Test Street', 'Testville', 'WA', '7777', 'I like to write Java programs', 'Bach', '2 Years');



