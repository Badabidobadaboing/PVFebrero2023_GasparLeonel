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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Pregunta;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.model.UsuarioPregunta;
import ar.edu.unju.edm.repository.IUsuarioPreguntaDao;
import ar.edu.unju.edm.service.IPreguntaService;
import ar.edu.unju.edm.service.IUsuarioPreguntaService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class PreguntaController {
	@Autowired
	IPreguntaService preguntaService;
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	IUsuarioPreguntaService usuarioPreguntaService;
	@Autowired
	UsuarioPregunta usuarioPregunta;
	@Autowired
	IUsuarioPreguntaDao usuarioPreguntaRepository;

	 @GetMapping({ "/preguntas/nuevo" })
		public String crearPregunta(Model modelo) {
			Pregunta pregunta=new Pregunta(); 
			modelo.addAttribute("pregunta", pregunta);
			return "crear_preguntas";
		}
	  @PostMapping("/preguntas/nuevo")
		public String guardarPregunta(@ModelAttribute("pregunta") Pregunta pregunta) {
			preguntaService.guardarPregunta(pregunta);
			return "redirect:/tablaPreguntas";
		}
	  @GetMapping("/tablaPreguntas")
	  public String Tabla(Model model){
	    model.addAttribute("preguntas1",preguntaService.listarPreguntasPorNivel(1));
	    model.addAttribute("preguntas2", preguntaService.listarPreguntasPorNivel(2));
	    return "tabla_preguntas";
	  }
	  @GetMapping("/preguntas/editar/{id}")
		public String editarPregunta(@PathVariable Long id, Model modelo) {
			modelo.addAttribute("pregunta", preguntaService.obtenerPreguntaporId(id));
			return "editar_usuario"; 
		}

		@PostMapping("/preguntas/editar/{id}")
		public String actualizarPregunta(@PathVariable Long id, @ModelAttribute("pregunta") Pregunta pregunta, Model modelo) {
			preguntaService.actualizarPregunta(pregunta);
			return "redirect:/tablaPreguntas";
		}
	  @GetMapping("/elegirNivel")
	  public ModelAndView ElegirNivel() {
	    Authentication auth = SecurityContextHolder
	        .getContext()
	        .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    Usuario userEnSesion = usuarioService.encontrarUsuario(Long.parseLong(userDetail.getUsername()));
	    ModelAndView vista = new ModelAndView("elegirnivel");
	    vista.addObject("sesion", userEnSesion);
	    return vista;
	  }

	  @GetMapping("/nivel1/{nv}")
	  public ModelAndView Nivel1(@PathVariable(name = "nv") Integer id) {
	    UsuarioPregunta aux = new UsuarioPregunta();
	    Authentication auth = SecurityContextHolder
	        .getContext()
	        .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    Usuario userEnSesion = usuarioService.encontrarUsuario(Long.parseLong(userDetail.getUsername()));
	    if(id==1){
	      usuarioPreguntaService.reiniciarPuntaje(userEnSesion.getDni(), 1);
	    }
	    userEnSesion.setPuntajeNivel1(0);
	    usuarioService.modificarUsuario(userEnSesion);
	    aux.setNivel(1);
	    aux.setUsuario(userEnSesion);
	    aux.setPregunta(preguntaService.buscarPregunta(1, id));
	    ModelAndView vista = new ModelAndView("pregunta");
	    vista.addObject("nro",id);
	    vista.addObject("pregunta", aux.getPregunta());
	    vista.addObject("puntaje", aux);
	    vista.addObject("nivel", true);
	    return vista;
	  }

	  @PostMapping("/subirpuntaje/{nv}")
	  public String subirnivel(@ModelAttribute("puntaje") UsuarioPregunta puntaje, @PathVariable(name = "nv") Integer id) {
	    if(id<=5){
	    usuarioPreguntaService.guardarPuntaje(puntaje);
	      return "redirect:/nivel1/{nv}";
	    }else{
	      usuarioPreguntaService.guardarPuntaje(puntaje);
	    return "redirect:/vernota1";
	    }
	  }

	  @GetMapping("/nivel2/{nv}")
	  public ModelAndView Nivel2(@PathVariable(name = "nv") Integer id) {
	    UsuarioPregunta aux = new UsuarioPregunta();
	    Authentication auth = SecurityContextHolder
	        .getContext()
	        .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    Usuario userEnSesion = usuarioService.encontrarUsuario(Long.parseLong(userDetail.getUsername()));
	    if(id==1){
	      usuarioPreguntaService.reiniciarPuntaje(userEnSesion.getDni(), 2);
	    }
	    userEnSesion.setPuntajeNivel2(0);
	    usuarioService.modificarUsuario(userEnSesion);
	    aux.setNivel(2);
	    aux.setUsuario(userEnSesion);
	    aux.setPregunta(preguntaService.buscarPregunta(2, id));
	    ModelAndView vista = new ModelAndView("pregunta");
	    vista.addObject("nro",id);
	    vista.addObject("pregunta", aux.getPregunta());
	    vista.addObject("puntaje", aux);
	    vista.addObject("nivel", false);
	    return vista;
	  }

	  @PostMapping("/subirpuntaje2/{nv}")
	  public String subirnivel2(@ModelAttribute("puntaje") UsuarioPregunta puntaje, @PathVariable(name = "nv") Integer id) {
	    if(id<=5){
	    usuarioPreguntaService.guardarPuntaje(puntaje);
	      return "redirect:/nivel2/{nv}";
	    }else{
	      usuarioPreguntaService.guardarPuntaje(puntaje);
	    return "redirect:/vernota2";
	    }
	  }
}
