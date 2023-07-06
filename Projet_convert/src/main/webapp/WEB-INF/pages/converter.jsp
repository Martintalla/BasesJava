
<%@ page import="fr.inetum.formation.models.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 	<%
		User user = (User) request.getSession().getAttribute("user");
	if (user == null){
		response.sendRedirect("login");
	}
	%>  --%>
	
<!doctype html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Login Page</title>
</head>
<body>
	<div class="content">
		<div class="header">projet converter</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">Converter Form</div>
			<form method="get">
				<div class="mb-3">
					<label for="login" class="form-label">Température</label> <input
						type="tempareture" class="form-control" id="celsius" name =celsuis
						placeholder="Saisir la température en °C">
				</div>
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
