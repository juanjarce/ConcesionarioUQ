package co.edu.uniquindio.concesionario.model;

public class Compra extends Transaccion{

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Compra
	private Integer consecutivoCompra;

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de la clase Compra
	 */
	public Compra() {
		
	}
	/**
	 * Metodo constructor de la clase Compra
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 * @param fecha
	 * @param consecutivo
	 */
	public Compra(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha, int consecutivoCompra) {
		super(total, vehiculo, empleadoTransaccion, clienteTransaccion, fecha);
		// TODO Auto-generated constructor stub
		
		this.consecutivoCompra = consecutivoCompra;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias

	/**
	 * Metodo constructor para pruebas unitarias 1 de la clase compra
	 * @param fecha
	 */
	public Compra(String fecha) {
		super(fecha);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Compra
	 */
	@Override
	public String toString() {
		return "Compra [consecutivoCompra=" + consecutivoCompra + "]";
	}

	/**
	 * getters() & setters() de la clase Compra
	 * @return
	 */
	public Integer getConsecutivoCompra() {
		return consecutivoCompra;
	}
	public void setConsecutivoCompra(Integer consecutivoCompra) {
		this.consecutivoCompra = consecutivoCompra;
	}
	
}
