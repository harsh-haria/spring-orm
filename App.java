package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring/orm/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;

		while (go) {
			try {
				System.out.println("\nMenu options:");
				System.out.println("Enter 1 for adding a student");
				System.out.println("Enter 2 for deleting a student");
				System.out.println("Enter 3 for getting a student");
				System.out.println("Enter 4 for getting all the students");
				System.out.println("Enter 5 for updating the details of the student");
				System.out.println("Enter 6 for Exiting the application");

				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// insert a new student
					int id;
					String name;
					String city;
					System.out.print("Enter id for the student");
					id = Integer.parseInt(br.readLine());
					System.out.println("Enter name for the student");
					name = br.readLine();
					System.out.println("Enter city for the student");
					city = br.readLine();
					Student student = new Student(id, name, city);
					int idInserted = studentDao.insert(student);
					System.out.println(idInserted + " student added");
					break;

				case 2:
					// delete a student with id
					System.out.print("Enter id of the student to be deleted: ");
					int studentId = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(studentId);
					System.out.println("Student with id " + studentId + " has been deleted!");
					break;

				case 3:
					// get student details with id
					System.out.print("Enter id of the student: ");
					int studId = Integer.parseInt(br.readLine());
					Student student2 = studentDao.getStudent(studId);
					System.out.println(student2);
					break;

				case 4:
					// get all the students that are available in the database
					List<Student> allStudents = studentDao.getAllStudents();
					for(Student st: allStudents) {
						System.out.println(st);
					}
					break;

				case 5:
					// update the student with the provided details
					System.out.println("Enter student's id to be updated");
					int stId = Integer.parseInt(br.readLine());
					System.out.println("Enter student's name to be updated");
					String sName = br.readLine();
					System.out.println("Enter student's city to be updated");
					String sCity = br.readLine();
					
					Student updateStudentObject = new Student(stId, sName, sCity);
					studentDao.updateStudent(updateStudentObject);
					System.out.println("The details of the users have been updated");
					break;

				case 6:
					go = !go;
					break;

				default:
					System.out.println("Invalid input please try again");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("An error occured while running the application " + e);
			}
		}
		System.out.println("Thank you for using the application");
	}
}
