package ar.edu.unju.edm.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "USUARIOS")
public class Usuario {
	@Id
	@Column
	private long dni;
	@Column
	private String apellido;
	@Column
	private String nombre;
	@Column
	private String fechaNac;
	@Column
	private String password;
	@Column
	private String tipoUsuario;
	@Column
	private Integer puntajeNivel1;
	@Column
	private Integer puntajeNivel2;
	@Column
	private Boolean estado;

	public Usuario() {

	}

	public Usuario(long dni, String apellido, String nombre, String fechaNac, String password, String tipoUsuario,
			Integer puntajeNivel1, Integer puntajeNivel2, Boolean estado) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.puntajeNivel1 = puntajeNivel1;
		this.puntajeNivel2 = puntajeNivel2;
		this.estado = estado;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getPuntajeNivel1() {
		return puntajeNivel1;
	}

	public void setPuntajeNivel1(Integer puntajeNivel1) {
		this.puntajeNivel1 = puntajeNivel1;
	}

	public Integer getPuntajeNivel2() {
		return puntajeNivel2;
	}

	public void setPuntajeNivel2(Integer puntajeNivel2) {
		this.puntajeNivel2 = puntajeNivel2;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
}
