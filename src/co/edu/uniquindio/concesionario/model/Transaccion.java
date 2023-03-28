package co.edu.uniquindio.concesionario.model;

public abstract class Transaccion {

	private Double total;
	private Vehiculo vehiculo;
	private Empleado empleadoTransaccion;
	private Cliente clienteTransaccion;
	private String fecha;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo contructor vacio de la clase Transaccion
	 */
	public Transaccion(){
		
	}
	/**
	 * Metodo constructor de la clase Transaccion
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 */
	public Transaccion(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion, String fecha) {
		super();
		this.total = total;
		this.vehiculo = vehiculo;
		this.empleadoTransaccion = empleadoTransaccion;
		this.clienteTransaccion = clienteTransaccion;
		this.fecha = fecha;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias de la clase Transaccion

	/**
	 * metodo constructo para pruebas unitarias 1
	 * @param fecha
	 */
	public Transaccion(String fecha) {
		this.fecha = fecha;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Transaccion
	 */
	@Override
	public String toString() {
		return "Transaccion [total=" + total + ", vehiculo=" + vehiculo + ", empleadoTransaccion=" + empleadoTransaccion
				+ ", clienteTransaccion=" + clienteTransaccion + ", fecha=" + fecha + "]";
	}

	/**
	 * getters() & setters() clase Transaccion
	 * @return
	 */
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Empleado getEmpleadoTransaccion() {
		return empleadoTransaccion;
	}
	public void setEmpleadoTransaccion(Empleado empleadoTransaccion) {
		this.empleadoTransaccion = empleadoTransaccion;
	}
	public Cliente getClienteTransaccion() {
		return clienteTransaccion;
	}
	public void setClienteTransaccion(Cliente clienteTransaccion) {
		this.clienteTransaccion = clienteTransaccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
