package co.edu.uniquindio.concesionario.model;

import co.edu.uniquindio.concesionario.exceptions.TransaccionException;

public interface RealizarTransaccion {

	public String venderVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha) throws TransaccionException;
	
	public String comprarVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha, String pasaRevision) throws TransaccionException;
	
	public String AlquilarVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fechaTransaccion, String fechaInicio, String fechaFinal) throws TransaccionException;
	
}
