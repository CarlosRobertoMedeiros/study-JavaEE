<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="libs/jquery-1.11.1/jquery-1.11.1.min.js"></script>
	<link href="libs/bootstrap-4.4.1-dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="libs/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="login.css"  />
	<meta charset="ISO-8859-1">
	<title>Aplicação De Usuário</title>
	
</head>
<body>
	<div class="sidenav">
	<div class="login-main-text">
		<h2 style="text-align: center">Sistema A<br> Crud Simples de Usuários</h2>
		<p style="text-align: center">Cadastre-se ou Acesse o Sistema.</p>
	</div>
	      </div>
	      <div class="main">
	         <div class="col-md-6 col-sm-12">
	            <div class="login-form">
	               <form action="principal.jsp">
	                  <div class="form-group">
	                     <label>Usuário</label>
	                     <input type="text" class="form-control" placeholder="Usuário">
	                  </div>
	                  <div class="form-group">
	                     <label>Senha</label>
	                     <input type="password" class="form-control" placeholder="Senha">
	                  </div>
	                  <button type="submit" class="btn btn-black">Acessar</button>
	                  <button type="submit" class="btn btn-secondary">Registrar</button>
	               </form>
	            </div>
	         </div>
	      </div>
</body>
</html>