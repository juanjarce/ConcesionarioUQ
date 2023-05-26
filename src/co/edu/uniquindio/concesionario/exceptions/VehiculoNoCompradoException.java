package co.edu.uniquindio.concesionario.exceptions;

public class VehiculoNoCompradoException extends Exception{
	public VehiculoNoCompradoException() {
		super("El vehiculo no se ha comprado");
	}
}
