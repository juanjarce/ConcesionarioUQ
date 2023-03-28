package co.edu.uniquindio.concesionario.model;

import java.util.Objects;

public abstract class Vehiculo {

	private String direccionImagen;
	private Boolean disponibleTransaccion;
	private Boolean alquilado;
	private String codigo;
	private String marca;
	private String condicion;
	private Integer modelo;
	private String transmicion;
	private String velocidadMaxima;
	private String cilindraje;
	private Integer numeroPasajeros;
	private Integer numeroPuertas;
	private Double capacidadMaletero;
	private boolean aireAcondicionado;
	private boolean camaraReversa;
	private boolean velocidadCrucero;
	private Integer numeroBolsasDeAire;
	private boolean ABS;
	private TipoVehiculo tipoVehiculo;
	private CategoriaVehiculo categoriaVehiculo;
	private Integer electrico_autonomia;
	private Integer electrico_tiempoCarga;
	private boolean hibrido_isEnchufable;
	private String tipoHibrido;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores definidos de la clase

	/**
	 * Constructor vacio de la clase Vehiculo
	 */
	public Vehiculo() {
		
	}
	/**
	 * Constructor de la clase Vehiculo
	 */
	public Vehiculo(String direccionImagen, String codigo, String marca, String condicion, Integer modelo, String transmicion, String velocidadMaxima,
			String cilindraje, Integer numeroPasajeros, Integer numeroPuertas, Double capacidadMaletero,
			boolean aireAcondicionado, boolean camaraReversa, boolean velocidadCrucero, Integer numeroBolsasDeAire,
			boolean aBS, TipoVehiculo tipoVehiculo, CategoriaVehiculo categoriaVehiculo, Integer electrico_autonomia,
			Integer electrico_tiempoCarga, boolean hibrido_isEnchufable, String tipoHibrido) {
		super();
		this.direccionImagen = direccionImagen;
		this.disponibleTransaccion = false;
		this.alquilado = false;
    	this.codigo = codigo;
    	this.marca = marca;
  		this.condicion = condicion;
  		this.modelo = modelo;
  		this.transmicion = transmicion;
  		this.velocidadMaxima = velocidadMaxima;
  		this.cilindraje = cilindraje;
  		this.numeroPasajeros = numeroPasajeros;
  		this.numeroPuertas = numeroPuertas;
  		this.capacidadMaletero = capacidadMaletero;
  		this.aireAcondicionado = aireAcondicionado;
  		this.camaraReversa = camaraReversa;
  		this.velocidadCrucero = velocidadCrucero;
  		this.numeroBolsasDeAire = numeroBolsasDeAire;
  		ABS = aBS;
  		this.tipoVehiculo = tipoVehiculo;
  		this.categoriaVehiculo = categoriaVehiculo;
  		this.electrico_autonomia = electrico_autonomia;
  		this.electrico_tiempoCarga = electrico_tiempoCarga;
  		this.hibrido_isEnchufable = hibrido_isEnchufable;
  		this.tipoHibrido = tipoHibrido;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo toString de la clase Vehiculo
	 */
	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", marca=" + marca + ", condicion=" + condicion + ", modelo=" + modelo
				+ ", transmicion=" + transmicion + ", velocidadMaxima=" + velocidadMaxima + ", cilindraje=" + cilindraje
				+ ", numeroPasajeros=" + numeroPasajeros + ", numeroPuertas=" + numeroPuertas + ", capacidadMaletero="
				+ capacidadMaletero + ", aireAcondicionado=" + aireAcondicionado + ", camaraReversa=" + camaraReversa
				+ ", velocidadCrucero=" + velocidadCrucero + ", numeroBolsasDeAire=" + numeroBolsasDeAire + ", ABS="
				+ ABS + ", tipoVehiculo=" + tipoVehiculo + ", categoriaVehiculo=" + categoriaVehiculo
				+ ", electrico_autonomia=" + electrico_autonomia + ", electrico_tiempoCarga=" + electrico_tiempoCarga
				+ ", hibrido_isEnchufable=" + hibrido_isEnchufable + ", tipoHibrido=" + tipoHibrido + "]";
	}

