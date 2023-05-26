package co.edu.uniquindio.concesionario.exceptions;

public class VehiculoCompradoException extends Exception{
	public VehiculoCompradoException() {
		super("El vehiculo ya se compró");
	}
}
