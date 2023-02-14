package ar.edu.unju.edm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "NOTAS")
public class UsuarioPregunta {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer puntajeTotal;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dni")
	private Usuario usuario;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codPregunta")
	private Pregunta pregunta;
	private Integer nivel;
	
	public UsuarioPregunta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioPregunta(Long id, Integer puntajeTotal, Usuario usuario, Pregunta pregunta, Integer nivel) {
		super();
		this.id = id;
		this.puntajeTotal = puntajeTotal;
		this.usuario = usuario;
		this.pregunta = pregunta;
		this.nivel = nivel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPuntajeTotal() {
		return puntajeTotal;
	}

	public void setPuntajeTotal(Integer puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	

}
