package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class Van extends Vehiculo{
	
	private static final long serialVersionUID = 1L;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de la clase Van
	 */
	public Van() {
		
	}
	/**
	 * Metodo constructor de la clase Van
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
	public Van(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
			Double cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido) {
		super(listaImagenes, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------

}
