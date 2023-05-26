package co.edu.uniquindio.concesionario.model.interfaces;

import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoAlquiladoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoCompradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoCompradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoPasaRevisionException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.Vehiculo;

public interface RealizarTransaccion {

	public String venderVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha) throws ClienteNoRegistradoException, EmpleadoNoRegistradoException, VehiculoAlquiladoException, VehiculoNoCompradoException, VehiculoNoRegistradoException;
	
	public String comprarVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fecha, String pasaRevision) throws VehiculoNoPasaRevisionException, ClienteNoRegistradoException, EmpleadoNoRegistradoException, VehiculoCompradoException, VehiculoNoRegistradoException ;
	
	public String AlquilarVehiculo(Double total, Vehiculo vehiculo, Empleado empleadoTransaccion, Cliente clienteTransaccion,
			String fechaTransaccion, String fechaInicio, String fechaFinal) throws ClienteNoRegistradoException, EmpleadoNoRegistradoException, VehiculoAlquiladoException, VehiculoNoCompradoException, VehiculoNoRegistradoException;
	
}
