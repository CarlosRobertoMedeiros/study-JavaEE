<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script src="libs/jquery-1.11.1/jquery-1.11.1.min.js"></script>
	<link href="libs/bootstrap-4.4.1-dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="libs/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
	<title>Lista de Usuários</title>
</head>
<body>
	
	<div class="jumbotron jumbotron-fluid">
	  <div class="container">
		    <h1 class="display-4">Crud de Usuários</h1>
		    <p class="lead">Cadastro Simples de Usuários.</p>
	  </div>
	</div>

	<div class="container">
        <!-- 
        <h4>Gerenciador de Usuários</h4>
        <h2>
            
            <a href="/new">Adiciona Novo Usuário</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Lista todos os usuários</a>
             -->
             
        </h2>
    </div>
    
    <div class="container">
	    <table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Código</th>
		      <th scope="col">Nome</th>
		      <th scope="col">CPF</th>
		      <th scope="col">Email</th>
		      <th scope="col">Telefone</th>
		      <th scope="col">Situação</th>
		      <th scope="col">Ações</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="usuario" items="${usuarios}">
			    <tr>
			      <th scope="row">1</th>
			      <td>c:out value="${usuario.id}"</td>
			      <td>Otto</td>
			      <td>@mdo</td>
			      <td>@mdo</td>
			      <td>Otto</td>
			      <td>
			      	<i class="fa fa-edit"></i>
			      	<i class="fa fa-trash"></i>
			      </td>
			    </tr>
			</c:forEach>

		  </tbody>
		</table>
    </div>


</body>
</html>