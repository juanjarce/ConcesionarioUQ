package co.edu.uniquindio.concesionario.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.concesionario.exceptions.AlquilerNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.ContraseniaException;
import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.exceptions.CrearClienteException;
import co.edu.uniquindio.concesionario.exceptions.CrearEmpleadoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoAlquiladoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoCompradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoCompradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoPasaRevisionException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoRegistradoException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Cargo;
import co.edu.uniquindio.concesionario.model.CategoriaVehiculo;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.TipoCamion;
import co.edu.uniquindio.concesionario.model.TipoVehiculo;
import co.edu.uniquindio.concesionario.model.Transaccion;

class EmpleadoTest {

	/**
	 * Prueba para verificar el metodo que cambia la contraseña de un empleado en el sistema
	 */
	@Test
	void testCambiarContraseñaEmpleado() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "La contraseña fue modificada exitosamente";
		String resultadoActual = "";
		try {
			resultadoActual = empleadoConcesionarioTest1.cambiarContraseñaEmpleado("1082", "contrasenia", "11.11.11");
		} catch (ContraseniaException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el funcionamiento del metodo de obtener un cliente en la clase Empleado
	 */
	@Test
	void testObtenerCliente() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");

		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}
		
		String infoCliente = "Juan"+"Lopez"+"1092";
		Cliente cliente = empleadoConcesionarioTest1.obtenerCliente("1092");
		
