package com.buraxta.cruddemo;

import com.buraxta.cruddemo.dao.StudentDAO;
import com.buraxta.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "a@a.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}


}
