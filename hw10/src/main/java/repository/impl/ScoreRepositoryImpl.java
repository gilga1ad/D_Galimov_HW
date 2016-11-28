package repository.impl;


import model.Score;
import model.Student;
import org.springframework.stereotype.Repository;
import repository.ScoreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

    @PersistenceContext
    EntityManager em;

    public boolean add(Score score) {
        em.persist(score);
        return true;
    }

    public List<Score> findByStudent(int student_id) {
        TypedQuery<Score> query = em.createQuery("select score from Score score where score.student.id = :student_id",
                Score.class);
        query.setParameter("student_id", student_id);
        return query.getResultList();
    }

}
