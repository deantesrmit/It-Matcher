INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
 VALUES (1, 'Free','lancer','freelancer', 'freelancer@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra','$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
--INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
--VALUES (3, 'Free','lancer2','freelancer2', 'freelancer2@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra','$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'FREELANCER');
INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
 VALUES (2, 'Job','poster','poster', 'poster@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra','$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');
--INSERT INTO tblUser(id, firstName, lastName, username, email, password, salt, accountType)
--VALUES (4, 'Job','poster2','poster2', 'poster2@test.com','$2a$10$ymh/2PpcAV2cqOy6aBF9T.DF/9x8tvvHAB/rE8yRlR18I5oDDOUra','$2a$10$ymh/2PpcAV2cqOy6aBF9T.', 'POSTER');
-- -- Insert Two Job Posters
-- INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (7, 'Daffy','Duck','daffy.duck@acme.com','dd',2);
-- INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (8, 'Elma','Fudd','elma.fudd@acme.com','ef',2);
--
-- -- Insert some skills
-- INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (1, 1, 1, 1, 1, 1, 1);
-- INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (2, 1, 1, 1, 1, 1, 1);
-- INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (3, 1, 1, 1, 1, 1, 1);
-- INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (4, 1, 1, 1, 1, 1, 1);
-- INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (5, 1, 1, 1, 1, 1, 1);
-- INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (6, 1, 1, 1, 1, 1, 1);
--
-- Insert One Job
--INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDesc, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
--VALUES (100,'','2','Job No 1 Description',0,'',0,'','')

INSERT INTO tblFreelancer(freelancerID, userID, bio)
  VALUES (1, 1, 'I like to write programs');