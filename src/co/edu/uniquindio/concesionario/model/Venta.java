package co.edu.uniquindio.concesionario.model;

public class Venta extends Transaccion {
	
	private Integer consecutivoVenta;

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de la clase Venta
	 */
	public Venta() {
		
	}
	/**
	 * Metodo constructor de la clase Venta
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 * @param fecha
	 * @param consecutivo
	 */
	public Venta(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha, int consecutivoVenta) {
		super(total, vehiculo, empleadoTransaccion, clienteTransaccion, fecha);
		// TODO Auto-generated constructor stub
		
		this.consecutivoVenta = consecutivoVenta;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias de la clase Venta

	/**
	 * Metodo constructor para pruebas unitarias 1 de la clase Venta
	 * @param fecha
	 */
	public Venta(String fecha) {
		super(fecha);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Venta
	 */
	@Override
	public String toString() {
		return "Venta [consecutivoVenta=" + consecutivoVenta + "]";
	}
	
	/**
	 * getters() & setters() de la clase Venta
	 * @return
	 */
	public Integer getConsecutivoVenta() {
		return consecutivoVenta;
	}
	public void setConsecutivoVenta(Integer consecutivoVenta) {
		this.consecutivoVenta = consecutivoVenta;
	}
	
}
