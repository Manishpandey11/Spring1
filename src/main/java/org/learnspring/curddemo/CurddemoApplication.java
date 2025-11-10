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
           createStudent(studentDAO);
        };
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
