package repository;


import model.Score;
import model.Student;
import model.SubjectType;

import java.util.List;

public interface ScoreRepository {

    boolean add(Score score);

    List<Score> findByStudent(int student_id);

}
