package com.fdmgroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.CourseDAO;
import com.fdmgroup.model.Course;
import com.fdmgroup.model.User;

public class CourseRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("loggedInUser")==null) {
			req.setAttribute("msg","Time out");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
			rd.include(req, resp);
		}
		CourseDAO courseDAO=new CourseDAO();
		String courseName= req.getParameter("class");
		String code=req.getParameter("code");
		if (courseDAO.findByName(courseName) != null) {
			req.setAttribute("msg2","Class name: \""+courseName+"\" has been used");
			RequestDispatcher rd=req.getRequestDispatcher("/instructor_index.jsp");            
			rd.include(req, resp);
		}else if(code.length()==0 ||code.length()>20 || courseName.length()==0){
			req.setAttribute("msg2","Please enter Class/Access Code");
			RequestDispatcher rd=req.getRequestDispatcher("/instructor_index.jsp");            
			rd.include(req, resp);
		}
		else{
		HttpSession session=req.getSession();
		User loggedInUser=(User) session.getAttribute("loggedInUser");
		Course newCourse = new Course(courseName,code,loggedInUser.getUserid());
		courseDAO.create(newCourse);
		req.setAttribute("msg1","The Course Registered Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("/instructor_index.jsp");            
		rd.include(req, resp);
		}
	}
}
