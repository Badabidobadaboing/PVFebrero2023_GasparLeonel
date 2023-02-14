package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Pregunta;

@Repository
public interface IPreguntaDao extends CrudRepository <Pregunta, Long>{
	@Query("from Pregunta c order by c.codPregunta")
	public List<Pregunta> obtenerPregs();

}
