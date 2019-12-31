<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color:#007BFF;">
   <div>
    <a href="https://github.com/CarlosRobertoMedeiros/study-JavaEE" class="navbar-brand"> Sistema
     A</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Todos</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container" style="margin-top:30px;">
   <h3 class="text-center">Lista de TODOS</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/nova"
     class="btn btn-success">Adicionar Todo</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Data</th>
      <th>Id</th>
      <th>Usuario</th>
      <th>Titulo</th>
      <th>Descrição</th>
      <th>Status</th>
      <th>Ações</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (Todo todo: todos) {  -->
     <c:forEach var="item" items="${listarTodo}">

      <tr>
       <td><c:out value="${item.data}" /></td>
       <td><c:out value="${item.id}" /></td>
       <td><c:out value="${item.usuario}" /></td>
       <td><c:out value="${item.titulo}" /></td>
       <td><c:out value="${item.descricao}" /></td>
       
       <c:if test = "${item.status == false}">
       	<td>Em Execução</td>
       </c:if>
       <c:if test = "${item.status == true}">
       	<td>Completo</td>
       </c:if>
       <td><a href="atualizar?id=<c:out value='${item.id}' />">Editar</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="excluir?id=<c:out value='${item.id}' />">Excluir</a></td>

       <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>

 <jsp:include page="../comum/footer.jsp"></jsp:include>
</body>
</html>