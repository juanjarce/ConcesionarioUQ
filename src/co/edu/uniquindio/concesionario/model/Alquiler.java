package co.edu.uniquindio.concesionario.model;

public class Alquiler extends Transaccion{

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Alquiler
	private Integer consecutivoAlquiler;
	private String fechaInicio;
	private String fechaFinal;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Constructor vacio de la clase Alquiler
	 **/
	public Alquiler() {
		
	}
	/**
	 * Metodo constructor de la clase Alquiler
	 * @param total
	 * @param vehiculo
	 * @param empleadoTransaccion
	 * @param clienteTransaccion
	 * @param fecha
	 * @param fechaInicio
	 * @param fechaFinal
	 */
	public Alquiler(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha, String fechaInicio, String fechaFinal, int consecutivoAlquiler) {
		super(total, vehiculo, empleadoTransaccion, clienteTransaccion, fecha);
		// TODO Auto-generated constructor stub
		
		this.consecutivoAlquiler = consecutivoAlquiler;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos para pruebas unitarias

	/**
	 * Metodo constructor para pruebas unitarias 1 de la clase alquiler
	 * @param fecha
	 */
	public Alquiler(String fecha) {
		super(fecha);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Alquiler
	 */
	@Override
	public String toString() {
		return "Alquiler [fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + "]";
	}
	
	/**
	 * getters() & setters() de la clase Alquiler
	 * @return
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Integer getConsecutivoAlquiler() {
		return consecutivoAlquiler;
	}
	public void setConsecutivoAlquiler(Integer consecutivoAlquiler) {
		this.consecutivoAlquiler = consecutivoAlquiler;
	}

}
