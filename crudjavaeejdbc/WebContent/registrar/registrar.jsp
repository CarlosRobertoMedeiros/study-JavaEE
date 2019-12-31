<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    </head>

    <body>
        <jsp:include page="../comum/header.jsp"></jsp:include>
        <div class="container">

            <div class="container col-md-5">
				<div class="card" style="margin-top:60px;">
					<div class="card-body">
		            <h3>Registrar Usuário</h3>
		            
		                <!-- 
		                <div class="alert alert-success center" role="alert">
		                    <p>${NOTIFICATION}</p>
		                </div>
		                 -->
			
		                <form action="<%=request.getContextPath()%>/register" method="post">
		
		                    <div class="form-group">
		                        <label for="uname">Primeiro Nome:</label> <input type="text" class="form-control" placeholder="Primeiro Nome" name="primeironome" required>
		                    </div>
		
		                    <div class="form-group">
		                        <label for="uname">Último Nome:</label> <input type="text" class="form-control" placeholder="Último Nome" name="ultimonome" required>
		                    </div>
		
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
            
        </div>
        <jsp:include page="../comum/footer.jsp"></jsp:include>
    </body>

    </html>