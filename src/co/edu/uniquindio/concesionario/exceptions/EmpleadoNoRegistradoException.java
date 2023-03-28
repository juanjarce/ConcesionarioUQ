package co.edu.uniquindio.concesionario.exceptions;

public class EmpleadoNoRegistradoException extends Exception{
	public EmpleadoNoRegistradoException() {
		super("El empleado no se encuentra registrado");
	}
}
