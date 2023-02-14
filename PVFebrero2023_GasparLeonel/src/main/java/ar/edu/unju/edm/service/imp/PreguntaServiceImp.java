package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pregunta;
import ar.edu.unju.edm.repository.IPreguntaDao;
import ar.edu.unju.edm.service.IPreguntaService;

@Service
public class PreguntaServiceImp implements IPreguntaService {
	@Autowired
	IPreguntaDao preguntaRepository;

	@Override
	public List<Pregunta> listarPreguntasPorNivel(Integer nivel) {
		// TODO Auto-generated method stub
		List<Pregunta> auxiliar = new ArrayList<>();
		List<Pregunta> aux2 = new ArrayList<>();
		auxiliar = (List<Pregunta>) preguntaRepository.findAll();
		for (int i = 0; i < auxiliar.size(); i++) {
			if (auxiliar.get(i).getNivel().equals(nivel)) {
				aux2.add(auxiliar.get(i));
			}
		}
		return aux2;
	}

	@Override
	public Pregunta buscarPregunta(Integer nivel, int i) {
		// TODO Auto-generated method stub
		List<Pregunta> preguntas = listarPreguntasPorNivel(nivel);
		Pregunta aux=null;
		for (int j = 0; j < i; j++) {
			aux=preguntas.get(j);
		}
		return aux;
	}

	@Override
	public void guardarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		pregunta.setEstado(true);
		preguntaRepository.save(pregunta);

	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return preguntaRepository.save(pregunta);
	}

	@Override
	public Pregunta obtenerPreguntaporId(Long id) {
		// TODO Auto-generated method stub
		return preguntaRepository.findById(id).get();
	}
}
