package crudjavaeejdbc.dao;

import java.util.List;

import crudjavaeejdbc.model.Usuario;

public interface UsuarioDAO {
	
	Boolean adiciona(Usuario usuario);
	List<Usuario> getUsuarios();
	Boolean atualiza(Usuario usuario);
	Boolean exclui(Usuario usuario);
	Usuario getUsuarioById(Long id);
	
	

}
