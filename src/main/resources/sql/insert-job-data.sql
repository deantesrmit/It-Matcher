-- Insert four Job Record
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (100, Null, 2, 'Bob the builders company website','Job No 1 Description', null, 2, '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (101, Null, 2, 'Thor ragnarok appreciation page ','Job No 2 Description', null, 6, '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (102, Null, 4,'Artsy blog website', 'Job No 3 Description', null, 3, '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (103, Null, 4, 'Fancy tech startup website','Job No 4 Description', null, 5, '', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (104, Null, 6, 'IT Match Making web application','A basic match making system for IT consultants to meet project creators', null, 6, '', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (105, Null, 6, 'Basic online video game','Multiplayer version of pacman to be played in browser', null, 8, '', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (106, Null, 8, 'eCommerce store website','Website which will allow me to sell products from my home business', null, 8, '', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (107, Null, 8, 'iPhone App','iPhone application to enable customers to book services through our company', null, 8, '', 0, Null, 0, Null, 0);


--Skills and weighting for inserted jobs
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 1, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 2, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 3, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 4, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 5, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 6, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 7, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (102, 8, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (103, 4, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (104, 2, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (104, 1, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (104, 4, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (104, 3, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (104, 20, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (105, 1, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (105, 6, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (105, 7, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (106, 2, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (106, 1, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (106, 4, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (106, 3, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (106, 20, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (107, 18, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (107, 14, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (107, 15, 5);




