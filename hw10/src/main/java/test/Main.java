package test;


import model.SubjectType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        StudentService studentService = (StudentService) context.getBean("studentService");

        System.out.println(studentService.totalScoreOfStudentForAllSubjects(4));
        System.out.println(studentService.averageScoreOfStudentInAllSubjects(4));
        System.out.println(studentService.scoreOfStudentOnSubject(4, SubjectType.ASTRONOMY));
    }

}
