package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Cliente
	public List<Transaccion> listaTransacciones;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de clase Cliente
	 */
	public Cliente() {
		
	}
	/**
	 * Metodo constructor de la clase Cliente
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 */
	public Cliente(String nombres, String apellidos, String identificacion) {
		super(nombres, apellidos, identificacion);
		this.listaTransacciones = new ArrayList<Transaccion>();
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * toString clase Cliente
	 */
	@Override
	public String toString() {
		return "Cliente [listaTransacciones=" + listaTransacciones + "]";
	}
	
	/**
	 * setters & getters clase Cliente
	 * @return
	 */
	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	public void setListaTransacciones(List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	
}
