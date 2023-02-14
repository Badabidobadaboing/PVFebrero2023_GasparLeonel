package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name="PREGUNTAS")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long codPregunta;
	@Column
	private String enunciado;
	@Column
	private Integer nivel;
	@Column
	private String opcion01;
	@Column
	private String opcion02;
	@Column
	private String opcion03;
	@Column
	private String opcionCorrecta;
	@Column
	private Integer Puntaje;
	@Column
	private Boolean estado;
	
	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	public Pregunta(Long codPregunta, String enunciado, Integer nivel, String opcion01, String opcion02,
			String opcion03, String opcionCorrecta, Integer puntaje, Boolean estado) {
		super();
		this.codPregunta = codPregunta;
		this.enunciado = enunciado;
		this.nivel = nivel;
		this.opcion01 = opcion01;
		this.opcion02 = opcion02;
		this.opcion03 = opcion03;
		this.opcionCorrecta = opcionCorrecta;
		Puntaje = puntaje;
		this.estado = estado;
	}

	public Long getCodPregunta() {
		return codPregunta;
	}

	public void setCodPregunta(Long codPregunta) {
		this.codPregunta = codPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getOpcion01() {
		return opcion01;
	}

	public void setOpcion01(String opcion01) {
		this.opcion01 = opcion01;
	}

	public String getOpcion02() {
		return opcion02;
	}

	public void setOpcion02(String opcion02) {
		this.opcion02 = opcion02;
	}

	public String getOpcion03() {
		return opcion03;
	}

	public void setOpcion03(String opcion03) {
		this.opcion03 = opcion03;
	}

	public String getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(String opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}

	public Integer getPuntaje() {
		return Puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		Puntaje = puntaje;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	

}
