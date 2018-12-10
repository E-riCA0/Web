package com.fdmgroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.CourseDAO;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Course;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserType;

public class LoginCheck extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter out = resp.getWriter();
		UserDao user=new UserDao();
		//CourseDAO courseDAO= new CourseDAO();
		List<String> names= new ArrayList<String>();
		String username= req.getParameter("user");
		String password=req.getParameter("password");
		User thisUser = user.findById(username);
//		System.out.println("Login Servlet :" + thisUser);
		if (thisUser!=null && thisUser.getPassword().equals(password)) {
			//List<Course> courseList =courseDAO.findAll();
			HttpSession session=req.getSession();
			session.setAttribute("loggedInUser", thisUser);
			
//			for (int i =0;i<courseList.size();i++) {
//				names.add(courseList.get(i).getName());
//			}

//			req.setAttribute("CourseList", names);
			if (thisUser.getType()==UserType.admin) {
				RequestDispatcher rd = req.getRequestDispatcher("/admin.jsp");
				rd.forward(req, resp);
			}
			
			
			else if (thisUser.getType()==UserType.instructor) {
//				ServletContext application = getServletConfig().getServletContext();
//				application.setAttribute("total", 0);
//				application.setAttribute("yes", 0);
//				application.setAttribute("no", 0);
				
				RequestDispatcher rd = req.getRequestDispatcher("/instructor_index.jsp");
				rd.forward(req, resp);
			}
			else {
				session.setAttribute("isChosen", 0);
				session.setAttribute("isJoin", 0);
				session.setAttribute("isYes", 0);
				session.setAttribute("isNo", 0);
				RequestDispatcher rd = req.getRequestDispatcher("/student_join_class.jsp");
				rd.forward(req, resp);
			}
			//out.print("Let's Welcome:" + username);
		}
		else {
			req.setAttribute("msg","Invalid Username or Password");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
			rd.include(req, resp);
			//out.print("Invalid Username/Password"); 
		}
	}
}
