package co.edu.uniquindio.concesionario.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Persona
	private String nombres;
	private String apellidos;
	private String identificacion;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de la clase abstarcta Persona
	 */
	public Persona() {
		
	}
	/**
	 * Metodo contructor de la clase Persona
	 */
	public Persona(String nombres, String apellidos, String identificacion) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo toString de la clase Persona
	 */
	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion + "]";
	}

	/**
	 * hashCode y .equals de la clase Persona
	 */
	@Override
	public int hashCode() {
		return Objects.hash(identificacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(identificacion, other.identificacion);
	}
	
	/**
	 * setters & getters de la clase Persona
	 * @return
	 */
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

}
