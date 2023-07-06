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
		<%! String ville = "paris"; %>
		
		<h2 style ="color :red">
				<%=ville %>
		 
		</h2>
	</body>
</html>