package co.edu.uniquindio.concesionario.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.exceptions.CrearEmpleadoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Alquiler;
import co.edu.uniquindio.concesionario.model.Cargo;
import co.edu.uniquindio.concesionario.model.Compra;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.Transaccion;
import co.edu.uniquindio.concesionario.model.Venta;



public class AdministrativoTest {


    /**
     * Test method for crearEmpleado de la clase Administrativo. Se verificar si al
     * crear el empleado el mensaje que retorna el éxito de la función sea igual.
     * 
     * @throws CrearEmpleadoException
     */
    @Test
    public void testCrearEmpleado() throws CrearEmpleadoException {

	// TODO Documentar para dar contexto y sha.

	List<Empleado> listaEmpleadosCrearEmpleado = new ArrayList<>();

	// Si se añadieran estas dos 2 líneas el test daría error ya que la
	// identificación del Empleado ya está asignada.
	/*
	 * Empleado empleadoCrearEmpleado = new Empleado("Daniel", "Correa", "E1");
	 * listaEmpleadosCrearEmpleado.add(empleadoCrearEmpleado);
	 */

	Concesionario concesionarioCrearEmpleado = new Concesionario(listaEmpleadosCrearEmpleado);
	Administrativo administrativoCrearEmpleado = new Administrativo(concesionarioCrearEmpleado);

	String resultadoEsperado = "Empleado creado exitosamente";
	String resultadoActual = "";

	resultadoActual = administrativoCrearEmpleado.crearEmpleado("Daniel", "Correa", "E1", "danco", "123",
		"dancorrea698@gmail.com", "mayo");

	assertEquals(resultadoEsperado, resultadoActual);
    }

    /**
     * Test del método ModificarEmpleado() Este método coge un Empleado ya creado y
     * le modificar el nombre, apellido y concesionario.
     * 
     * @throws EmpleadoNoRegistradoException
     */
    @Test
    public void testModificarEmpleado() throws EmpleadoNoRegistradoException {

	String resultadoEsperado = "Informacion del empleado modificada exitosamente";
	String resultadoActual = "";

	Concesionario concesionarioA = new Concesionario();
	Concesionario concesionarioB = new Concesionario();

	List<Empleado> listaEmpleadoModificarEmpleado = new ArrayList<Empleado>();
	Empleado empleadoModificarEmpleado = new Empleado("Daniel", "Correa", "1092", concesionarioA);

	listaEmpleadoModificarEmpleado.add(empleadoModificarEmpleado);

	Concesionario concesionarioModificarEmpleado = new Concesionario(listaEmpleadoModificarEmpleado);
	Administrativo administrativoModificarEmpleado = new Administrativo(concesionarioModificarEmpleado);

	resultadoActual = administrativoModificarEmpleado.modificarEmpleado("Julio", "Vergara", "1092", concesionarioB);

	assertEquals(resultadoEsperado, resultadoActual);
    }

    /**
     * Test del método eliminarEmpleado() de la clase Administrativo. Este método
     * usa la identificación de un empleado dentro de la lista de empleados de un
     * Concesionario y verifica si la identificación existe dentro de la lista para
     * eliminarlo.
     * 
     * @throws EmpleadoNoRegistradoException
     */
    @Test
    public void testEliminarEmpleado() throws EmpleadoNoRegistradoException {

	String resultadoEsperado = "El empleado fue eliminado exitosamente";
	String resultadoActual = "";

	Empleado empleadoA = new Empleado("Daniel", "Correa", "1092");
	Empleado empleadoB = new Empleado("Daniel", "Correa", "1093");

	List<Empleado> listaEmpleadosEliminarEmpleado = new ArrayList<Empleado>(Arrays.asList(empleadoA, empleadoB));
	Concesionario concesionarioEliminarEmpleado = new Concesionario(listaEmpleadosEliminarEmpleado);
	Administrativo administrativoEliminarEmpleado = new Administrativo(concesionarioEliminarEmpleado);

	resultadoActual = administrativoEliminarEmpleado.eliminarEmpleado(empleadoA.getIdentificacion());

	assertEquals(resultadoEsperado, resultadoActual);
    }

    /**
     * Test del método devolverEmpleado() de la clase Administrativo. Este método
     * devuelve la información de un empleado.
     * 
     * @throws EmpleadoNoRegistradoException
     */
    @Test
    public void testDevolverEmpleado() throws EmpleadoNoRegistradoException {

	Empleado empleadoA = new Empleado("Daniel", "Correa", "1092");

	String resultadoEsperado = "Nombres:" + " " + empleadoA.getNombres() + "\n" + "Apellidos:" + " "
		+ empleadoA.getApellidos() + "\n" + "Identificacion:" + " " + empleadoA.getIdentificacion() + "\n"
		+ "usuario:" + " " + empleadoA.getUsuario() + "\n" + "Correo:" + " " + empleadoA.getCorreo();
	String resultadoActual = "";

	List<Empleado> listaEmpleadosDevolverEmpleado = new ArrayList<Empleado>(Arrays.asList(empleadoA));
	Concesionario concesionarioDevolverEmpleado = new Concesionario(listaEmpleadosDevolverEmpleado);
	Administrativo administrativoDevolverEmpleado = new Administrativo(concesionarioDevolverEmpleado);

	resultadoActual = administrativoDevolverEmpleado.devolverEmpleado(empleadoA.getIdentificacion());

	assertEquals(resultadoEsperado, resultadoActual);

    }

