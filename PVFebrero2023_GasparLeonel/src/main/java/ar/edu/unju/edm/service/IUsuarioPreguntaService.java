package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.model.UsuarioPregunta;

public interface IUsuarioPreguntaService {
	public List<UsuarioPregunta> buscarIdUsuario(Long id, Integer nivel);

	public Integer SumarPuntaje(List<UsuarioPregunta> puntaje);

	public void guardarPuntaje(UsuarioPregunta puntaje);

	public void reiniciarPuntaje(Long id, Integer nivel);
}
