<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		 <link rel="stylesheet" type="text/css" href="style.css" />
		<title>iGetIt</title>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    	<script type="text/javascript"> 
      			$(document).ready( function() {
        		$('#mes').delay(2000).fadeOut();
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
			<h1>Login</h1>
			
			<form method="post" action="login">
				<fieldset>
				
					<div class="row"> <label for="user">User </label>    <input type="text" name="user"> </div>
					<div class="row"> <label for="password ">Password &nbsp</label><input type="password" name="password"> </div>
					<div id="mes">
					<%String login_msg=(String)request.getAttribute("msg");  
						if(login_msg!=null)
						out.println("<font color=red size=4px>"+login_msg+"</font>");
					%> </div>
					<p> <input type="submit" value="Submit" name="Submit" /></input>
				</fieldset>
				
			</form>
			
			<p>  <a href="register.jsp"> Register</a>  </p>
		</main>
		<footer class="page-footer font-small blue">


  		<div class="footer-copyright text-center py-3">© 2018 Copyright:
    		<a href=""> Eric</a>
  		</div>
		</footer>
	</body>
</html>


