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
import com.fdmgroup.model.UserType;

public class IndexServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User loggedInUser=(User) session.getAttribute("loggedInUser");
		if(loggedInUser != null) {
			if (loggedInUser.getType()==UserType.admin) {
				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
				rd.forward(req, resp);
			}
			
			else if (loggedInUser.getType()==UserType.instructor) {
				RequestDispatcher rd = req.getRequestDispatcher("instructor_index.jsp");
				rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("student_join_class.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");            
			rd.forward(req, resp);
		}
	}
}
