<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.fdmgroup.dao.CurrentCourseDAO" %>
<%@ page import="com.fdmgroup.model.CurrentCourse" %>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
		<script type="text/javascript"> 
      			$(document).ready( function() {
        		$('#join').delay(3000).fadeOut();
      	});
    	</script>
		<title>iGetIt</title>	
	</head>
	<body background="grey.png">
		<header><h1>iGetIt (student)</h1></header>
		<nav>
			<ul>
                        <li> <a href="/Solo_Project">Class</a>
                        <li> <a href="profile.jsp">Profile</a>
                        <li> <a href="Logout">Logout</a>
                        </ul>
		</nav>
		<main>
			<h1>Class</h1>
			<form action="JoinClass" method="get">
				<fieldset>
					<legend>Current Classes</legend>
					 <select name="course">
                                               <option>None</option>
                                               <%                                        
                                               //response.setIntHeader("Refresh", 2);
                                               CurrentCourseDAO ccd= new CurrentCourseDAO();
                                               List<CurrentCourse> courseList=ccd.findAll();
                                               for (int i =0;i<courseList.size();i++) {
                                            	   out.println("<option value='"+courseList.get(i).getName()+"'>"+courseList.get(i).getName()+"</option>");
                                   				}
                                               %>
                                        </select>
   					<p> <label for="code">Code</label><input type="text" name="code"></input> </p>
   										<div id="join">
											<%String join=(String)request.getAttribute("join");  
												if(join!=null)
												out.println("<font color=red size=4px>"+join+"</font>");
											%>
					
										</div>
                                        <p> <input type="submit" name="submit" value="join"/>
				</fieldset>
			</form>
			</main>
		<footer>
		</footer>
	</body>
</html>
