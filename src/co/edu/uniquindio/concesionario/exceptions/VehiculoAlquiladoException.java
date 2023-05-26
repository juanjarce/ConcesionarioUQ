package co.edu.uniquindio.concesionario.exceptions;

public class VehiculoAlquiladoException extends Exception{
	public VehiculoAlquiladoException() {
		super("El vehiculo se encuentra alquilado");
	}
}
