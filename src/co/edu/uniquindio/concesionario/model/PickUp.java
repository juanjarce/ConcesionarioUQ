package co.edu.uniquindio.concesionario.model;

public class PickUp extends Vehiculo{
	
	private boolean is4x4;
	private Double capacidadCajaDeCargas;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Constructor vacio de la clase PickUp
	 */
	public PickUp() {
		
	}
	/**
	 * metodo contructor de la clase PickUp
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
	public PickUp(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean is4x4, Double capacidadCajaDeCargas) {
		super(direccionImagen, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
		
		this.is4x4 = is4x4;
		this.capacidadCajaDeCargas = capacidadCajaDeCargas;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase PickUp
	 */
	@Override
	public String toString() {
		return "PickUp [is4x4=" + is4x4 + ", capacidadCajaDeCargas=" + capacidadCajaDeCargas + "]";
	}
	
	/**
	 * getters & setters de la clase PickUp
	 * @return
	 */
	public boolean isIs4x4() {
		return is4x4;
	}
	public void setIs4x4(boolean is4x4) {
		this.is4x4 = is4x4;
	}
	public Double getCapacidadCajaDeCargas() {
		return capacidadCajaDeCargas;
	}
	public void setCapacidadCajaDeCargas(Double capacidadCajaDeCargas) {
		this.capacidadCajaDeCargas = capacidadCajaDeCargas;
	}

}
