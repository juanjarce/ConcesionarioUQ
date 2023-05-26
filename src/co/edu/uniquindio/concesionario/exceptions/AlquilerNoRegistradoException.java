package co.edu.uniquindio.concesionario.exceptions;

public class AlquilerNoRegistradoException extends Exception{
	public AlquilerNoRegistradoException() {
		super("El alquiler no se encuentra registrado");
	}
}