		assertEquals(infoCliente, cliente.getNombres()+cliente.getApellidos()+cliente.getIdentificacion());
		
	}

	/**
	 * Prueba para verificar el metodo de crear un cliente en la clase Empleado
	 */
	@Test
	void testCrearCliente() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");

		String resultadoEsperado = "El cliente fue creado exitosamente";
		String resultadoActual = "";
		try {
			resultadoActual = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(resultadoActual);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de modificar la informacion de un cliente en la clase Empleado
	 */
	@Test
	void testModificarCliente() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");

		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}
		
		String resultadoEsperado = "El cliente fue modificado exitosamente";
		String resultadoActual = "";
		try {
			resultadoActual = empleadoConcesionarioTest1.modificarCliente("Esteban", "Gomez", "1092");
		} catch (ClienteNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de eliminar un cliente en la clase Empleado
	 */
	@Test
	void testEliminarCliente() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");

		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}
		
		String resultadoEsperado = "El cliente fue eliminado exitosamente";
		String resultadoActual = "";
		try {
			resultadoActual = empleadoConcesionarioTest1.eliminarCliente("1092");
		} catch (ClienteNoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de obtener un vehiculo por el codigo en la clase Empleado
	 */
	@Test
	void testObtenerVehiculo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			empleadoConcesionarioTest1.crearVan(imagenesVehiculo, "1", "marca", "USADO", 2015, "MANUAL", 450.0, 2500.0, 5, 5, 650.5, true, true, false, 5, true, TipoVehiculo.GASOLINA, CategoriaVehiculo.VAN, 0, 0, false, "NO APLICA");
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		String resultadoEsperadoCodigo = "1";
		String resultadoActualCodigo = empleadoConcesionarioTest1.obtenerVehiculo("1").getCodigo();
		
		assertEquals(resultadoEsperadoCodigo, resultadoActualCodigo);
		
	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo moto en la clase Empleado
	 */
	@Test
	void testCrearMoto() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearMoto(imagenesVehiculo, "2", "marca", "NUEVO", 2015, "AUTOMATICA", 450.0, 2500.0, 2, 0, 15.5, false, true, false, 5, true, TipoVehiculo.ELECTRICO, CategoriaVehiculo.MOTO, 2000, 7, false, "NO APLICA");
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo sedan en la clase Empleado
	 */
	@Test
	void testCrearSedan() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearSedan(imagenesVehiculo, "3", "marca", "NUEVO", 2020, "AUTOMATICA", 380.0, 2400.0, 5, 5, 350.0, true, true, true, 5, true, TipoVehiculo.HIBRIDO, CategoriaVehiculo.SEDAN, 0, 0, true, "LIGERO", true, true, true);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo deportivo en la clase Empleado
	 */
	@Test
	void testCrearDeportivo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearDeportivo(imagenesVehiculo, "4", "marca", "NUEVO", 2020, "AUTOMATICA", 380.0, 2400.0, 5, 5, 350.0, true, true, true, 5, true, TipoVehiculo.ELECTRICO, CategoriaVehiculo.DEPORTIVO, 2000, 5, false, "NO APLICA", 2500.0, 5);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo camioneta en la clase Empleado
	 */
	@Test
	void testCrearCamioneta() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearCamioneta(imagenesVehiculo, "5", "marca", "NUEVO", 2015, "AUTOMATICA", 380.0, 2400.0, 5, 5, 350.0, true, true, true, 5, true, TipoVehiculo.GASOLINA, CategoriaVehiculo.CAMIONETA, 0, 0, false, "NO APLICA", true, true, false, false);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo PickUp en la clase Empleado
	 */
	@Test
	void testCrearPickUp() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearPickUp(imagenesVehiculo, "6", "marca", "NUEVO", 2015, "AUTOMATICA", 380.0, 2400.0, 5, 5, 350.0, true, true, true, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.PICKUP, 0, 0, false, "NO APLICA", true, 1200.5);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo Van en la clase Empleado
	 */
	@Test
	void testCrearVan() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearVan(imagenesVehiculo, "1", "marca", "USADO", 2015, "MANUAL", 450.0, 2500.0, 5, 5, 650.5, true, true, false, 5, true, TipoVehiculo.GASOLINA, CategoriaVehiculo.VAN, 0, 0, false, "NO APLICA");
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo Bus en la clase Empleado
	 */
	@Test
	void testCrearBus() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearBus(imagenesVehiculo, "7", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 4, 2);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 * Prueba para el metodo de crear un vehiculo de tipo Camion en la clase Empleado
	 */
	@Test
	void testCrearCamion() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		String resultadoEsperado = "El vehiculo fue creado exitosamente";
		String resultadoActual = "";
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			resultadoActual = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 *Prueba para verificar el metodo de eliminar un vehiculo por su codigo en la clase Empleado
	 */
	@Test
	void testEliminarVehiculo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		String resultadoEsperado = "El vehiculo fue eliminado exitosamente";
		String resultadoActual = "";
		
		try {
			resultadoActual = empleadoConcesionarioTest1.eliminarVehiculo("8");
		} catch (VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de vender un vehiculo en la clase Empleado
	 */
	@Test
	void testVenderVehiculo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se compra el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.comprarVehiculo(90000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "SI");
			System.out.println(mensaje);
		} catch (VehiculoNoPasaRevisionException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
				| VehiculoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se Vende el vehiculo
		String resultadoEsperado = "Transaccion realizada correctamente - Venta de Vehiculo";
		String resultadoActual="";
		try {
			resultadoActual = empleadoConcesionarioTest1.venderVehiculo(110000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023");
		} catch (ClienteNoRegistradoException | EmpleadoNoRegistradoException | VehiculoAlquiladoException
				| VehiculoNoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}

		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de comprar un vehiculo en la clase Empleado
	 */
	@Test
	void testComprarVehiculo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		String resultadoEsperado = "Transaccion realizada correctamente - Compra de Vehiculo";
		String resultadoActual="";
		//Se compra el vehiculo
		try {
			resultadoActual = empleadoConcesionarioTest1.comprarVehiculo(90000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "SI");
		} catch (VehiculoNoPasaRevisionException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
				| VehiculoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}

		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de alquilar un vehiculo en la clase Empleado
	 */
	@Test
	void testAlquilarVehiculo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se compra el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.comprarVehiculo(90000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "SI");
			System.out.println(mensaje);
		} catch (VehiculoNoPasaRevisionException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
				| VehiculoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}

		//Se alquila el vehiculo
		String resultadoEsperado = "Transaccion realizada correctamente - Alquiler de Vehiculo";
		String resultadoActual="";
		try {
			resultadoActual = empleadoConcesionarioTest1.AlquilarVehiculo(1200000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "08.04.2023", "14.04.2023");
		} catch (ClienteNoRegistradoException | EmpleadoNoRegistradoException | VehiculoAlquiladoException
				| VehiculoNoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para verificar el metodo de obtener un alquiler por su consecutivo de alquiler en la clase Empleado
	 */
	@Test
	void testObtenerAlquiler() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se compra el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.comprarVehiculo(90000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "SI");
			System.out.println(mensaje);
		} catch (VehiculoNoPasaRevisionException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
				| VehiculoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}

		//Se alquila el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.AlquilarVehiculo(1200000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "08.04.2023", "14.04.2023");
			System.out.println(mensaje);
		} catch (ClienteNoRegistradoException | EmpleadoNoRegistradoException | VehiculoAlquiladoException
				| VehiculoNoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se obtiene el alquiler realizado por su consecutivo
		int resultadoEsperado = 1;
		int resultadoActual= empleadoConcesionarioTest1.obtenerAlquiler(1).getConsecutivoAlquiler();
		
		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	/**
	 * Prueba para el metodo de devolver un vehiculo que se encuentra alquilado.
	 * Esto se reliza despues de hacer la transaccion de alquiler.
	 */
	@Test
	void testDevolverVehiculoAlquiler() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se compra el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.comprarVehiculo(90000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "SI");
			System.out.println(mensaje);
		} catch (VehiculoNoPasaRevisionException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
				| VehiculoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}

		//Se alquila el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.AlquilarVehiculo(1200000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "08.04.2023", "14.04.2023");
			System.out.println(mensaje);
		} catch (ClienteNoRegistradoException | EmpleadoNoRegistradoException | VehiculoAlquiladoException
				| VehiculoNoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se devuelve el vehiculo despues del alquiler
		String resultadoEsperado = "El vehiculo se devolvió exitosamente";
		String resultadoActual="";
		
		try {
			resultadoActual = empleadoConcesionarioTest1.devolverVehiculoAlquiler(1);
		} catch (AlquilerNoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(resultadoEsperado, resultadoActual);

	}

	/**
	 * Prueba para verificar el metodo que obtiene las transacciones de un empleado
	 */
	@Test
	void testObtenerResgitroTransaccionesEmpleado() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre1", "apellido1", "1082", "user1", "contrasenia1", "correo1@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest1 = concesionario.obtenerEmpleado("1082");
		
		try {
			String mensaje = empleadoConcesionarioTest1.crearCliente("Juan", "Lopez", "1092");
			System.out.println(mensaje);
		} catch (CrearClienteException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<String> imagenesVehiculo = new ArrayList<String>();
			String mensaje = empleadoConcesionarioTest1.crearCamion(imagenesVehiculo, "8", "marca", "NUEVO", 2004, "MANUAL", 230.0, 2500.0, 20, 4, 950.5, true, true, false, 5, true, TipoVehiculo.DIESEL, CategoriaVehiculo.BUS, 0, 0, false, "NO APLICA", 5500.5, 6, 4, true, TipoCamion.MANIMULA);
			System.out.println(mensaje);
		} catch (VehiculoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se compra el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.comprarVehiculo(90000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023", "SI");
			System.out.println(mensaje);
		} catch (VehiculoNoPasaRevisionException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
				| VehiculoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		//Se Vende el vehiculo
		try {
			String mensaje = empleadoConcesionarioTest1.venderVehiculo(110000000.0, empleadoConcesionarioTest1.obtenerVehiculo("8"), empleadoConcesionarioTest1, empleadoConcesionarioTest1.obtenerCliente("1092"), "08.04.2023");
			System.out.println(mensaje);
		} catch (ClienteNoRegistradoException | EmpleadoNoRegistradoException | VehiculoAlquiladoException
				| VehiculoNoCompradoException | VehiculoNoRegistradoException e) {
			e.printStackTrace();
		}

		//Se verifica el metodo que obtiene las transacciones del empleado
		List<Transaccion> listaDeTransaccionesEmpleadoEsperada = empleadoConcesionarioTest1.getListaTransacciones();
		List<Transaccion> listaDeTransaccionesEmpleadoActual = null;
		try {
			listaDeTransaccionesEmpleadoActual = empleadoConcesionarioTest1.obtenerResgitroTransaccionesDeUnEmpleado("1082");
		} catch (EmpleadoNoRegistradoException e) {
			e.printStackTrace();
		}
		
		assertEquals(listaDeTransaccionesEmpleadoEsperada, listaDeTransaccionesEmpleadoActual);
		
	}

}
