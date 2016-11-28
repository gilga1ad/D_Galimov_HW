package service.impl;


import model.Score;
import model.Student;
import model.SubjectType;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ScoreRepository;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    ScoreRepository scoreRepository;

//    @Autowired
//    StudentRepository studentRepository;

    public int totalScoreOfStudentForAllSubjects(int student_id) {
        List<Score> scores = scoreRepository.findByStudent(student_id);
        int total = 0;
        for (Score score: scores) {
            total += score.getScore();
        }
        return total;
    }

    public int averageScoreOfStudentInAllSubjects(int student_id) {
        List<Score> scores = scoreRepository.findByStudent(student_id);
        int total = 0;
        for (Score score: scores) {
            total += score.getScore();
        }
        return total / scores.size();
    }

    public int scoreOfStudentOnSubject(int student_id, SubjectType subjectType) {
        List<Score> scores = scoreRepository.findByStudent(student_id);
        for (Score score: scores) {
            if (score.getType().equals(subjectType)) {
                return score.getScore();
            }
        }
        return 0;
    }

}
