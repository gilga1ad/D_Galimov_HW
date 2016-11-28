package repository;

import model.Student;


public interface StudentRepository {
    
    boolean add(Student student);
    
    Student findOne(int id);
    
}
