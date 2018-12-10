package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserType;

public class ProfileChange extends HttpServlet {
	
//	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		RequestDispatcher rd=req.getRequestDispatcher("register.jsp");            
//		rd.forward(req, res);
//		System.out.println("In register");
//		
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao user=new UserDao();
		HttpSession session=req.getSession();
		if (session.getAttribute("loggedInUser")==null) {
			req.setAttribute("msg","Time out");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
			rd.forward(req, resp);
		}
		String username= ((User)session.getAttribute("loggedInUser")).getUserid();
		String password=req.getParameter("password");
		String firstName=req.getParameter("firstname");
		String lastName=req.getParameter("lastname");
		String email=req.getParameter("email");
		User newUser = new User(username,password,firstName,lastName,email,((User)session.getAttribute("loggedInUser")).getType());
		user.update(newUser);
		session.setAttribute("loggedInUser", user.findById(username));
		req.setAttribute("msg","Updated");
		RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");            
		rd.include(req, resp);
		
	}
}
