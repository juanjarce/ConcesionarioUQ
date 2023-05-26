package co.edu.uniquindio.concesionario.exceptions;

public class VehiculoNoPasaRevisionException extends Exception{
	public VehiculoNoPasaRevisionException() {
		super("El vehiculo no pasó la revisión");
	}
}
