package co.edu.uniquindio.concesionario.exceptions;

public class VehiculoRegistradoException extends Exception{
	public VehiculoRegistradoException() {
		super("El vehiculo ya se encuentra registrado");
	}
}
