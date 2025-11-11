package org.learnspring.curddemo.dao;

import org.learnspring.curddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
