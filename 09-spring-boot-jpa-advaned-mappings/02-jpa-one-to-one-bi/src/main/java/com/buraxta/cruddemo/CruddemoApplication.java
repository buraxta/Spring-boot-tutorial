package com.buraxta.cruddemo;

import com.buraxta.cruddemo.dao.AppDAO;
import com.buraxta.cruddemo.entity.Instructor;
import com.buraxta.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);

		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("deleting .. id: " + theId );
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("inst. detail: " + instructorDetail);

		System.out.println("ass. inst. detail: " + instructorDetail.getInstructor());
		System.out.println("done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("deleting .. id: " + theId );
		appDAO.deleteInstructor(theId);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("finding: " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("inst: " + instructor);
		System.out.println("associated: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor = new Instructor("Chad", "Darby", "da@gmail.com");
//
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Codeeee!!!");

		Instructor tempInstructor = new Instructor("Madhu", "Patel", "mmmma@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Guitarrrr!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
	}

}
