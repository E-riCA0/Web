package com.fdmgroup.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.fdmgroup.dao.CurrentCourseDAO;
import com.fdmgroup.model.CurrentCourse;

public class SessionListener implements HttpSessionListener{
	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		//for student logout 
		HttpSession session = e.getSession();
		CurrentCourseDAO ccd= new CurrentCourseDAO();
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
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
