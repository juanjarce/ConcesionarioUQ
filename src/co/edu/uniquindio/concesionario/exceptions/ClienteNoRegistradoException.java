package co.edu.uniquindio.concesionario.exceptions;

public class ClienteNoRegistradoException extends Exception{
	public ClienteNoRegistradoException() {
		super("El cliente no se encuentra registrado");
	}
}
