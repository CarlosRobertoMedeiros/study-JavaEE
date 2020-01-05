  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Registar Usuário</h5>
            <form class="form-signin" action="<%=request.getContextPath()%>/register" method="post">
	              <div class="form-label-group">
	                <input type="text" id="inputPrimeiroNome" class="form-control" placeholder="Primeiro Nome" required autofocus>
	                <label for="inputPrimeiroNome">Primeiro Nome</label>
	              </div>
	
				  <div class="form-label-group">
	                <input type="text" id="inputUltimoNome" class="form-control" placeholder="Ultimo Nome" required autofocus>
	                <label for="inputUltimoNome">Ultimo Nome</label>
	              </div>
	              
	              <div class="form-label-group">
	                <input type="text" id="inputUsuario" class="form-control" placeholder="Usuário" required autofocus>
	                <label for="inputUsuario">Usuário</label>
	              </div>
	              
	              <div class="form-label-group">
	                <input type="password" id="inputSenha" class="form-control" placeholder="Senha" required autofocus>
	                <label for="inputSenha">Senha</label>
	              </div>
	
	              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrar</button>
	              
	              <hr class="my-4">
	              
	              <div class="mt-4">
					<div class="d-flex justify-content-center links">
						Voltar a Tela de Realizar Login <a href="../login/login.jsp" class="ml-2">Voltar</a>
					</div>
					
				  </div>
				  
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
