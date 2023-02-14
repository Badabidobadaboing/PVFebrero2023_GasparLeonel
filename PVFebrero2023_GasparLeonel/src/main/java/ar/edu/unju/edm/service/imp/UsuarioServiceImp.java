package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
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
	private IUsuarioDao usuarioRepo;
	
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		// TODO Auto-generated method stub
		String pasw = unUsuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setPassword(bCryptPasswordEncoder.encode(pasw));
		unUsuario.setEstado(true);
		usuarioRepo.save(unUsuario);
	}

	@Override
	public void modificarUsuario(Usuario unUsuario){
		// TODO Auto-generated method stub
		usuarioRepo.save(unUsuario);
	}

	@Override
	public Usuario encontrarUsuario(Long id){
		// TODO Auto-generated method stub
		return usuarioRepo.findById(id).get();
	}

	@Override
	public List<Usuario> obtenerTodosLosUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> auxiliar = new ArrayList<>();
		List<Usuario> auxiliar2 = new ArrayList<>();
		auxiliar=(List<Usuario>) usuarioRepo.findAll();
		for (int i = 0; i < auxiliar.size(); i++) {
			if(auxiliar.get(i).getEstado().equals(true)) {
				auxiliar2.add(auxiliar.get(i));
			}			
		}
		return auxiliar2;
	}

	@Override
	public void eliminarUsuario(Long id){
		// TODO Auto-generated method stub
		Usuario auxiliar = new Usuario();
		auxiliar = encontrarUsuario(id);
		auxiliar.setEstado(false);
		usuarioRepo.save(auxiliar);
	}

}
