package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pregunta;

@Service
public interface IPreguntaService {
	public List<Pregunta> listarPreguntasPorNivel(Integer nivel);

	public Pregunta buscarPregunta(Integer nivel, int i);

	public void guardarPregunta(Pregunta pregunta);

	public Pregunta actualizarPregunta(Pregunta pregunta);

	public Pregunta obtenerPreguntaporId(Long id);

}
