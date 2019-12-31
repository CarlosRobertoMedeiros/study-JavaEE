<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <jsp:include page="../comum/header.jsp"></jsp:include>
        <div class="container col-md-5">
			<div class="card" style="margin-top:60px;">
				<div class="card-body">
		            <h3 style="text-align:center;">App Exemplo - Logar</h3>
		            <form action="<%=request.getContextPath()%>/login" method="post">
		
		                <div class="form-group">
		                    <label for="uname">Usuário:</label> <input type="text" class="form-control" placeholder="Usuário" name="usuario" required>
		                </div>
		
		                <div class="form-group">
		                    <label for="uname">Senha:</label> <input type="password" class="form-control" placeholder="Senha" name="senha" required>
		                </div>
		
		
		                <button type="submit" class="btn btn-primary">Submit</button>
		            </form>
		        </div>
        	</div>
        </div>
        <jsp:include page="../comum/footer.jsp"></jsp:include>
    </body>

    </html>