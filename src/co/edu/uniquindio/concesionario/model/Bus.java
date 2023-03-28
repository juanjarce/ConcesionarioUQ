package co.edu.uniquindio.concesionario.model;

public class Bus extends Vehiculo{
	
	
	private Integer numeroEjes;
	private Integer numeroSalidasEmergencia;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de la clase Bus
	 */
	public Bus() {
		
	}
	/**
	 * metodo contructor de la clase Bus
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
	public Bus(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, Integer numeroEjes, Integer numeroSalidasEmergencia) {
		super(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
		
		this.numeroEjes = numeroEjes;
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * toString de la clase Bus
	 */
	@Override
	public String toString() {
		return "Bus [numeroEjes=" + numeroEjes + ", numeroSalidasEmergencia=" + numeroSalidasEmergencia + "]";
	}

	/**
	 * getters & setters de la clase Bus
	 * @return
	 */
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

}
