package co.edu.uniquindio.concesionario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.concesionario.exceptions.AdministrativoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.exceptions.CrearEmpleadoException;
import co.edu.uniquindio.concesionario.exceptions.UsuarioException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Cargo;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;

class ConcesionarioTest {

	/**
	 * Método que encuentra la posición de un usuario en la lista de empleados.
	 */
	@Test
	public void testEncontrarPosUsuario() {

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
		
		Integer posicionEsperada = 1;
		Integer posicionActual = -1;
		String usuario = empleadoConcesionarioTest1.getUsuario();
		posicionActual = concesionario.encontrarPosUsuario(usuario);
		assertEquals(posicionEsperada, posicionActual);
	}

	/**
	 * Prueba para comprobar el codigo de verificacion aleatorio generado por el concesionario
	 */
	@Test
	public void testGenerarStringAleatorio() {

		Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		String resultadoEsperado = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 62^62
		String resultadoActual = null;

		resultadoActual = concesionario.generarStringAleatorio();

		assertNotEquals(resultadoActual, resultadoEsperado);
		// 1 entre
		// 1343645645152250046583026779322969373035290953763411540290906502671301148502338015157014479136799509522304466944
	}

	@Test
	public void testVerificarUsoUsuario() {

        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre3", "apellido3", "1084", "user3", "contrasenia3", "correo3@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest3 = concesionario.obtenerEmpleado("1084");
		
		String usuario = empleadoConcesionarioTest3.getUsuario();
		boolean resultado = concesionario.verificarUsoUsuario(usuario);

		assertTrue(resultado);

	}

	@Test
	public void testObtenerAdministrativo() {
		
        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Johan", "Perez", "1095", concesionario, "johanpe", "1234", "example3@mail.com", "11.12.03", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		Administrativo administrativoConcesionarioTest2 = concesionario.obtenerAdministrativo("1095");
		
		String identificacion = administrativoConcesionarioTest2.getIdentificacion();
		Administrativo administrativoEsperado = administrativoConcesionarioTest2;

		Administrativo administrativoActual = concesionario.obtenerAdministrativo(identificacion);

		assertEquals(administrativoEsperado, administrativoActual);

	}

	@Test
	public void testCrearAdministrativo() throws CrearAdministrativoException {

		Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		String resultadoEsperado = "Administrativo creado exitosamente";
		String resultadoActual = "";
		
		 try{
			 resultadoActual = concesionario.crearAdministrativo("Daniel", "Correa", "1093", concesionario, "fanco", "123", "email@example.com", "mayo", Cargo.SUBGERENTE);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }

		assertEquals(resultadoEsperado, resultadoActual);
		
	}

	@Test
	public void testModificarAdministrativo() throws AdministrativoNoRegistradoException {

        Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Johan", "Perez", "1095", concesionario, "johanpe", "1234", "example3@mail.com", "11.12.03", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		Administrativo administrativoConcesionarioTest2 = concesionario.obtenerAdministrativo("1095");

		String resultadoEsperado = "El administrativo fue modificado exitosamente";
		String identificacion = administrativoConcesionarioTest2.getIdentificacion();
		
		String resultadoActual = "";
		try {
			resultadoActual = concesionario.modificarAdministrativo("Reemplazo", "Replacement", identificacion, concesionario, Cargo.GERENTE);
			System.out.println(resultadoActual);
		} catch (AdministrativoNoRegistradoException e) {
			e.printStackTrace();
		}

		assertEquals(resultadoEsperado, resultadoActual);

	}

	@Test
	public void testObtenerEmpleado() {

		Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre2", "apellido2", "1083", "user2", "contrasenia2", "correo2@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest2 = concesionario.obtenerEmpleado("1083");

		String identificacion = empleadoConcesionarioTest2.getIdentificacion();
		Empleado resultadoEsperado = empleadoConcesionarioTest2;
		Empleado resultadoActual = concesionario.obtenerEmpleado(identificacion);

		assertEquals(resultadoEsperado, resultadoActual);

	}

	@Test
	public void testVerificarEmpleado() {

		Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre2", "apellido2", "1083", "user2", "contrasenia2", "correo2@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest2 = concesionario.obtenerEmpleado("1083");

		String identificacion = empleadoConcesionarioTest2.getIdentificacion();
		boolean resultado = concesionario.verificarEmpleado(identificacion);
		assertTrue(resultado);
	}

	@Test
	public void testCambiarInformacionUsuario() throws UsuarioException {

		Concesionario concesionario = new Concesionario("ConcesionarioUQ-JUni", "12345", "direccion");
		
		try {
			String mensaje = concesionario.crearAdministrativo("Jairo", "Castaño", "1094", concesionario, "ganco", "124", "example2@mail.com", "abril", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			e.printStackTrace();
		}
		
		Administrativo adminTest = concesionario.obtenerAdministrativo("1094");
		
		try {
			String mensaje = adminTest.crearEmpleado("nombre2", "apellido2", "1083", "user2", "contrasenia2", "correo2@gmail.com", "11.11.11");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			e.printStackTrace();
		}
		Empleado empleadoConcesionarioTest2 = concesionario.obtenerEmpleado("1083");

		String resultadoEsperado = "Usuario y Contraseña modificada exitosamente";
		String resultadoActual = "";
		try {
			resultadoActual = concesionario.cambiarInformacionUsuario(empleadoConcesionarioTest2, "Adolf", "Rafael");
			System.out.println(resultadoActual);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}

		assertEquals(resultadoEsperado, resultadoActual);
	}

	@Test
	public void testIsEntreFechas() {
		
		String fechaInicial = "01.01.23";

		String cumpleaniosEx = "22.01.23";

		String fechaFinal = "31.01.23";

		boolean resultado = Concesionario.isEntreFechas(cumpleaniosEx, fechaInicial, fechaFinal);

		assertTrue(resultado);
	}

}
