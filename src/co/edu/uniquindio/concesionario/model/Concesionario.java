package co.edu.uniquindio.concesionario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import co.edu.uniquindio.concesionario.exceptions.AdministrativoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.exceptions.UsuarioException;


public class Concesionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Concesionario
	private String nombre;
	private String nit;
	private String direccion;
	private Integer consecutivoVentas;
	private Integer consecutivoCompras;
	private Integer consecutivoAlquileres;
	public List<Empleado> listaEmpleados;
	public List<Cliente> listaClientes;
	public List<Vehiculo> listaVehiculos;
	public List<Transaccion> listaTransacciones;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo contructor vacio de la clase Concesionario
	 */
	public Concesionario() {
		
	}
	/**
	 * Metodo constructor de la clase Concesionario
	 */
	public Concesionario(String nombre, String nit, String direccion) {
		super();
		this.nombre = nombre;
		this.nit = nit;
		this.direccion = direccion;
		this.consecutivoVentas = 1;
		this.consecutivoCompras = 1;
		this.consecutivoAlquileres = 1;
		this.listaEmpleados = new ArrayList<Empleado>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaVehiculos = new ArrayList<Vehiculo>();
		this.listaTransacciones = new ArrayList<Transaccion>();
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias

	/**
	 * constructor para pruebas
	 * @param listaEmpleadosCrearEmpleado
	 */
	public Concesionario(List<Empleado> listaEmpleadosCrearEmpleado) {
		this.listaEmpleados = listaEmpleadosCrearEmpleado;
	}
	
	public Concesionario(List<Transaccion> listaTransacciones, String nombre) {
		this.nombre = nombre;
		this.listaTransacciones = listaTransacciones;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * toString clase Concesionario
	 */
	@Override
	public String toString() {
		return "Concesionario [nombre=" + nombre + ", nit=" + nit + ", direccion=" + direccion + "]";
	}
	
	/**
	 * .equals y hashCode calse Concesionario
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concesionario other = (Concesionario) obj;
		return Objects.equals(nit, other.nit);
	}
	
	/**
	 * getter & setter de la clase Concesionario
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	public void setListaTransacciones(List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	public Integer getConsecutivoVentas() {
		return consecutivoVentas;
	}
	public void setConsecutivoVentas(Integer consecutivoVentas) {
		this.consecutivoVentas = consecutivoVentas;
	}
	public Integer getConsecutivoCompras() {
		return consecutivoCompras;
	}
	public void setConsecutivoCompras(Integer consecutivoCompras) {
		this.consecutivoCompras = consecutivoCompras;
	}
	public Integer getConsecutivoAlquileres() {
		return consecutivoAlquileres;
	}
	public void setConsecutivoAlquileres(Integer consecutivoAlquileres) {
		this.consecutivoAlquileres = consecutivoAlquileres;
	}

	//Metodo de la clase Concesionario
	
		/**
	 * Metodo para encontrar posicion del usuario en el login
	 */
	public int encontrarPosUsuario(String usuario) {
		int pos=-1;
		for(int i=0; i<listaEmpleados.size(); i++) {
			if(listaEmpleados.get(i).getUsuario().equals(usuario)) {
				pos = i;
				break;
			}
		}
		return pos;
	}
	/**
	 * Metodo para generar un String aleatorio
	 */
	public String generarStringAleatorio() {
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String cadena="";
		for(int i=0; i<banco.length(); i++) {
			int indiceAleatorio = numeroAleatorioEnRango(0, banco.length()-1);
			char caracterAleatorio = banco.charAt(indiceAleatorio);
			cadena += caracterAleatorio;
		}
		return cadena;
	}
	/**
	 * Metodo para obtener un numero aleatorio en un rango
	 */
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
	    // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
	    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
	/**
	 * Metodo para verificar si un usuario esta en uso
	 */
	public boolean verificarUsoUsuario(String usuario) {
		return listaEmpleados.stream().anyMatch(empleado -> empleado.getUsuario().equals(usuario));
	}
	/**
	 * metodo para obtener un administrativo
	 * @param identificacion
	 * @return
	 */
	public Administrativo obtenerAdministrativo(String identificacion) {
		Administrativo administrativo = null;
		try {
			administrativo = (Administrativo) listaEmpleados.stream().filter(empleado -> empleado.getIdentificacion().equals(identificacion)).findFirst().get();
		}
		catch(Exception e) {
			
		}
		return administrativo;
	}
	/**
	 * metodo para crear un administrativo
	 * @throws CrearAdministrativoException 
	 */
	public String crearAdministrativo(String nombres, String apellidos, String identificacion, Concesionario concesionario, String usuario, String contrasenia, String correo, String respuestaPreguntaSeguridad, Cargo cargo) throws CrearAdministrativoException {
		String mensaje;
		Administrativo administrativo = obtenerAdministrativo(identificacion);
		if(administrativo == null) {
			if(verificarUsoUsuario(usuario)==false) {
				listaEmpleados.add(new Administrativo(nombres, apellidos, identificacion, concesionario, usuario, contrasenia, correo, respuestaPreguntaSeguridad, cargo));
				mensaje = "Administrativo creado exitosamente";
			}
			else {
				throw new CrearAdministrativoException("El usuario ya esta en uso");
			}
		}
		else {
			throw new CrearAdministrativoException("El administrativo ya se encuentra registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para modificar la informacion de un administrativo
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param concesionario
	 * @param cargo
	 * @return
	 * @throws AdministrativoNoRegistradoException
	 */
	public String modificarAdministrativo(String nombres, String apellidos, String identificacion, Concesionario concesionario, Cargo cargo) throws AdministrativoNoRegistradoException {
		String mensaje;
		Administrativo administrativo = obtenerAdministrativo(identificacion);
		if(administrativo == null) {
			throw new AdministrativoNoRegistradoException();
		}
		else {
			administrativo.setNombres(nombres);
			administrativo.setApellidos(apellidos);
			administrativo.setConcesionario(concesionario);
			administrativo.setCargo(cargo);
			mensaje="El administrativo fue modificado exitosamente";
		}
		return mensaje;
	}
	/**
	 * Metodo para obtener un empleado
	 */
	public Empleado obtenerEmpleado(String identificacion) {
		Empleado empleado = null;
		try {
			empleado=listaEmpleados.stream().filter(empleadoaux -> empleadoaux.getIdentificacion().equals(identificacion)).findFirst().get();
		}
		catch(Exception e){
			
		}
		return empleado;
	}
	/**
	 * Metodo para verificar si un empleado existe en el concesionario
	 */
	public boolean verificarEmpleado(String identificacion) {
		return listaEmpleados.stream().anyMatch(empleado -> empleado.getIdentificacion().equals(identificacion));
	}
	
	/**
	 * @throws UsuarioException 
	 * 
	 */
	public String cambiarInformacionUsuario(Empleado empleado, String usuarioNuevo, String contraseniaNueva) throws UsuarioException {
		String mensaje;
		if(empleado != null) {
			if(verificarUsoUsuario(usuarioNuevo)==false || empleado.getUsuario().equals(usuarioNuevo)) {
				empleado.setUsuario(usuarioNuevo);
				empleado.setContrasenia(contraseniaNueva);
				mensaje = "Usuario y Contraseña modificada exitosamente";
			}
			else {
				throw new UsuarioException("El usuario nuevo ya esta en uso");
			}
		}
		else {
			throw new UsuarioException("El empleado no se encuentra registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para devolver el dia de una fecha en formato String dd.mm.aa como Integer
	 * @param fecha
	 * @return
	 */
	public static int devolverDiaFecha(String fecha)
	{
		String dia=fecha.substring(0,fecha.indexOf("."));
		int diaFecha=Integer.parseInt(dia);
		return diaFecha;
	}
	/**
	 * Metodo para devolver el mes de una fecha en formato String dd.mm.aa como Integer
	 * @param fecha
	 * @return
	 */
	public static int devolverMesFecha(String fecha)
	{
		String mes=fecha.substring(fecha.indexOf(".")+1,fecha.lastIndexOf("."));
		int mesFecha=Integer.parseInt(mes);
		return mesFecha;
	}
	/**
	 * Metodo para devolver el año de una fecha en formato String dd.mm.aa como Integer
	 * @param fecha
	 * @return
	 */
	public static int devolverAñoFecha(String fecha)
	{
		String año=fecha.substring(fecha.lastIndexOf(".")+1,fecha.length());
		int añoFecha=Integer.parseInt(año);
		return añoFecha;
	}
	/**
	 * Metodo para verificar si una fecha esta entre la fechaIncio y la fechaFinal del parametro
	 * @param fecha
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return
	 */
	public static boolean isEntreFechas(String fecha, String fechaInicio, String fechaFinal)
	{
		boolean centinela=false;
		int añoFecha=devolverAñoFecha(fecha); int mesFecha=devolverMesFecha(fecha); int diaFecha=devolverDiaFecha(fecha);
		int añoFechaInicio=devolverAñoFecha(fechaInicio); int mesFechaInicio=devolverMesFecha(fechaInicio); int diaFechaInicio=devolverDiaFecha(fechaInicio);
		int añoFechaFinal=devolverAñoFecha(fechaFinal); int mesFechaFinal=devolverMesFecha(fechaFinal); int diaFechaFinal=devolverDiaFecha(fechaFinal);
		if(mesFechaInicio==mesFechaFinal && añoFechaInicio==añoFechaFinal && mesFecha==mesFechaInicio && añoFecha==añoFechaInicio && diaFecha>=diaFechaInicio && diaFecha<=diaFechaFinal)
		{
			centinela=true;
		}
		else
			if(mesFechaInicio!=mesFechaFinal && añoFechaInicio==añoFechaFinal &&((diaFecha>=diaFechaInicio && mesFecha==mesFechaInicio && añoFecha==añoFechaInicio)||(mesFecha>mesFechaInicio && mesFecha<mesFechaFinal && 
					añoFecha==añoFechaInicio)||(diaFecha<=diaFechaFinal && mesFecha==mesFechaFinal && añoFecha==añoFechaFinal)))
			{
				centinela=true;
			}
			else
				if(añoFechaInicio!=añoFechaFinal&&((diaFecha>=diaFechaInicio && mesFecha==mesFechaInicio && añoFecha==añoFechaInicio)||(diaFecha<=diaFechaFinal && mesFecha==mesFechaFinal && añoFecha==añoFechaFinal)
						||(añoFecha>añoFechaInicio && añoFecha<añoFechaFinal)||(mesFecha>mesFechaInicio && añoFecha==añoFechaInicio)||(mesFecha<mesFechaFinal && añoFecha==añoFechaFinal)))
				{
					centinela=true;
				}
		return centinela;
	}
	
	/**
	 * Metodo para aumentar el consecutivo de ventas despues de una venta
	 */
	public void añadirVentaConsecutivo() {
		setConsecutivoVentas(getConsecutivoVentas()+1);
	}
	
	/**
	 * Metodo para aumentar el consecutivo de compras despues de una compra
	 */
	public void añadirCompraConsecutivo() {
		setConsecutivoCompras(getConsecutivoCompras()+1);
	}
	
	/**
	 * Metodo para aumentar el consecutivo de alquileres despues de un alquiler
	 */
	public void añadirAlquilerConsecutivo() {
		setConsecutivoAlquileres(getConsecutivoAlquileres()+1);
	}
}
