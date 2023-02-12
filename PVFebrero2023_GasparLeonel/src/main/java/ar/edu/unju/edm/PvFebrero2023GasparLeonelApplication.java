package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@SpringBootApplication
public class PvFebrero2023GasparLeonelApplication implements CommandLineRunner{
@Autowired
Usuario unUsuario;
@Autowired
IUsuarioService unUser;
	public static void main(String[] args) {
		SpringApplication.run(PvFebrero2023GasparLeonelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		unUsuario.setDni("44877776");
		unUsuario.setApellido("Gaspar");
		unUsuario.setNombre("Leonel Alejandro");
		unUsuario.setPassword("Boing123");
		unUsuario.setTipoUsuario("Docente");
		unUser.guardarUsuario(unUsuario);
	}

}
