package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioDao;
import ar.edu.unju.edm.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService{
	@Autowired
	Usuario unUsuario;
	@Autowired
	IUsuarioDao usuarioDAO;
	
	public void modUsuario(Usuario desde, Usuario hacia) {
		hacia.setApellido(desde.getApellido());
		hacia.setNombre(desde.getNombre());
		hacia.setTipoUsuario(desde.getTipoUsuario());
		hacia.setFechaNac(desde.getFechaNac());
		
	}

	@Override
	public void guardarUsuario(Usuario unUsuario) {
		// TODO Auto-generated method stub
		String pasw = unUsuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setPassword(bCryptPasswordEncoder.encode(pasw));
		usuarioDAO.save(unUsuario);
	}

	@Override
	public void modificarUsuario(Usuario unUsuario) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioParaModificar = usuarioDAO.findById(unUsuario.getDni()).orElseThrow(()->new Exception("El usuario no fue encontrado"));
		modUsuario(unUsuario, usuarioParaModificar);
		usuarioDAO.save(usuarioParaModificar);
	}

	@Override
	public Usuario crearUsuario() {
		// TODO Auto-generated method stub
		return unUsuario;
	}

	@Override
	public Usuario encontrarUsuario(String dni) throws Exception {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(dni).orElseThrow(()->new Exception("El usuario no fue encontrado"));
	}

	@Override
	public List<Usuario> obtenerTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public void eliminarUsuario(String dni) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioParaEliminar = usuarioDAO.findById(dni).orElseThrow(()->new Exception("El usuario no fue encontrado"));
		usuarioDAO.delete(usuarioParaEliminar);
	}

}
