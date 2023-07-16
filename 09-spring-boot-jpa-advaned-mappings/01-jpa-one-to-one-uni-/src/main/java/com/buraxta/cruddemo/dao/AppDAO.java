package com.buraxta.cruddemo.dao;

import com.buraxta.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructor(int theId);
}
