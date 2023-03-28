package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.ContraseniaException;
import co.edu.uniquindio.concesionario.exceptions.CrearClienteException;
import co.edu.uniquindio.concesionario.exceptions.TransaccionException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;

public class Empleado extends Persona implements CrearVehiculo, RealizarTransaccion{

	private Concesionario concesionario;
	private String usuario;
	private String contrasenia;
	public String estado;
	public String correo;
	public String respuestaPreguntaSeguridad;
	public List<Transaccion> listaTransacciones;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Constructor vacio de la clase Empleado
	 */
	public Empleado() {
		
	}
	/**
	 * Metodo constructor de la clase Empleado
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param idEmpleado
	 * @param concesionario
	 */
	public Empleado(String nombres, String apellidos, String identificacion, Concesionario concesionario, String usuario, String contrasenia, String correo, String respuestaPreguntaSeguridad) {
		super(nombres, apellidos, identificacion);
		this.concesionario = concesionario;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.estado = "ACTIVO";
		this.correo = correo;
		this.respuestaPreguntaSeguridad = respuestaPreguntaSeguridad;
		this.listaTransacciones = new ArrayList<Transaccion>();
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias
	
	/**
	 * constructor para pruebas unitarias 1
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param concesionario
	 */
	public Empleado(String nombres, String apellidos, String identificacion, Concesionario concesionario) {
		super(nombres, apellidos, identificacion);
		this.concesionario = concesionario;
	}
	
	/**
	 * constructor para pruebas unitarias 2
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 */
	public Empleado(String nombres, String apellidos, String identificacion) {
		super(nombres, apellidos, identificacion);
	}
	
	/**
	 * Constructor para pruebas unitarias 3
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param estado
	 */
	public Empleado(String nombres, String apellidos, String identificacion, String estado) {
		super(nombres, apellidos, identificacion);
		this.estado = estado;
	}
	
	/**
	 * Metodo contructor para pruebas unitarias 4 de la clase Empleado 
	 * @param concesionario
	 */
	public Empleado(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * metodo toString de la clase Empleado
	 */
	@Override
	public String toString() {
		return "Empleado [concesionario=" + concesionario + ", listaTransacciones=" + listaTransacciones + "]";
	}

	/**
	 * getters & setters de la clase Empleado
	 * @return
	 */
	public Concesionario getConcesionario() {
		return concesionario;
	}
	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRespuestaPreguntaSeguridad() {
		return respuestaPreguntaSeguridad;
	}
	public void setRespuestaPreguntaSeguridad(String respuestaPreguntaSeguridad) {
		this.respuestaPreguntaSeguridad = respuestaPreguntaSeguridad;
	}
	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	public void setListaTransacciones(List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}

	/**
	 * Metodo para cambiar la contraseña de un empleado
	 * @throws ContraseniaException 
	 */
	public String cambiarContraseñaEmpleado(String identificacion, String contrasenia, String respuestaPreguntaSeguridad) throws ContraseniaException {
		String mensaje;
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacion);
		if(empleado != null) {
			if(empleado.getRespuestaPreguntaSeguridad().equals(respuestaPreguntaSeguridad)) {
				empleado.setContrasenia(contrasenia);
				mensaje = "La contraseña fue modificada exitosamente";
			}
			else {
				throw new ContraseniaException("La respuesta de seguridad no coincide");
			}
		}
		else {
			throw new ContraseniaException("El empleado no se encuentra registrado");
		}
		return mensaje;
	}
	/**
	 * metodo para obtener un Cliente
	 * @param identificacion
	 * @return
	 */
	public Cliente obtenerCliente(String identificacion) {
		Cliente cliente = null;
		try {
			cliente = getConcesionario().listaClientes.stream().filter(clienteaux -> clienteaux.getIdentificacion().equals(identificacion)).findFirst().get();
		}
		catch(Exception e) {
			
		}
		return cliente;
	}
	/**
	 * metodo para crear un administrativo
	 * @throws CrearClienteException 
	 */
	public String crearCliente(String nombres, String apellidos, String identificacion) throws CrearClienteException {
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente == null) {
			getConcesionario().listaClientes.add(new Cliente(nombres, apellidos, identificacion));
			mensaje = "El cliente fue creado exitosamente";
		}
		else {
			throw new CrearClienteException("El cliente ya se encuentra registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para modificar la informacion de un cliente
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @return
	 * @throws ClienteNoRegistradoException
	 */
	public String modificarCliente(String nombres, String apellidos, String identificacion) throws ClienteNoRegistradoException {
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente == null) {
			throw new ClienteNoRegistradoException();
		}
		else {
			cliente.setNombres(nombres);
			cliente.setApellidos(apellidos);
			mensaje="El cliente fue modificado exitosamente";
		}
		return mensaje;
	}
	/**
	 * Metodo para eliminar un cliente
	 * @throws ClienteNoRegistradoException 
	 */
	public String eliminarCliente(String identificacion) throws ClienteNoRegistradoException {
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente != null) {
			getConcesionario().listaClientes.remove(cliente);
			mensaje = "El cliente fue eliminado exitosamente";
		}
		else {
			throw new ClienteNoRegistradoException();
		}
		return mensaje;
	}

	/**
	 * metodo para devolver la informacion de un cliente
	 * @throws ClienteNoRegistradoException 
	 */
	public String devolverCliente(String identificacion) throws ClienteNoRegistradoException {
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente == null) {
			throw new ClienteNoRegistradoException();
		}
		else {
			mensaje = "Nombres:"+" "+cliente.getNombres()+"\n"+"Apellidos:"+" "+cliente.getApellidos()+"\n"+
					"Identificacion:"+" "+cliente.getIdentificacion()+"\n"+"Lista Transacciones:"+" "+cliente.getListaTransacciones();
		}
		return mensaje;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos para registrar vehiculos
	/**
	 * metodo para obtener un vehiculo
	 */
	public Vehiculo obtenerVehiculo(String codigo) {
		Vehiculo vehiculo = null;
		try {
			vehiculo = getConcesionario().listaVehiculos.stream().filter(vehiculoaux -> vehiculoaux.getCodigo().equals(codigo)).findFirst().get();
		}catch(Exception e) {
			
		}
		return vehiculo;
	}
	/**
	 * Metodo para crear una moto
	 * @throws VehiculoRegistradoException 
	 */
	public String crearMoto(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Moto(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * Metodo para crear un vehiculo tipo sedan
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @param sensorColision
	 * @param sensorTraficoCruzado
	 * @param permanenciaCarril
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearSedan(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean sensorColision, boolean sensorTraficoCruzado,
			boolean permanenciaCarril) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Sedan(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido, sensorColision,
				sensorTraficoCruzado, permanenciaCarril ));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * metodo para crear un vehiculo de tipo deportivo
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @param numeroCaballosDeFuerza
	 * @param segundosAlcanza100
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearDeportivo(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, Double numeroCaballosDeFuerza, Integer segundosAlcanza100) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Deportivo(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido, numeroCaballosDeFuerza, segundosAlcanza100));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * metodo para crear un vehiculo de tipo camioneta
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @param sensorColision
	 * @param sensorTraficoCruzado
	 * @param permanenciaCarril
	 * @param is4x4
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearCamioneta(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean sensorColision, boolean sensorTraficoCruzado,
			boolean permanenciaCarril, boolean is4x4) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Camioneta(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
					capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
					categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido, sensorColision,
					sensorTraficoCruzado, permanenciaCarril, is4x4));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * metodo para crear un vehiculo de tipo PickUp
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @param is4x4
	 * @param capacidadCajaDeCargas
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearPickUp(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean is4x4, Double capacidadCajaDeCargas) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new PickUp(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido, is4x4, capacidadCajaDeCargas));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * Metodo para crear un Vehiculo de tipo Van
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearVan(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Van(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * Metodo para crear un Vehiculo de tipo Bus
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @param numeroEjes
	 * @param numeroSalidasEmergencia
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearBus(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, Integer numeroEjes, Integer numeroSalidasEmergencia) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Bus(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido, numeroEjes, numeroSalidasEmergencia));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	/**
	 * Metodo para crear un Vehiculo de tipo Camion
	 * @param codigo
	 * @param marca
	 * @param condicion
	 * @param modelo
	 * @param transmicion
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 * @param aireAcondicionado
	 * @param camaraReversa
	 * @param velocidadCrucero
	 * @param numeroBolsasDeAire
	 * @param aBS
	 * @param tipoVehiculo
	 * @param categoriaVehiculo
	 * @param electrico_autonomia
	 * @param electrico_tiempoCarga
	 * @param hibrido_isEnchufable
	 * @param tipoHibrido
	 * @param capacidadCarga
	 * @param numeroEjes
	 * @param numeroSalidasEmergencia
	 * @return
	 * @throws VehiculoRegistradoException
	 */
	public String crearCamion(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, Double capacidadCarga, Integer numeroEjes, Integer numeroSalidasEmergencia) throws VehiculoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo == null) {
			getConcesionario().listaVehiculos.add(new Camion(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
					capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
					categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido, capacidadCarga, numeroEjes, numeroSalidasEmergencia));
			mensaje = "El vehiculo fue creado exitosamente";
		}
		else {
			throw new VehiculoRegistradoException();
		}
		return mensaje;
	}
	
	/**
	 * metodo para eliminar un Vehiculo
	 * @throws VehiculoNoRegistradoException 
	 */
	public String eliminarVehiculo(String codigo) throws VehiculoNoRegistradoException {
		String mensaje;
		Vehiculo vehiculo = obtenerVehiculo(codigo);
		if(vehiculo != null) {
			getConcesionario().listaVehiculos.remove(vehiculo);
			mensaje = "El vehiculo fue eliminado exitosamente";
		}
		else {
			throw new VehiculoNoRegistradoException();
		}
		return mensaje;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos de transacciones
	
	/**
	 * Metodo para realizar una Venta
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 * @param fecha
	 * @param consecutivo
	 * @return
	 * @throws TransaccionException
	 */
	public String venderVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha) throws TransaccionException {
		String mensaje;
		if(vehiculo != null) {
			if(vehiculo.getDisponibleTransaccion() == true) {
				if(vehiculo.getAlquilado() == false) {
					if(empleadoTransaccion != null) {
						if(clienteTransaccion != null) {
							Integer consecutivo = getConcesionario().getConsecutivoVentas();
							Venta venta = new Venta(total, vehiculo, empleadoTransaccion, clienteTransaccion, fecha, consecutivo);
							getConcesionario().listaTransacciones.add(venta);
							empleadoTransaccion.listaTransacciones.add(venta);
							clienteTransaccion.listaTransacciones.add(venta);
							vehiculo.cambiarDisponibilidadVehiculoPorTransaccion();
							mensaje = "Transaccion realizada correctamente - Venta de Vehiculo";
							getConcesionario().añadirVentaConsecutivo();
						}
						else {
							throw new TransaccionException("El cliente de la transaccion no se encuentra registrado");
						}
					}
					else {
						throw new TransaccionException("El empleado de la transaccion no se encuentra registrado");
					}
				}
				else {
					throw new TransaccionException("El vehiculo se encuentra alquilado");
				}
			}
			else {
				throw new TransaccionException("El vehiculo no se ha comprado");
			}
		}
		else {
			throw new TransaccionException("El vehiculo a vender no se encuentra registrado");
		}
		return mensaje;
	}
	
	/**
	 * Metodo para comprar un vehiculo
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 * @param fecha
	 * @param consecutivo
	 * @return
	 * @throws TransaccionException
	 */
	public String comprarVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha, String pasaRevision) throws TransaccionException {
		String mensaje;
		if(pasaRevision.equals("NO")) throw new TransaccionException("El vehiculo no paso la revision");
		if(vehiculo != null) {
			if(vehiculo.getDisponibleTransaccion()==false) {
				if(empleadoTransaccion != null) {
					if(clienteTransaccion != null) {
						Integer consecutivo = getConcesionario().getConsecutivoCompras();
						Compra compra = new Compra(total, vehiculo, empleadoTransaccion, clienteTransaccion, fecha, consecutivo);
						getConcesionario().listaTransacciones.add(compra);
						empleadoTransaccion.listaTransacciones.add(compra);
						clienteTransaccion.listaTransacciones.add(compra);
						vehiculo.cambiarDisponibilidadVehiculoPorTransaccion();
						mensaje = "Transaccion realizada correctamente - Compra de Vehiculo";
						getConcesionario().añadirCompraConsecutivo();
					}
					else {
						throw new TransaccionException("El cliente de la transaccion no se encuentra registrado");
					}
				}
				else {
					throw new TransaccionException("El empleado de la transaccion no se encuentra registrado");
				}
			}
			else {
				throw new TransaccionException("El vehiculo ya se compró");
			}
		}
		else {
			throw new TransaccionException("El vehiculo a comprar no se encuentra registrado");
		}
		return mensaje;
	}
	
	/**
	 * Metodo para alquilar un Vehiculo
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 * @param fechaTransaccion
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return
	 * @throws TransaccionException
	 */
	public String AlquilarVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fechaTransaccion, String fechaInicio, String fechaFinal) throws TransaccionException {
		String mensaje;
		if(vehiculo != null) {
			if(vehiculo.getDisponibleTransaccion() == true) {
				if(vehiculo.getAlquilado() == false) {
					if(empleadoTransaccion != null) {
						if(clienteTransaccion != null) {
							Integer consecutivo = getConcesionario().getConsecutivoAlquileres();
							Alquiler alquiler = new Alquiler(total, vehiculo, empleadoTransaccion, clienteTransaccion, fechaTransaccion, fechaInicio, fechaFinal, consecutivo);
							getConcesionario().listaTransacciones.add(alquiler);
							empleadoTransaccion.listaTransacciones.add(alquiler);
							clienteTransaccion.listaTransacciones.add(alquiler);
							mensaje = "Transaccion realizada correctamente - Alquiler de Vehiculo";
							vehiculo.cambiarEstadoAlquilerVehiculo();
							getConcesionario().añadirAlquilerConsecutivo();
						}
						else {
							throw new TransaccionException("El cliente de la transaccion no se encuentra registrado");
						}
					}
					else {
						throw new TransaccionException("El empleado de la transaccion no se encuentra registrado");
					}
				}
				else {
					throw new TransaccionException("El vehiculo se encuentra alquilado");
				}
			}
			else {
				throw new TransaccionException("El vehiculo no se ha comprado");
			}
		}
		else {
			throw new TransaccionException("El vehiculo a alquiler no se encuentra registrado");
		}
		return mensaje;
	}
	
	/**
	 * Metodo para obtener un alquiler por su consecutivo de alquiler
	 * @param consecutivoAlquiler
	 * @return
	 */
	public Alquiler obtenerAlquiler(int consecutivoAlquiler) {
		Alquiler alquiler = null;
		Alquiler alquilerAux = null;
		for(Transaccion transaccion : getConcesionario().getListaTransacciones()) {
			if(transaccion instanceof Alquiler) {
				alquilerAux = (Alquiler) transaccion;
				if(alquilerAux.getConsecutivoAlquiler() == consecutivoAlquiler) {
					alquiler = alquilerAux;
				}
			}
		}
		return alquiler;
	}
	
	/**
	 * Metodo para cambiar el estado de alquiler de un vehiculo en la transaccion tipo alquiler
	 * @param consecutivoAlquiler
	 * @return
	 * @throws TransaccionException
	 */
	public String devolverVehiculoAlquiler(int consecutivoAlquiler) throws TransaccionException {
		String mensaje;
		Alquiler alquiler = obtenerAlquiler(consecutivoAlquiler);
		if(alquiler != null) {
			if(alquiler.getVehiculo().getAlquilado() == true) {
				alquiler.getVehiculo().cambiarEstadoAlquilerVehiculo();
				mensaje = "El vehiculo se devolvió exitosamente";
			}
			else {
				mensaje = "El vehiculo no se encuentra alquilado";
			}
		}
		else {
			throw new TransaccionException("El alquiler no se encuentra registrado");
		}
		return mensaje;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Funciones de Reporte
	
	/**
	 * Metodo para obtener las transacciones del empleado que invoca el metodo
	 * @return
	 */
	public List<Transaccion> obtenerResgitroTransaccionesEmpleado(){
		return getListaTransacciones();
	}
	
	/**
	 * Metodo para obtener las transacciones de un empleado enviado como parametro
	 * @param identificacion
	 * @return
	 * @throws ClienteNoRegistradoException
	 */
	public List<Transaccion> obtenerResgitroTransaccionesDeUnEmpleado(String identificacion) throws ClienteNoRegistradoException{
		Empleado empleado = getConcesionario().obtenerEmpleado(identificacion);
		if(empleado != null) {
			return empleado.getListaTransacciones();
		}
		else {
			throw new ClienteNoRegistradoException();
		}
	}
}
