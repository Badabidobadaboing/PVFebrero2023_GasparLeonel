package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;

@Service
public interface IUsuarioService {
	
	public void guardarUsuario(Usuario unUsuario);
	public void modificarUsuario(Usuario unUsuario) throws Exception;
	public Usuario crearUsuario();
	public Usuario encontrarUsuario(String dni) throws Exception;
	public List<Usuario> obtenerTodosLosUsuarios();
	public void eliminarUsuario(String dni) throws Exception;

}
