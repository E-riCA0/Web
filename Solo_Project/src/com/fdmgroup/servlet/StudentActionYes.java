package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.CurrentCourseDAO;

public class StudentActionYes extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if (session.getAttribute("loggedInUser")==null) {
			req.setAttribute("msg","Time out");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
			rd.forward(req, resp);
		}
		CurrentCourseDAO ccd=new CurrentCourseDAO();
		if ((int)session.getAttribute("isChosen")==1){
			if ((int)session.getAttribute("isYes")==1) {
				
			}
			else {
				ccd.AddYes(ccd.findByName((String)session.getAttribute("CourseName")));
				ccd.DeleteNo(ccd.findByName((String)session.getAttribute("CourseName")));
				session.setAttribute("isYes",1);
				session.setAttribute("isNo",0);
			}
		}
		
		else {
			
			ccd.AddYes(ccd.findByName((String)session.getAttribute("CourseName")));
			session.setAttribute("isChosen", 1);
			session.setAttribute("isYes", 1);
			
		}
		req.setAttribute("msgYes","I Get It !");
		RequestDispatcher rd=req.getRequestDispatcher("/student_current_class.jsp");            
		rd.include(req, resp);
	}
}
