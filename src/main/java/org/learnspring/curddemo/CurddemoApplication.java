package org.learnspring.curddemo;

import org.learnspring.curddemo.dao.StudentDAO;
import org.learnspring.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurddemoApplication.class, args);
    }

    
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
           //createMultipleStudent(studentDAO);

            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object..");
        Student tempStudent =new Student("manish", "kumar", "manishkumar@gmail.com");

        // save the student object

        System.out.println("saving the student  ");
        studentDAO.save(tempStudent);

        // display the id of the saved student

        int theId= tempStudent.getId();
        System.out.println("saved student. Generated id: " + theId);

        //retrieve student based on the id: primary key

        System.out.println("Retrieving student with id: " + theId);
        Student myStudent= studentDAO.findById(theId);

        // display the student
        System.out.println("Found the student: " + myStudent);

    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create multiple student objects
        System.out.println("creating new student object...");
        Student tempStudent1 = new Student("a", "b", "ab@example.com");
        Student tempStudent2 = new Student("c", "d", "cd@example.com");

        Student tempStudent3 = new Student("e", "f", "ef@example.com");


        // save the student objects


        System.out.println("saving the student");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("creating new student object...");
        Student tempStudent = new Student("abc", "zyz", "abc@example.com");


        // save the student object
        System.out.println("saving the student");
        studentDAO.save(tempStudent);


        // display the id of the saved student
        System.out.println("saved student. Generated id: " + tempStudent.getId());
    }
}
