package co.edu.uniquindio.concesionario.exceptions;

public class VehiculoNoRegistradoException extends Exception{
	public VehiculoNoRegistradoException() {
		super("El vehiculo no se encuentra registrado");
	}
}
