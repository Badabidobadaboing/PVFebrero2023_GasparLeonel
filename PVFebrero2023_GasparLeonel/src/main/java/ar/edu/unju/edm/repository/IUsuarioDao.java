package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Usuario;

public interface IUsuarioDao extends CrudRepository <Usuario, Long>{
	@Query("from Usuario c order by c.dni")
	public List<Usuario> obtenerUsuario();

}
