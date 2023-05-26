package co.edu.uniquindio.concesionario.model;

import java.util.ArrayList;

public class Deportivo extends Vehiculo{

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase Deportivo
	private Double numeroCaballosDeFuerza;
	private Integer segundosAlcanza100;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Metodo constructor vacio de la clase Deportivo
	 */
	public Deportivo() {
		
	}
	/**
	 * Metodo constructor de la clase Deportivo
	 */
	public Deportivo(ArrayList<String> listaImagenes, String codigo, String marca, String condicion, Integer modelo, String transmicion, Double velocidadMaxima,
			Double cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido, Double numeroCaballosDeFuerza, Integer segundosAlcanza100) {
		super(listaImagenes, codigo, marca, condicion, modelo, transmicion, velocidadMaxima, cilindraje, numeroPasajeros, numeroPuertas,
				capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasDeAire, aBS, tipoVehiculo,
				categoriaVehiculo, electrico_autonomia, electrico_tiempoCarga, hibrido_isEnchufable, tipoHibrido);
		// TODO Auto-generated constructor stub
		
		this.numeroCaballosDeFuerza = numeroCaballosDeFuerza;
		this.segundosAlcanza100 = segundosAlcanza100;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * toString de la clase Deportivo
	 */
	@Override
	public String toString() {
		return "Deportivo [numeroCaballosDeFuerza=" + numeroCaballosDeFuerza + ", segundosAlcanza100="
				+ segundosAlcanza100 + "]";
	}
	
	/**
	 * getters & setters de la clase Deportivo
	 * @return
	 */
	public Double getNumeroCaballosDeFuerza() {
		return numeroCaballosDeFuerza;
	}
	public void setNumeroCaballosDeFuerza(Double numeroCaballosDeFuerza) {
		this.numeroCaballosDeFuerza = numeroCaballosDeFuerza;
	}
	public Integer getSegundosAlcanza100() {
		return segundosAlcanza100;
	}
	public void setSegundosAlcanza100(Integer segundosAlcanza100) {
		this.segundosAlcanza100 = segundosAlcanza100;
	}
	
}