	/**
	 * setters & getters de la clase Vehiculo
	 * @return
	 */
	public String getDireccionImagen() {
		return direccionImagen;
	}
	public void setDireccionImagen(String direccionImagen) {
		this.direccionImagen = direccionImagen;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public String getTransmicion() {
		return transmicion;
	}
	public void setTransmicion(String transmicion) {
		this.transmicion = transmicion;
	}
	public String getVelocidadMaxima() {
		return velocidadMaxima;
	}
	public void setVelocidadMaxima(String velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public Integer getNumeroPasajeros() {
		return numeroPasajeros;
	}
	public void setNumeroPasajeros(Integer numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}
	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}
	public void setNumeroPuertas(Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}
	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}
	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}
	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}
	public boolean isCamaraReversa() {
		return camaraReversa;
	}
	public void setCamaraReversa(boolean camaraReversa) {
		this.camaraReversa = camaraReversa;
	}
	public boolean isVelocidadCrucero() {
		return velocidadCrucero;
	}
	public void setVelocidadCrucero(boolean velocidadCrucero) {
		this.velocidadCrucero = velocidadCrucero;
	}
	public Integer getNumeroBolsasDeAire() {
		return numeroBolsasDeAire;
	}
	public void setNumeroBolsasDeAire(Integer numeroBolsasDeAire) {
		this.numeroBolsasDeAire = numeroBolsasDeAire;
	}
	public boolean isABS() {
		return ABS;
	}
	public void setABS(boolean aBS) {
		ABS = aBS;
	}
	public CategoriaVehiculo getCategoriaVehiculo() {
		return categoriaVehiculo;
	}
	public void setCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo) {
		this.categoriaVehiculo = categoriaVehiculo;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public Integer getElectrico_autonomia() {
		return electrico_autonomia;
	}
	public void setElectrico_autonomia(Integer electrico_autonomia) {
		this.electrico_autonomia = electrico_autonomia;
	}
	public Integer getElectrico_tiempoCarga() {
		return electrico_tiempoCarga;
	}
	public void setElectrico_tiempoCarga(Integer electrico_tiempoCarga) {
		this.electrico_tiempoCarga = electrico_tiempoCarga;
	}
	public boolean isHibrido_isEnchufable() {
		return hibrido_isEnchufable;
	}
	public void setHibrido_isEnchufable(boolean hibrido_isEnchufable) {
		this.hibrido_isEnchufable = hibrido_isEnchufable;
	}
	public String getTipoHibrido() {
		return tipoHibrido;
	}
	public void setTipoHibrido(String tipoHibrido) {
		this.tipoHibrido = tipoHibrido;
	}
	public Boolean getDisponibleTransaccion() {
		return disponibleTransaccion;
	}
	public void setDisponibleTransaccion(Boolean disponibleTransaccion) {
		this.disponibleTransaccion = disponibleTransaccion;
	}
	public Boolean getAlquilado() {
		return alquilado;
	}
	public void setAlquilado(Boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	/**
	 * Metodos hashCode() y .equals()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	/**
	 * metodo para cmabiar la disponibilidad de un vehiculo despues de una transaccion
	 */
	public void cambiarDisponibilidadVehiculoPorTransaccion() {
		if(getDisponibleTransaccion() == false) {
			setDisponibleTransaccion(true);
		}
		else {
			setDisponibleTransaccion(false);
		}
	}
	
	/**
	 * Metodo para cambiar el estado de alquiler de un vehiculo despues de realizar una transaccion de tipo alquiler
	 */
	public void cambiarEstadoAlquilerVehiculo() {
		if(getAlquilado() == false) {
			setAlquilado(true);
		}
		else {
			setAlquilado(false);
		}
	}
	
}
