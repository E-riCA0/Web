<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.fdmgroup.dao.CourseDAO" %>
<%@ page import="com.fdmgroup.model.Course" %>
<%@ page import="com.fdmgroup.model.User" %>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    	<script type="text/javascript"> 
      			$(document).ready( function() {
        		$('#mes1').delay(2000).fadeOut();
        		$('#mes2').delay(3000).fadeOut();
        		$('#join').delay(3000).fadeOut();
      	});
    	</script>
		<title>iGetIt</title>
	</head>
	<body background="grey.png">
		<header><h1>iGetIt (instructor)</h1></header>
		<nav>
			<ul>
                        <li> <a href="/Solo_Project">Class</a>
                        <li> <a href="profile.jsp">Profile</a>
                        <li> <a href="Logout">Logout</a>
                        </ul>
		</nav>
		<main>
			<h1>Class</h1>
			<form method="post" action="CourseRegister">
				<fieldset>
					<legend>Create Classes</b></legend>
					<div>
   					<div class="row"> <label for="class">Class &nbsp </label><input type="text" name="class"></input> </div>
   					<div class="row"> <label for="code">Code </label><input type="text" name="code"></input> </div>
   					<div id="mes1">
					<%String msg=(String)request.getAttribute("msg1");  
						if(msg!=null)
						out.println("<font color=green size=4px>"+msg+"</font>");
					%>
					<%String msg2=(String)request.getAttribute("msg2");  
						if(msg2!=null)
						out.println("<font color=red size=4px>"+msg2+"</font>");
					%> 
					</div>
                                        <p> <input type="submit" name="submit" value="create"/>
					</div>
				</fieldset>
			
			</form>
			<br>
 			<form method="get" action="JoinClass">
                                <fieldset>                   
                                        <legend>Current Classes</legend>
                                        <div>
                                        <div class="row"> <label for="courseName">Class</label> <select name="course">
                                               <option>None</option>
                                               <%
                                              /*  List<String> names =(List<String>) request.getAttribute("CourseList");
                                               for (int i=0;i<names.size();i++){
                                            	   out.println("<option value='"+names.get(i)+"'>"+names.get(i)+"</option>");
                                               } */
                                               CourseDAO courseDAO= new CourseDAO();
                                               List<Course> courseList=courseDAO.findByProfessor(((User)(session.getAttribute("loggedInUser"))).getUserid());
                                               for (int i =0;i<courseList.size();i++) {
                                            	   out.println("<option value='"+courseList.get(i).getName()+"'>"+courseList.get(i).getName()+"</option>");
                                   				}
                                               %>
                                        </select></div>
                                        <div class="row"> <label for="code">Code</label><input type="text" name="code"></input> </div>
                                        <div id="join">
											<%String join=(String)request.getAttribute("join");  
												if(join!=null)
												out.println("<font color=red size=4px>"+join+"</font>");
											%>
					
										</div>
                                        <p> <input type="submit" name="submit" value="join"/></p>
                                </div>
                                </fieldset>
                        </form>
		</main>
		<footer>
		</footer>
	</body>
</html>


