package co.edu.uniquindio.concesionario.controllers;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.exceptions.UsuarioException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Cargo;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.Vehiculo;
import co.edu.uniquindio.concesionario.serializacion.Serializacion;

public class ModelFactoryController {

	private Concesionario miConcesionario;
	private Administrativo miAdministrativo;
	private Empleado miEmpleado;
	private Vehiculo vehiculo;
	
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {
		System.out.println("invocaci�n clase singleton");
		inicializarDatos();
	}

	private void inicializarDatos() {

		miConcesionario = new Concesionario("Carros UQ", "12345", " Carrera 15 #12N, Armenia, Quindío");
		
		if(Serializacion.deserializar() != null) {
			this.miConcesionario = Serializacion.deserializar();
		}

	}

	//setters() & getters del Singleton del Concesionario
	public Concesionario getMiConcesionario() {
		return miConcesionario;
	}

	public void setMiConcesionario(Concesionario miConcesionario) {
		this.miConcesionario = miConcesionario;
	}

	public Administrativo getMiAdministrativo() {
		return miAdministrativo;
	}

	public void setMiAdministrativo(Administrativo miAdministrativo) {
		this.miAdministrativo = miAdministrativo;
	}

	public Empleado getMiEmpleado() {
		return miEmpleado;
	}

	public void setMiEmpleado(Empleado miEmpleado) {
		this.miEmpleado = miEmpleado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------
	//Funciones del concesionario para el singleton
	
	/**
	 * Conexion entre el metodo de generar un String aletario en el concesionario con el singleton
	 * @return
	 */
	public String generarStringAleatorio() {
		return miConcesionario.generarStringAleatorio();
	}
	
	/**
	 * Conexion entre el metodo de obtener un empleado por su identificacion en el concesionario con el singleton
	 * @param identificacion
	 * @return
	 */
	public Empleado obtenerEmpleado(String identificacion) {
		return miConcesionario.obtenerEmpleado(identificacion);
	}
	
	/**
	 * Conexion entre el metodo de cambiar la informacion de un usuario en el concesionario con el singleton
	 * @param identificacion
	 * @return
	 */
	public String cambiarInformacionUsuario(Empleado empleado, String usuario, String contrasenia) throws UsuarioException {
		
		String mensaje = miConcesionario.cambiarInformacionUsuario(empleado, usuario, contrasenia);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Se almacenan los datos en archivos
		Serializacion.serializar(miConcesionario);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------

		return mensaje;
	}
	
	/**
	 * Conexion entre el metodo de crear un administrativo en el concesionario con el singleton
	 * @param identificacion
	 * @return
	 */
	public String crearAdministrativo(String nombres, String apellidos, String identificacion, String usuario, String contrasenia, String correo, String respuestaSeguridad, Cargo cargo) throws CrearAdministrativoException {
		
		String mensaje = miConcesionario.crearAdministrativo(nombres, apellidos, identificacion, miConcesionario, usuario, contrasenia, correo, respuestaSeguridad, cargo);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Se almacenan los datos en archivos
		Serializacion.serializar(miConcesionario);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------

		return mensaje;
	}
	
	/**
	 * Conexion entre el metodo de setear la lista de imagenes en el vehiculo con el singleton
	 * @param identificacion
	 * @return
	 */
	public void setListaImagenes(ArrayList<String> listaImagenesVehiculo) {
		vehiculo.setListaImagenes(listaImagenesVehiculo);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Se almacenan los datos en archivos
    	Serializacion.serializar(miConcesionario);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	}
	
	/**
	 * Conexion entre el metodo de obtener la lista de imagenes en el vehiculo con el singleton
	 * @param identificacion
	 * @return
	 */
	public ArrayList<String> getListaImagenes(){
		return vehiculo.getListaImagenes();
	}
	
	/**
	 * Conexion entre el metodo de encontrar la posicion de un usuario en el concesionario con el singleton
	 * @param identificacion
	 * @return
	 */
	public int encontrarPosUsuario(String usuario) {
		return miConcesionario.encontrarPosUsuario(usuario);
	}
	
	/**
	 * Conexion entre el metodo de obtener un administrativo en el concesionario con el singleton
	 * @param identificacion
	 * @return
	 */
	public Administrativo obtenerAdministrativo(String identificacion) {
		return miConcesionario.obtenerAdministrativo(identificacion);
	}
			
	/**
	 * Metodo para serealizar desde el singleton
	 */
	public void serializar() {
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Se almacenan los datos en archivos
		Serializacion.serializar(miConcesionario);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	}
	
	/**
	 * Metodo para devolver la lista de empleados del Concesionario en el Singleton
	 * @return
	 */
	public List<Empleado> obtenerListaEmpleados() {
		return miConcesionario.getListaEmpleados();
	}

	/**
	 * Metodo para devolver la lista de clientes del Concesionario en el Singleton
	 * @return
	 */
	public List<Cliente> obtenerListClientes() {
		return miConcesionario.getListaClientes();
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------

}
