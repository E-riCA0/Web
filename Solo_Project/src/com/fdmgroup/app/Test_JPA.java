package com.fdmgroup.app;

import java.awt.List;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fdmgroup.dao.CourseDAO;
import com.fdmgroup.dao.CurrentCourseDAO;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Course;
import com.fdmgroup.model.CurrentCourse;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserType;

public class Test_JPA {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		CourseDAO courseDAO=new CourseDAO();
		CurrentCourseDAO currentCourseDAO=new CurrentCourseDAO();
		User testStudent_1 = new User("Student_testid", "test", "Larry", "Zhang", "email@test.com",UserType.student);
		userDao.delete(testStudent_1);
		userDao.create(testStudent_1);
		System.out.println("DOne");
		System.out.println("Find all:");
		for (User i:userDao.findAll()) {
			System.out.println(i);
		}
		System.out.println("By type:");
		for (User i:userDao.findByType(UserType.student)) {
			System.out.println(i);
		}
		//System.out.println(userDao.findById("66"));
		System.out.println("Course:");
		Course testcourse=new Course("testCourse", "123", "ABC");
		courseDAO.create(testcourse);
		for (Course i:courseDAO.findAll()) {
			System.out.println(i);
		}
		courseDAO.delete(testcourse);
		System.out.println("Done");
		
		CurrentCourse currentCourse=new CurrentCourse("testcourse");
		currentCourseDAO.create(currentCourse);
		currentCourseDAO.AddTotal(currentCourse);
		currentCourseDAO.AddTotal(currentCourse);
		currentCourseDAO.DeleteTotal(currentCourse);
//		currentCourseDAO.DeleteTotal(currentCourse);
//		currentCourseDAO.DeleteYes(currentCourse);
//		currentCourseDAO.DeleteNo(currentCourse);
	}

}
