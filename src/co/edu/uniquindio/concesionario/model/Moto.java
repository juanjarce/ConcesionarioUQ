package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class Moto extends Vehiculo{

	private static final long serialVersionUID = 1L;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo vacio de la clase Moto
	 */
	public Moto() {
		
	}
	/**
	 * Metodo contrsuctor de la clase Moto
	 */
	public Moto(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
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
