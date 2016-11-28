package service;


import model.SubjectType;

public interface StudentService {

    int totalScoreOfStudentForAllSubjects(int student_id);

    int averageScoreOfStudentInAllSubjects(int student_id);

    int scoreOfStudentOnSubject(int student_id, SubjectType subjectType);

}
