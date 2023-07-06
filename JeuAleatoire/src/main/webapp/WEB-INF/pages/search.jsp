<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="header">Random game</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">Rechercher un nombre aléatoire entre 1 et 10</div>
			<form method="post">
				<div class="mb-3">
					<label for="login" class="form-label">Entrer un nombre compris entre 1 et 10</label> <input
						type="int" class="form-control" id="login" name="userRandomNum"
						placeholder="Saisir un chiffre">
				</div>
				<div>
					<input type="submit" value="Valider votre choix" class="btn btn-primary" /> <input
						type="reset" value="Tout recommencer" class="btn btn-secondary float-end" />
				</div>
			</form>
		</div>
		<div> Nombre de tentatives ${tentatives } fois</div>
		<div> ${resultat }</div>
	</div>
</body>
</html>