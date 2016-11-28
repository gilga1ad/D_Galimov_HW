package repository.impl;


import model.Student;
import org.springframework.stereotype.Repository;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    public boolean add(Student student) {
        em.persist(student);
        return true;
    }

    public Student findOne(int id) {
        Student student = em.find(Student.class, id);
        return student;
    }

}
