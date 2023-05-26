package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class PickUp extends Vehiculo{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase PickUp
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
	public PickUp(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
			Double cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, boolean is4x4, Double capacidadCajaDeCargas) {
		super(listaImagenes, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
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
