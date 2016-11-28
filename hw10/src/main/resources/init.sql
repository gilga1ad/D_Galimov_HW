CREATE TABLE students (
  id INTEGER NOT NULL PRIMARY KEY,
  firstname VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  studgroup VARCHAR(255) NOT NULL
);

CREATE TABLE scores (
  id INTEGER PRIMARY KEY,
  subject_type INTEGER,
  score INTEGER,
  student_id INTEGER
);

CREATE SEQUENCE students_seq;

CREATE SEQUENCE scores_seq;