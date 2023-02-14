package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;

@Service
public interface IUsuarioService {
	
	public void guardarUsuario(Usuario unUsuario);
	public void modificarUsuario(Usuario unUsuario);
	public Usuario encontrarUsuario(Long id);
	public List<Usuario> obtenerTodosLosUsuarios();
	public void eliminarUsuario(Long id);

}
