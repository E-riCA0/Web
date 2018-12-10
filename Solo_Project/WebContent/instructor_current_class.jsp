<!DOCTYPE html>
<%@ page import="com.fdmgroup.dao.CurrentCourseDAO" %>
<%@ page import="com.fdmgroup.model.CurrentCourse" %>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="refresh" content="1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<style>
			span {
				background-color:green; 
				display:block; 
				text-decoration:none; 
				padding:20px; 
				color:white; 
				text-align:center;
			}
		</style>
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
			<form>
				<fieldset>
					<legend> ${ Course.name } </legend>
					Total: ${ Current.total } <br>
					<%-- Get It: <font color=green size=44px>${ Current.yes }</font>  <br>
					Don't Get It: <font color=red size=44px>${ Current.no }</font> --%>
					<table style="width:100%;">
						<tr>
							<td><font color=green size=44px>${ Current.yes }</font></td>
							<td><font color=red size=44px>${ Current.no }</font></td>
						</tr>
				
					</table>
  
				</fieldset>
			</form>



			<%-- <button type="button" onclick="<%
												CurrentCourseDAO ccd=new CurrentCourseDAO();
												ccd.ResetChoices(ccd.findByName((String)session.getAttribute("CourseName")));
											%>">Reset</button> --%>
		</main>
		<footer>
		</footer>
	</body>
</html>


