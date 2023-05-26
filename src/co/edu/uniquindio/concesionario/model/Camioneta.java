package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class Camioneta extends Vehiculo {

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Camioneta
	private boolean sensorColision;
	private boolean sensorTraficoCruzado;
	private boolean permanenciaCarril;
	private boolean is4x4;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * constructor vacio de la clase Camioneta
	 */
	public Camioneta() {
		
	}
	/**
	 * Metodo Constructor de la clase Camioneta
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
	 * @param abs
	 * @param categoriaVehiculo
	 */
	public Camioneta(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
			Double cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean sensorColision, boolean sensorTraficoCruzado,
			boolean permanenciaCarril, boolean is4x4) {
		super(listaImagenes, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
		
		this.sensorColision = sensorColision;
		this.sensorTraficoCruzado = sensorTraficoCruzado;
		this.permanenciaCarril = permanenciaCarril;
		this.is4x4 = is4x4;

	}

	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores para pruebas unitarias de la clase camioneta
	
	/**
	 * Metodo contructor para pruebas unitarias 1 de la clase Camioneta
	 * @param disponibleTransaccion, estadoAlquiler
	 */
	public Camioneta(Boolean disponibleTransaccion, Boolean estadoAlquiler) {
		super(disponibleTransaccion, estadoAlquiler);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Camioneta
	 */
	@Override
	public String toString() {
		return "Camioneta [sensorColision=" + sensorColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado
				+ ", permanenciaCarril=" + permanenciaCarril + ", is4x4=" + is4x4 + "]";
	}
	
	/**
	 * setters & getters de la clase Camioneta
	 * @return
	 */
	public boolean isSensorColision() {
		return sensorColision;
	}
	public void setSensorColision(boolean sensorColision) {
		this.sensorColision = sensorColision;
	}
	public boolean isSensorTraficoCruzado() {
		return sensorTraficoCruzado;
	}
	public void setSensorTraficoCruzado(boolean sensorTraficoCruzado) {
		this.sensorTraficoCruzado = sensorTraficoCruzado;
	}
	public boolean isPermanenciaCarril() {
		return permanenciaCarril;
	}
	public void setPermanenciaCarril(boolean permanenciaCarril) {
		this.permanenciaCarril = permanenciaCarril;
	}
	public boolean isIs4x4() {
		return is4x4;
	}
	public void setIs4x4(boolean is4x4) {
		this.is4x4 = is4x4;
	}
	
}
