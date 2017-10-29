-- Insert four Job Record
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDescription, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (100, Null, 2, 'Job No 1 Description', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDescription, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (101, Null, 2, 'Job No 2 Description', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDescription, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (102, Null, 4, 'Job No 3 Description', 0, Null, 0, Null, 0);
INSERT INTO tblJobs(jobsID, freelancerID, jobPosterID, jobDescription, jobAccepted, jobAcceptedDate, jobCompleted, jobCompletedDate, deleteStatus)
  VALUES (103, Null, 4, 'Job No 4 Description', 0, Null, 0, Null, 0);


INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (100, 1, 5);
INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (100, 2, 5);
INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (100, 3, 5);
INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (100, 4, 5);

INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (101, 5, 5);
INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (101, 6, 5);
INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (101, 7, 5);

INSERT INTO tblJobs_Skills(jobID, skillID, weight) VALUES (102, 8, 5);

