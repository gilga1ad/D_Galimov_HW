package model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
@SequenceGenerator(sequenceName = "scores_seq", name = "scoresSequence")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scoresSequence")
    private int id;

    @Column(name = "subject_type")
    @Enumerated(EnumType.ORDINAL)
    private SubjectType type;

    @Column
    private int score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Score() {

    }

    public Score(SubjectType type, int score, Student student) {
        this.type = type;
        this.score = score;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