    /**
     * Test del método CambiarEstadoEmpleado() de la clase Administrativo. Este
     * método cambia el estado de un empleado de "ACTIVO" a "INACTIVO" o viceversa.
     * En el JUnit Test el empleadoA se encuentra "ACTIVO" así que el mensaje que
     * debe retornar la función es que ha sido bloqueado de manera exitosa.
     * 
     * @throws EmpleadoNoRegistradoException
     */
    @Test
    public void testCambiarEstadoEmpleado() throws EmpleadoNoRegistradoException {

	String resultadoEsperado = "Empleado bloqueado Exitosamente";
	String resultadoActual = "";

	List<Empleado> listaEmpleadosCambiarEstadoEmpleado = new ArrayList<Empleado>();

	Empleado empleadoA = new Empleado("Daniel", "Correa", "1092", "ACTIVO");
	listaEmpleadosCambiarEstadoEmpleado.add(empleadoA);

	Concesionario concesionarioCambiarEstadoEmpleado = new Concesionario(listaEmpleadosCambiarEstadoEmpleado);
	Administrativo administrativoCambiarEstadoEmpleado = new Administrativo(concesionarioCambiarEstadoEmpleado);

	resultadoActual = administrativoCambiarEstadoEmpleado.cambiarEstadoEmpleado(empleadoA.getIdentificacion());

	assertEquals(resultadoEsperado, resultadoActual);

    }

    /**
     * Test de la función obtenerTransaccionesEntreFechas() de la clase
     * Administrativo que permite ver las transacciones entre un límite superior e
     * inferior de fechas. 
     * El método retorna un arrayList con las transacciones por
     * lo que para verificar si está bien se compara el tamaño esperado con el
     * tamaño de la lista. 
     * El constructor de Concesionario tiene un atributo String
     * nulo ya que al haber otro tipo de constructor que asigna una lista en
     * Concesionario el lenguaje lo toma como si se repitiera.
     */
    @Test
    public void testObtenerTransaccionesEntreFechas() {

	Integer cantidadDeTransaccionesEsperadas = 2;
	Integer cantidadDeTransaccionesActual = null;

	Compra compraA = new Compra("05.01.23");
	Venta ventaA = new Venta("12.01.23");
	Alquiler alquilerA = new Alquiler("22.01.23");

	List<Transaccion> listaTransacciones = new ArrayList<Transaccion>(Arrays.asList(compraA, ventaA, alquilerA));
	Concesionario concesionarioObtenerTransaccionesEntreFechas = new Concesionario(listaTransacciones, "");
	Administrativo administrativoObtenerTransaccionesEntreFechas = new Administrativo(
		concesionarioObtenerTransaccionesEntreFechas);

	List<Transaccion> resultado = administrativoObtenerTransaccionesEntreFechas
		.obtenerTransaccionesEntreFechas("01.01.23", "21.01.23");

	cantidadDeTransaccionesActual = resultado.size();

	assertEquals(cantidadDeTransaccionesEsperadas, cantidadDeTransaccionesActual);

    }

    /**
     * Test de la funcion actualizarCorreoEmpleado() en la clase Administrativo
     * Se crea un concesionario, un administrativo y un empleado para la prueba
     * Se modifica la direccion de correo electronico del empleado creado por el adminsitrativo
     * La salida debe verificar que la direcion de correo del empleado sea la misma que se actualizo
     */
    @Test
    public void testActualizarCorreoEmpleado() {
    
    	Concesionario consecionarioActualizacionCorreo = new Concesionario("ConcesionarioUQ-Correo", "1234567891011", "direccionDelConcesionario");
    	
    	try {
			String mensaje = consecionarioActualizacionCorreo.crearAdministrativo("Cesar", "Lopez", "12345", consecionarioActualizacionCorreo, "usuario1", "contraseñaAdmin", "correo@admin.com", "11.12.03", Cargo.GERENTE);
			System.out.println(mensaje);
		} catch (CrearAdministrativoException e) {
			System.out.println(e.getMessage());
		}
    	
    	Administrativo adminActualizacionCorreo = consecionarioActualizacionCorreo.obtenerAdministrativo("12345");
    	
    	try {
			String mensaje = adminActualizacionCorreo.crearEmpleado("Juan Jose", "Arce Aristizabal", "1092851015", "juanjarce", "123", "example@gmail.com", "11.12.04");
			System.out.println(mensaje);
		} catch (CrearEmpleadoException e) {
			System.out.println(e.getMessage());
		}
    	
    	
    	String nuevaDireccionCorreo = "juanj.arcea@uqvirtual.edu.co";
    	
    	try {
			String mensaje = adminActualizacionCorreo.actualizarCorreoEmpleado("1092851015", nuevaDireccionCorreo);
			System.out.println(mensaje);
		} catch (EmpleadoNoRegistradoException e) {
			System.out.println(e.getMessage());
		}
    	
    	Empleado empleado = consecionarioActualizacionCorreo.obtenerEmpleado("1092851015");
    	
    	assertEquals(nuevaDireccionCorreo, empleado.getCorreo());
    	
    }
}
