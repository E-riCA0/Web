package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserType;

public class Register extends HttpServlet {
	
//	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		RequestDispatcher rd=req.getRequestDispatcher("register.jsp");            
//		rd.forward(req, res);
//		System.out.println("In register");
//		
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao user=new UserDao();
		String username= req.getParameter("user");
		String password=req.getParameter("password");
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String email=req.getParameter("email");
		UserType userType;
		System.out.println(req.getParameter("type"));
		if (req.getParameter("type").equals("instructor")) {
			userType=UserType.instructor;
		}
		else {userType=UserType.student;}
		if (username.length()==0||user.findById(username)!=null) {
			req.setAttribute("msg","User name has been used/invalid");
			RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");            
			rd.include(req, resp);
		}
		User newUser = new User(username,password,firstName,lastName,email,userType);
		user.create(newUser);
		req.setAttribute("msg","Registered Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");            
		rd.include(req, resp);
			//out.print("Invalid Username/Password"); 
		
	}
}
