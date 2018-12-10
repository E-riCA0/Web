<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.fdmgroup.dao.CourseDAO" %>
<%@ page import="com.fdmgroup.model.Course" %>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    	<script type="text/javascript"> 
      			$(document).ready( function() {
        		$('#dcourse').delay(2000).fadeOut();
      	});
    	</script>
		<title>iGetIt</title>
	</head>
	<body background="grey.png">
		<header><h1>iGetIt (Admin)</h1></header>
		<nav>
			<ul>
                        <li> <a href="">Class</a>
                        <li> <a href="profile.jsp">Profile</a>
                        <li> <a href="Logout">Logout</a>
                        </ul>
		</nav>
		<main>
			<h1>Class</h1>
			<form method="get" action="CourseDelete">
				<fieldset>
					<legend>Delete Classes</b></legend>
					<div>
                                        <div class="row"> <label for="class">Class &nbsp;</label> <select id="course" name="course">
                                               <option>None</option>
                                               <%
                                               CourseDAO courseDAO= new CourseDAO();
                                               List<Course> courseList=courseDAO.findAll();
                                               session.setAttribute("clist", courseList);
                                               for (int i =0;i<courseList.size();i++) {
                                            	   out.println("<option value='"+courseList.get(i).getName()+"'>"+courseList.get(i).getName()+"</option>");
                                   				}
                                               %>
                                        </select></div>

                                        <div id="dcourse">
											<%String deletemsg=(String)request.getAttribute("deletemsg");  
												if(deletemsg!=null)
												out.println("<font color=red size=4px>"+deletemsg+"</font>");
											%>
					
										</div>
                                        	<p> <input type="submit" name="submit" value="Delete"/></p>
                                		</div>
				</fieldset>
			
			</form>
		</main>
		<footer>
		</footer>
	</body>
</html>


