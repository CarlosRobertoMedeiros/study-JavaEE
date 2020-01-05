<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Acessar</h5>
            <form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
	              <div class="form-label-group">
	                <input type="text" id="idUsuario" name="inputUsuario" class="form-control" placeholder="Usuario" required autofocus>
	                <label for="idUsuario">Usuário</label>
	              </div>
	
	              <div class="form-label-group">
	                <input type="password" id="idSenha" name="inputSenha" class="form-control" placeholder="Senha" required>
	                <label for="idSenha">Senha</label>
	              </div>
	
	              <div class="custom-control custom-checkbox mb-3">
	                <input type="checkbox" class="custom-control-input" id="customCheck1">
	                <label class="custom-control-label" for="customCheck1" disabled>Lembrar Senha?</label>
	              </div>
	              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Acessar</button>
				  <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit" disabled><i class="fab fa-google mr-2"></i> Acessar com Google</button>
	              
	              <hr class="my-4">
	              
	              <div class="mt-4">
					<div class="d-flex justify-content-center links">
						Não tem Uma conta? <a href="../registrar/registrar.jsp" class="ml-2">Registre-se</a>
					</div>
					<div class="d-flex justify-content-center links">
						<a href="#" disabled>Esqueceu sua senha?</a>
					</div>
				</div>
	              
	              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>