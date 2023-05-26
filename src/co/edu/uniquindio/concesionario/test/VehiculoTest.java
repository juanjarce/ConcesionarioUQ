package co.edu.uniquindio.concesionario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.concesionario.model.Camioneta;
import co.edu.uniquindio.concesionario.model.Vehiculo;

class VehiculoTest {

	/**
	 * Prueba para verificar el metodo de cambiar la disponibilidad de un vehiculo para transaccion en la clase Vehiculo
	 */
	@Test
	void testCambiarDisponibilidadVehiculoPorTransaccion() {
		
		Vehiculo vehiculo = new Camioneta(false, false);
		vehiculo.cambiarDisponibilidadVehiculoPorTransaccion();
		
		assertTrue(vehiculo.getDisponibleTransaccion());
		
	}

	/**
	 * Prueba para verificar el metodo de cambiar el estado de alquiler de un vehiculo en la clase
	 */
	@Test
	void testCambiarEstadoAlquilerVehiculo() {
		
		Vehiculo vehiculo = new Camioneta(false, false);
		vehiculo.cambiarEstadoAlquilerVehiculo();
		
		assertTrue(vehiculo.getAlquilado());
		
	}

}
