package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	IUsuarioService unUsuario;
//	@Autowired
//	IPreguntaService unaPreg;
	
	@GetMapping ("/registro")
	public String registrarUsuario(Model model) {
		model.addAttribute("unUser", unUsuario.crearUsuario());
		return "registro";
	}
	
	@PostMapping ("/registro/guardar")
	public String guardarUsuario(@ModelAttribute ("unUser") Usuario unUsr, Model model) {
		unUsuario.guardarUsuario(unUsr);
		return "redirect:/login";
}
	
	@GetMapping ("/usuario")
	public String registrarUsuarioDocente(Model model) {
		model.addAttribute("unUser", unUsuario.crearUsuario());
		return "usuario";
	}
	@PostMapping ("/usuario/guardar")
	public String guardarUsuarioDocente(@ModelAttribute ("unUser") Usuario unUsr, Model model) {
		unUsuario.guardarUsuario(unUsr);
		return "redirect:/listaUsuarioDocente";
}
	@GetMapping ("usuario/editar/{dni}")
	public String editarUsuario(Model model, @PathVariable(name="dni") String dni) throws Exception {
		try {
			Usuario usuarioEncontrado = unUsuario.encontrarUsuario(dni);
			model.addAttribute("unUser", usuarioEncontrado);	
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unUser", unUsuario.crearUsuario());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("lista", unUsuario.obtenerTodosLosUsuarios());
		return("usuario");
	}
	@PostMapping ("/usuario/modificar")
	public String modificarUsuario(@ModelAttribute ("unUser") Usuario unUsr, Model model) {
		
		try {
			unUsuario.modificarUsuario(unUsr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/listaUsuarioDocente";
	}
	@GetMapping ("/usuario/eliminar/{dni}")
	public String eliminarUsuario(Model model, @PathVariable (name="dni") String dni) {
		
		try {
			unUsuario.eliminarUsuario(dni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/listaUsuarioDocente";
	}
	@GetMapping ("/lista")
	public String mostrarLista(Model model) throws Exception {
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Usuario logueado = unUsuario.encontrarUsuario(userDetail.getUsername());
		model.addAttribute("perfil", logueado);
		model.addAttribute("lista", unUsuario.obtenerTodosLosUsuarios());
//		model.addAttribute("listapreg", unaPreg.obtenerTodasLasPreguntas());
		return ("mostrar");
}
	@GetMapping ("/listaUsuarioDocente")
	public String mostrarListaDocente(Model model) {
		model.addAttribute("lista", unUsuario.obtenerTodosLosUsuarios());
		return ("tablausuario");

}
	

}
