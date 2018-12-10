<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
		<script type="text/javascript"> 
      			$(document).ready( function() {
        		$('#mes').delay(2000).fadeOut();
      	});
    	</script>
		<style>
			th, td {
  				padding: 10px;
				
		}</style>
		<title>iGetIt</title>
	</head>
	<body background="grey.png">
	
		<header><h1>iGetIt</h1></header>
		<nav>
			<ul>
                        <li> <a href="/Solo_Project">Class</a>
                        <li> <a href="profile.jsp">Profile</a>
                        <li> <a href="Logout">Logout</a>
                        </ul>
		</nav>
			<% 
				if (session.getAttribute("loggedInUser")==null){
					response.sendRedirect("/Solo_Project");
				}
			%>
			<main>
			<form method="post" action="change">
			<h1>Profile</h1>
				<fieldset>
			
	
					<table>
  					<tr>
    							<td style="font-weight:bold">User Id:</td>
    							<td>${ loggedInUser.userid } </td>
  					</tr>
  					<tr>
    							<td style="font-weight:bold">User Type:</td>
    							<td>${ loggedInUser.type } </td>
  					</tr>
  					<tr>
    							<td style="font-weight:bold">Password:</td>
    							<td><input type="password" placeholder=${ loggedInUser.password } name="password"> </td>
  					</tr>
  					<tr>
    							<td style="font-weight:bold">First Name:</td>
    							<td><input type="text" placeholder=${ loggedInUser.firstname } name="firstname"> </td>
  					</tr>
  					<tr>
    							<td style="font-weight:bold">Last Name:</td>
    							<td><input type="text" placeholder=${ loggedInUser.lastname } name="lastname"></td>
  					</tr>
  					
  					<tr>
    							<td style="font-weight:bold">Email:</td>
    							<td><input type="email" placeholder=${ loggedInUser.email }  name="email"></td>
  					</tr>
					</table>
					<div id="mes">
					<%String login_msg=(String)request.getAttribute("msg");  
						if(login_msg!=null)
						out.println("<font color=green size=4px>"+login_msg+"</font>");
					%></div>
					<br>
					<input type="submit" name="Submit" value="Change"/>
					</fieldset>
					</form>
					</main>
		<footer>
</footer>
	</body>
</html>



