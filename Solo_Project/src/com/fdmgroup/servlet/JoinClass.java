package com.fdmgroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression;
import org.omg.CORBA.portable.ApplicationException;

import com.fdmgroup.dao.CourseDAO;
import com.fdmgroup.dao.CurrentCourseDAO;
import com.fdmgroup.model.Course;
import com.fdmgroup.model.CurrentCourse;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserType;

public class JoinClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("loggedInUser")==null) {
			req.setAttribute("msg","Time out");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
			rd.include(req, resp);
		}
	
		CourseDAO courseDAO=new CourseDAO();
		String courseName= req.getParameter("course");
		String code=req.getParameter("code");
		Course thisCourse= courseDAO.findByName(courseName);
		HttpSession session=req.getSession();
		User loggedInUser=(User) session.getAttribute("loggedInUser");
		if (thisCourse==null || !(thisCourse.getCode().equals(code))) {
			req.setAttribute("join","Please check your info again");
			if (loggedInUser.getType()==UserType.instructor) {
				RequestDispatcher rd=req.getRequestDispatcher("/instructor_index.jsp");
				rd.include(req, resp);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("/student_join_class.jsp");
				rd.include(req, resp);
			}
		}
		
		else {
			session.setAttribute("Course", thisCourse);
			session.setAttribute("CourseName", thisCourse.getName());
			CurrentCourseDAO ccd= new CurrentCourseDAO();
			if (loggedInUser.getType()==UserType.instructor) {
//				ServletContext application = getServletConfig().getServletContext();
//				application.setAttribute("total", 0);
//				application.setAttribute("yes", 0);
//				application.setAttribute("no", 0);
				
				CurrentCourse currentCourse=ccd.findByName(thisCourse.getName());
				session.setAttribute("logoutCourse", currentCourse);
				if (currentCourse==null) {
					ccd.create(new CurrentCourse(thisCourse.getName()));
					currentCourse=ccd.findByName(thisCourse.getName());
				}
				session.setAttribute("Current", currentCourse);
				RequestDispatcher rd=req.getRequestDispatcher("/instructor_current_class.jsp");
				rd.include(req, resp);
			}
			else {
//				ServletContext application = getServletConfig().getServletContext();
//				application.setAttribute("total", (int)application.getAttribute("total")+1);
//				System.out.println("new total "+ application.getAttribute("total"));
				if((int)session.getAttribute("isJoin")==0) {
					ccd.AddTotal(ccd.findByName(thisCourse.getName()));
					session.setAttribute("isJoin", 1);
				}
				
				RequestDispatcher rd=req.getRequestDispatcher("/student_current_class.jsp");
				rd.include(req, resp);
			}
		}
		/*if (courseDAO.findByName(courseName) != null) {
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
		}*/
		
	}
}
