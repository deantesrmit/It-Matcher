-- Insert Six Freelancers
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (1, 'Road','Runner','road.runner@acme.com','rr',1);
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (2, 'Bugs','Bunny','bugs.bunny@acme.com','bb',1);
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (3, 'Fred','Flintstone','fred@therock.com','ff',1);
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (4, 'Barney','Rumble','barney@therock.com','br',1);
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (5, 'Free5','Lancer','Free5@itmatcher.com','f5l',1);
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (6, 'Free6','Lancer','Free6@itmatcher.com','f6l',1);
-- Insert Two Job Posters
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (7, 'Daffy','Duck','daffy.duck@acme.com','dd',2);
INSERT INTO tblUser(userID, firstName, lastName, email, password, userType) VALUES (8, 'Elma','Fudd','elma.fudd@acme.com','ef',2);

-- Insert some skills
INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (1, 1, 1, 1, 1, 1, 1);
INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (2, 1, 1, 1, 1, 1, 1);
INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (3, 1, 1, 1, 1, 1, 1);
INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (4, 1, 1, 1, 1, 1, 1);
INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (5, 1, 1, 1, 1, 1, 1);
INSERT INTO tblSkills(skillsID, skill1, skill2, skill3, skill4, skill5, skill6) VALUES (6, 1, 1, 1, 1, 1, 1);

-- Insert One Job
-- INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobID, jobAccepted, jobAcceptedDate, jobDeclined, jobCompleted, jobCompletedDate) VALUES (100, '', '7', 'Job Description',0,,'',0,0,'')
