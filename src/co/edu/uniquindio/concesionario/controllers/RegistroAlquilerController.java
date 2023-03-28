package co.edu.uniquindio.concesionario.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.TransaccionException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroAlquilerController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
	private Concesionario miConcesionario;
	private Empleado miEmpleado;
	private String fechaTransaccion;
	private String fechaInicio;
	private String fechaEntrega;

    @FXML
    private TextField inputTotal;

    @FXML
    private TextField inputVehiculo;

    @FXML
    private TextField inputCliente;

    @FXML
    private DatePicker inputFechaTransaccion;

    @FXML
    private DatePicker inputFechaInicio;

    @FXML
    private DatePicker inputFechaEntrega;

    @FXML
    void getFechaEntrega(ActionEvent event) {
    	LocalDate myDate = inputFechaEntrega.getValue();
    	fechaEntrega = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void getFechaInicio(ActionEvent event) {
    	LocalDate myDate = inputFechaInicio.getValue();
    	fechaInicio = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void getFechaTransaccion(ActionEvent event) {
    	LocalDate myDate = inputFechaTransaccion.getValue();
    	fechaTransaccion = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void realizarTransaccion(ActionEvent event) {
    	Vehiculo vehiculo = miEmpleado.obtenerVehiculo(inputVehiculo.getText().toString());
    	Cliente cliente = miEmpleado.obtenerCliente(inputCliente.getText().toString());
    	try {
			String mensaje = miEmpleado.AlquilarVehiculo(Double.parseDouble(inputTotal.getText()), vehiculo, miEmpleado, cliente, fechaTransaccion, fechaInicio, fechaEntrega);
			JOptionPane.showMessageDialog(null, mensaje);
			inputVehiculo.setText(null);
			inputCliente.setText(null);
			inputTotal.setText(null);
		} catch (NumberFormatException | TransaccionException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    @FXML
    void devolverVehiculoDeAlquiler(ActionEvent event) {
    	int consecutivoAlquiler = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el consecutivo del alquiler"));
    	try {
			String mensaje = miEmpleado.devolverVehiculoAlquiler(consecutivoAlquiler);
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (TransaccionException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    @FXML
    void volverButton(ActionEvent event) {
    	if(ventanaPrincipalAdministrativoController != null) {
    		ventanaPrincipalAdministrativoController.show();
        	stage.close();
    	}
    	else {
    		ventanaPrincipalEmpleadoController.show();
    		stage.close();
    	}
    }

    public void initDesdeAdmin(Concesionario miConcesionario, Administrativo miAdministrativo, Stage stage,
			VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.ventanaPrincipalEmpleadoController = null;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
		this.miEmpleado = miAdministrativo;
	}

	public void initDesdeEmpleado(Concesionario miConcesionario, Empleado miEmpleado, Stage stage,
			VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController) {
		this.ventanaPrincipalAdministrativoController = null;
		this.ventanaPrincipalEmpleadoController = ventanaPrincipalEmpleadoController;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
		this.miEmpleado = miEmpleado;
	}
	
}

