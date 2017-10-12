drop table tblUser if exists;
create table tblUser (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  username varchar(220) not null,
  firstName varchar(50),
  lastName varchar(50),
  email varchar(100),
  password varchar(100) not null,
  salt varchar(100) not null,
  accountType varchar(50) NOT NULL
);

drop table tblSkills if exists;
create table tblSkills (
  skillsID integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  skill1 bit,
  skill2 bit,
  skill3 bit,
  skill4 bit,
  skill5 bit,
  skill6 bit
);

drop table tblJobs if exists;
create table tblJobs (
  jobsID integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  freelancerID INT,
  jobPosterID INT,
  jobDesc VARCHAR(254) NOT NULL,
  jobAccepted bit,
  jobAcceptedDate DATETIME,
  jobCompleted bit,
  jobCompletedDate DATETIME,
  deleteStatus bit
);

drop table tblFreelancer if exists;
create table tblFreelancer (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY (START WITH 100),
  userId integer foreign key,
  bio VARCHAR(254) NOT NULL
);

drop table tblDeclined if exists;
-- Declined Table, holds what Jobs a Freelancer has declined, a Freelancer can decline many jobs over
-- a period of time, but only decline a job once
create table tblDeclined (
  declinedID integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  freelancerID INT NOT NULL ,
  jobPosterID INT NOT NULL
);
