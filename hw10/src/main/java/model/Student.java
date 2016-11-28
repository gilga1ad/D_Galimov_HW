package model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@SequenceGenerator(sequenceName = "students_seq", name = "studentsSequence")
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentsSequence")
    private int id;

    @Column
    private String firstname;

    @Column
    private String surname;

    @Column
    private String lastname;

    @Column
    private String studgroup;

    public Student() {
    }

    public Student(String firstname, String surname, String lastname, String studgroup) {
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.studgroup = studgroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudgroup() {
        return studgroup;
    }

    public void setStudgroup(String studgroup) {
        this.studgroup = studgroup;
    }

}
