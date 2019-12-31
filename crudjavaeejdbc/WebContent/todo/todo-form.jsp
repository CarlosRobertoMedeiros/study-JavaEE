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
   style="background-color: #007BFF;">
   <div>
    <a href="https://github.com/CarlosRobertoMedeiros/study-JavaEE" class="navbar-brand"> Sistema
     A</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/listar"
     class="nav-link">Todos</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>
 
 <div class="container col-md-5">
  <div class="card" style="margin-top:60px;">
   <div class="card-body">
    <c:if test="${todo != null}">
     <form action="update" method="post">
    </c:if>
    <c:if test="${todo == null}">
     <form action="inserir" method="post">
    </c:if>

    <caption>
     <h2 style="text-align: center">
      <c:if test="${todo != null}">
               Atualizar TODO
              </c:if>
      <c:if test="${todo == null}">
               Adiciona Nova TODO 
              </c:if>
     </h2>
    </caption>

    <c:if test="${todo != null}">
     <input type="hidden" name="id"  id="id"  value="<c:out value='${todo.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Título</label> <input type="text"
      value="<c:out value='${todo.titulo}' />" class="form-control"
      name="titulo" id="titulo" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Descrição</label> <input type="text"
      value="<c:out value='${todo.descricao}' />" class="form-control"
      name="descricao" id="descricao" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Status</label> <select class="form-control"
      name="isDone" id="isDone">
      <option value="0">Em Execução</option>
      <option value="1">Completo</option>
     </select>
    </fieldset>

    <fieldset class="form-group">
     <label>Data Para Conclusão</label> <input type="date"
      value="<c:out value='${todo.data}' />" class="form-control"
      name="data" id="data" required="required">
    </fieldset>

    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../comum/footer.jsp"></jsp:include>
</body>
</html>