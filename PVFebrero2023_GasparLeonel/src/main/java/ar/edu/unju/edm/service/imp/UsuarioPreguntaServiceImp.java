package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioPregunta;
import ar.edu.unju.edm.repository.IUsuarioPreguntaDao;
import ar.edu.unju.edm.service.IUsuarioPreguntaService;

@Service
public class UsuarioPreguntaServiceImp implements IUsuarioPreguntaService {
	@Autowired
	IUsuarioPreguntaDao userPregRepository;

	@Override
	public Integer SumarPuntaje(List<UsuarioPregunta> puntaje) {
		// TODO Auto-generated method stub
		Integer aux = 0;
		for (int i = 0; i < puntaje.size(); i++) {
			aux = aux + puntaje.get(i).getPuntajeTotal();
		}
		return aux;
	}

	@Override
	public List<UsuarioPregunta> buscarIdUsuario(Long id, Integer nivel) {
		List<UsuarioPregunta> auxiliar = new ArrayList<>();
		List<UsuarioPregunta> aux2 = new ArrayList<>();
		auxiliar = (List<UsuarioPregunta>) userPregRepository.findAll();
		for (int i = 0; i < auxiliar.size(); i++) {
			if (auxiliar.get(i).getUsuario().getDni() == id && auxiliar.get(i).getNivel().equals(nivel)) {
				aux2.add(auxiliar.get(i));
			}
		}
		return aux2;
	}

	@Override
	public void guardarPuntaje(UsuarioPregunta puntaje) {
		// TODO Auto-generated method stub
		userPregRepository.save(puntaje);

	}

	@Override
	public void reiniciarPuntaje(Long id, Integer nivel) {
		// TODO Auto-generated method stub
		List<UsuarioPregunta> auxiliar = new ArrayList<>();
		auxiliar = (List<UsuarioPregunta>) userPregRepository.findAll();
		for (int i = 0; i < auxiliar.size(); i++) {
			if (auxiliar.get(i).getUsuario().getDni() == id && auxiliar.get(i).getNivel().equals(nivel)) {
				auxiliar.get(i).setPuntajeTotal(0);
				userPregRepository.save(auxiliar.get(i));
			}
		}

	}

}
