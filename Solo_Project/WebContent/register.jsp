<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>iGetIt</title>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    	<script type="text/javascript"> 
      			$(document).ready( function() {
        		$('#mes').delay(3000).fadeOut();
      	});
    	</script>
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
		<main>
			<h1>Register</h1>
			<form method="post" action="registerclick">
				<fieldset>
					<div>
					<div class="row"> <label for="user">UserName</label>    <input type="text" name="user"> </div>
					<div class="row"> <label for="password">Password</label><input type="password" name="password" > </div>
					<div class="row"> <label for="firstName">First Name</label><input type="text" name="firstName"> </div>
					<div class="row"> <label for="lastName">Last Name</label><input type="text" name="lastName"> </div>
					<div class="row"> <label for="email">Email</label><input type="email" name="email"> </div>
					<div class="row"> <label for="type">type</label>
						<input type="radio" name="type" value="instructor" style="display: inline">instructor
						<input type="radio" name="type" value="student" style="display: inline">student 
					</div>
					<div id="mes">
					<%String msg=(String)request.getAttribute("msg");  
						if(msg!=null)
						out.println("<font color=red size=4px>"+msg+"</font>");
					%> </div>
					<p> <input type="submit" name="Submit" value="Submit"/>
					</div>
				</fieldset>
			</form>
	</main>
		<footer>
</footer>
	</body>
</html>



