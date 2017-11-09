-- Insert four Job Record
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (100, Null, 2, 'Job TItle 4','Job No 1 Description', null, '', '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (101, Null, 2, 'Job TItle 4','Job No 2 Description', null, '', '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (102, Null, 4,'Job TItle 4', 'Job No 3 Description', null, '', '',  0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobTitle, jobDescription, dueDate, education, budget, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (103, Null, 4, 'Job TItle 4','Job No 4 Description', null, '', '', 0, Null, 0, Null, 0);


INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 1, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 2, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 3, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (100, 4, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 5, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 6, 5);
INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (101, 7, 5);

INSERT INTO tblJob_Skills(jobID, skillID, weight) VALUES (102, 8, 5);


INSERT INTO TBLJOB_OFFERS(ID,JOBID,FREELANCERID,OFFERSTATUS,TIMEDATE)
VALUES (100,100,100, 0, current_timestamp)

