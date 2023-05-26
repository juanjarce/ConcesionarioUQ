package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.concesionario.exceptions.CrearEmpleadoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;

public class Administrativo extends Empleado{

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Administrativo
	private Cargo cargo;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase
	
	/**
	 * Constructor vacio de la clase Administrativo
	 */
	public Administrativo() {
		
	}
	/**
	 * Constructor de la clase Administrativo
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param cargo
	 */
	public Administrativo(String nombres, String apellidos, String identificacion, Concesionario concesionario, String usuario, String contrasenia, String correo, String respuestaPreguntaSeguridad, Cargo cargo) {
		super(nombres, apellidos, identificacion, concesionario, usuario, contrasenia, correo, respuestaPreguntaSeguridad);
		this.cargo = cargo;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias

	/**
	 *  Metodo Constructor para pruebas unitarias 1 de la clase Administrativo
	 * @param concesionario
	 */
	public Administrativo(Concesionario concesionario) {
		super(concesionario);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Administrativo
	 */
	@Override
	public String toString() {
		return "Administrativo [cargo=" + cargo + "]";
	}

	/**
	 * getters & setters de la clase administrativo
	 * @return
	 */
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos de la clase Administrativo
	
	/**
	 * Metodo para crear un empleado
	 * @throws CrearEmpleadoException 
	 */
	public String crearEmpleado(String nombres, String apellidos, String identificacion, String usuario, String contrasenia, String correo, String respuestaPreguntaSeguridad) throws CrearEmpleadoException {
		String mensaje;
		if(getConcesionario().verificarEmpleado(identificacion)==false) {
			if(getConcesionario().verificarUsoUsuario(usuario)==false) {
				getConcesionario().listaEmpleados.add(new Empleado(nombres, apellidos, identificacion, getConcesionario(), usuario, contrasenia, correo, respuestaPreguntaSeguridad));
				mensaje = "Empleado creado exitosamente";
			}
			else {
				throw new CrearEmpleadoException("El usuario ya se encuentra en uso");
			}
		}
		else {
			throw new CrearEmpleadoException("El empleado ya se encuentra creado");
		}
		return mensaje;
	}
	/**
	 * Metodo para modificar un empleado
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param concesionario
	 * @return
	 * @throws EmpleadoNoRegistradoException
	 */
	public String modificarEmpleado(String nombres, String apellidos, String identificacion, Concesionario concesionario) throws EmpleadoNoRegistradoException {
		String mensaje;
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacion);
		if(empleado != null) {
			empleado.setNombres(nombres);
			empleado.setApellidos(apellidos);
			empleado.setConcesionario(concesionario);
			mensaje = "Informacion del empleado modificada exitosamente";
		}
		else {
			throw new EmpleadoNoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * Metodo para eliminar un empleado
	 * @throws EmpleadoNoRegistradoException 
	 */
	public String eliminarEmpleado(String identificacion) throws EmpleadoNoRegistradoException {
		String mensaje;
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacion);
		if(empleado != null) {
			getConcesionario().listaEmpleados.remove(empleado);
			mensaje = "El empleado fue eliminado exitosamente";
		}
		else {
			throw new EmpleadoNoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * Metodo para devolver la informacion de un empleado
	 * @throws EmpleadoNoRegistradoException 
	 */
	public String devolverEmpleado(String identificacion) throws EmpleadoNoRegistradoException {
		String mensaje;
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacion);
		if(empleado != null) {
			mensaje = "Nombres:"+" "+empleado.getNombres()+"\n"+"Apellidos:"+" "+empleado.getApellidos()+"\n"+"Identificacion:"+" "+empleado.getIdentificacion()+"\n"+
					"usuario:"+" "+empleado.getUsuario()+"\n"+"Correo:"+" "+empleado.getCorreo();
		}
		else {
			throw new EmpleadoNoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * metodo para bloquear un empleado
	 * @throws EmpleadoNoRegistradoException 
	 */
	public String cambiarEstadoEmpleado(String identificacionEmpleado) throws EmpleadoNoRegistradoException {
		String mensaje;
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacionEmpleado);
		if(empleado != null) {
			if(empleado.getEstado().equals("ACTIVO")) {
				empleado.setEstado("BLOQUEADO");
				mensaje = "Empleado bloqueado Exitosamente";
			}
			else {
				empleado.setEstado("ACTIVO");
				mensaje = "Empleado desbloqueado Exitosamente";
			}
		}
		else {
			throw new EmpleadoNoRegistradoException();
		}
		return mensaje;
	}
	
	/**
	 * Metodo para actualizar la direccion de correo electronico de un empleado
	 * @param identificacion
	 * @param nuevaDireccionCorreo
	 * @return
	 * @throws EmpleadoNoRegistradoException
	 */
	public String actualizarCorreoEmpleado(String identificacion, String nuevaDireccionCorreo) throws EmpleadoNoRegistradoException {
		String mensaje;
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacion);
		if(empleado != null) {
			empleado.setCorreo(nuevaDireccionCorreo);
			mensaje="El correo electronico fue actualizado exitosamente con direccion:"+"\n"+nuevaDireccionCorreo;
		}
		else {
			throw new EmpleadoNoRegistradoException();
		}
		return mensaje;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Funciones para obtener reportes de venta de administrador
	
	/**
	 * Metodo para obtener las transacciones realizadas entre un rango de tiempo en un concesionario
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return
	 */
	public List<Transaccion> obtenerTransaccionesEntreFechas(String fechaInicio, String fechaFinal){
		List<Transaccion> listaTransaccionesEntreFechas = new ArrayList<Transaccion>();
		for(Transaccion transaccion : getConcesionario().getListaTransacciones()) {
			if(Concesionario.isEntreFechas(transaccion.getFecha(), fechaInicio, fechaFinal)) {
				listaTransaccionesEntreFechas.add(transaccion);
			}
		}
		return listaTransaccionesEntreFechas;
	}
	
}
