-- Insert four Job Record
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (100, Null, 2, 'Bob the builders company website','Job No 1 Description', null, '', '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (101, Null, 2, 'Thor ragnarok appreciation page ','Job No 2 Description', null, '', '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (102, Null, 4,'Artsy blog website', 'Job No 3 Description', null, '', '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (103, Null, 4, 'Fancy tech startup website','Job No 4 Description', null, '', '', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (104, Null, 6, 'IT Match Making web application','A basic match making system for IT consultants to meet project creators', null, '', '', 0, Null, 0, Null, 0);


INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 1, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 2, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 3, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 4, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 5, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 6, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 7, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (102, 8, 5);



