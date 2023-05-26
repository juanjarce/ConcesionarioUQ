package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class Camion extends Vehiculo{

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Camion
	private Double capacidadCarga;
	private Integer numeroEjes;
	private Integer numeroSalidasEmergencia;
	private Boolean frenosAire;
	private TipoCamion tipoCamion;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * metodo constructor vacio de la clase Camion
	 */
	public Camion() {
		
	}
	/**
	 * Metodo contructor de la clase Camion
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
	public Camion(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
			Double cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, Double capacidadCarga, Integer numeroEjes, Integer numeroSalidasEmergencia,
			boolean frenosAire, TipoCamion tipoCamion) {
		super(listaImagenes, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
		
		this.capacidadCarga = capacidadCarga;
		this.numeroEjes = numeroEjes;
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
		this.frenosAire = frenosAire;
		this.tipoCamion = tipoCamion;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Camion
	 */
	@Override
	public String toString() {
		return "Camion [capacidadCarga=" + capacidadCarga + ", numeroEjes=" + numeroEjes + ", numeroSalidasEmergencia="
				+ numeroSalidasEmergencia + "]";
	}
	
	/**
	 * getters & setters de la clase Camion
	 * @return
	 */
	public Double getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(Double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	public Integer getNumeroEjes() {
		return numeroEjes;
	}
	public void setNumeroEjes(Integer numeroEjes) {
		this.numeroEjes = numeroEjes;
	}
	public Integer getNumeroSalidasEmergencia() {
		return numeroSalidasEmergencia;
	}
	public void setNumeroSalidasEmergencia(Integer numeroSalidasEmergencia) {
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}
	public Boolean getFrenosAire() {
		return frenosAire;
	}
	public void setFrenosAire(Boolean frenosAire) {
		this.frenosAire = frenosAire;
	}
	public TipoCamion getTipoCamion() {
		return tipoCamion;
	}
	public void setTipoCamion(TipoCamion tipoCamion) {
		this.tipoCamion = tipoCamion;
	}

}
