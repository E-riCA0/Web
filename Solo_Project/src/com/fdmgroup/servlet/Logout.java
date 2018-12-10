package com.fdmgroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression;

import com.fdmgroup.dao.CurrentCourseDAO;
import com.fdmgroup.model.CurrentCourse;


public class Logout extends HttpServlet {
	@Override
	public void doGet  (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		/*CurrentCourseDAO ccd= new CurrentCourseDAO();
		//for student logout 
		if (session.getAttribute("isJoin")!=null && (int)session.getAttribute("isJoin")==1) {		
			ccd.DeleteTotal(ccd.findByName((String) session.getAttribute("CourseName")));
			if ((int)session.getAttribute("isChosen")==1) {
				if ((int)session.getAttribute("isYes")==1) {
					ccd.DeleteYes(ccd.findByName((String) session.getAttribute("CourseName")));
				}
				else {
					ccd.DeleteNo(ccd.findByName((String) session.getAttribute("CourseName")));
				}
			}
		}
		//for instructor logout
		if (session.getAttribute("logoutCourse")!=null) {
			ccd.delete((CurrentCourse) session.getAttribute("logoutCourse"));
		}
		session.removeAttribute("loggedInUser");*/
		session.invalidate();
        req.setAttribute("msg","Logout Successfully!");
        RequestDispatcher rd=req.getRequestDispatcher("index.jsp");            
		rd.include(req, resp);
	}

}