package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class Sedan extends Vehiculo{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Sedan
	private boolean sensorColision;
	private boolean sensorTraficoCruzado;
	private boolean permanenciaCarril;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * metodo constructor vacio de la clase Sedan
	 */
	public Sedan() {
		
	}
	/**
	 * Metodo constructor de la clase Sedan
	 */
	public Sedan(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
			Double cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean sensorColision, boolean sensorTraficoCruzado,
			boolean permanenciaCarril) {
		super(listaImagenes, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
		
		this.sensorColision = sensorColision;
		this.sensorTraficoCruzado = sensorTraficoCruzado;
		this.permanenciaCarril = permanenciaCarril;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Sedan
	 */
	@Override
	public String toString() {
		return "Sedan [sensorColision=" + sensorColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado
				+ ", permanenciaCarril=" + permanenciaCarril + "]";
	}
	
	/**
	 * getters & setters de la clase Sedan
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
	
}
