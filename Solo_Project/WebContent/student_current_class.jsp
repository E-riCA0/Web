<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<style>
			td a {
				background-color:green; 
				display:block; 
				width:200px; 
				text-decoration:none; 
				padding:20px; 
				color:white; 
				text-align:center;
			}
		</style>
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
			<h1>Class</h1>
			<form>
				<fieldset>
					<legend> ${ Course.name } </legend>
					<table style="width:100%;">
						<tr>
							<td><a style="background-color:#39c680;" href="StudentActionYes" >i Get It</a></td>
							<td><a style="background-color:#ff8000;  " href="StudentActionNo">i Don't Get It</a></td>
						</tr>
						<div id="mesNo">
						<%String msg1=(String)request.getAttribute("msgNo");  
						if(msg1!=null)
						out.println("<font color=red size=4px>"+msg1+"</font>");
						%> </div>
						<div id="mesYes">
						<%String msg2=(String)request.getAttribute("msgYes");  
						if(msg2!=null)
						out.println("<font color=green size=4px>"+msg2+"</font>");
						%> </div>
					</table>
				</fieldset>
			</form>
			
		<footer>
		</footer>
	</body>
</html>


