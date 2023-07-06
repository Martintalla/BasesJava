<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>First JSP</title>
	</head>
	
	<body>
		<h1> Ma première jsp</h1>
		<h2>${ msg }</h2>
		<h3>Mon prenom est ${ pre }</h3>
		<h4>Je suis age de ${age } ans</h4>
		<h4>Nous sommes le ${date }</h4>
		<h4>Et il est ${time }</h4>
		<h3> Mon adresse ip est ${ip }</h3>
		<hr/>
		
		<form action= "autre" method ="post">
		
			<p> 
				prenom : <input type ="text" name = "prenom"/>
			</p>
			<p> 
				age : <input type ="text" name = "age"/>
			</p>
			<input type ="submit" value="valider">
		
		</form>
	</body>
</html>