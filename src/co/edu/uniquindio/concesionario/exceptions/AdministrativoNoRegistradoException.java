package co.edu.uniquindio.concesionario.exceptions;

public class AdministrativoNoRegistradoException extends Exception{
	public AdministrativoNoRegistradoException() {
		super("El administrativo no existe");
	}
}
