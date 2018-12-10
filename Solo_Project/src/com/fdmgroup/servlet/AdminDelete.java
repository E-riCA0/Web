package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.CourseDAO;
import com.fdmgroup.model.Course;

public class AdminDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("loggedInUser")==null) {
			req.setAttribute("msg","Time out");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
			rd.include(req, resp);
		}
		CourseDAO courseDAO=new CourseDAO();
		String cname = (String) req.getParameter("course");
		Course course=courseDAO.findByName(cname);
		if (course != null) {
			courseDAO.delete(course);
			req.setAttribute("deletemsg","Deleted");
		}
		else {
			req.setAttribute("deletemsg","The course doesn't exist");
		}
			
		RequestDispatcher rd=req.getRequestDispatcher("/admin.jsp");
		rd.include(req, resp);
	}
}
