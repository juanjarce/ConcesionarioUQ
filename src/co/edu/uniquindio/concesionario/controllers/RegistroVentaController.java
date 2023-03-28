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

public class RegistroVentaController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
	private Concesionario miConcesionario;
	private Empleado miEmpleado;
	private String fechaTransaccion;
	
    @FXML
    private TextField inputTotal;

    @FXML
    private DatePicker inputFecha;

    @FXML
    private TextField inputVehiculo;

    @FXML
    private TextField inputCliente;

    @FXML
    void getFecha(ActionEvent event) {
    	LocalDate myDate = inputFecha.getValue();
    	fechaTransaccion = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void realizarTransaccion(ActionEvent event) {
    	Vehiculo vehiculo = miEmpleado.obtenerVehiculo(inputVehiculo.getText().toString());
    	Cliente cliente = miEmpleado.obtenerCliente(inputCliente.getText().toString());
    	try {
			String mensaje = miEmpleado.venderVehiculo(Double.parseDouble(inputTotal.getText()), vehiculo, miEmpleado, cliente, fechaTransaccion);
			JOptionPane.showMessageDialog(null, mensaje);
			inputVehiculo.setText(null);
			inputCliente.setText(null);
			inputTotal.setText(null);
		} catch (NumberFormatException | TransaccionException e) {
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
