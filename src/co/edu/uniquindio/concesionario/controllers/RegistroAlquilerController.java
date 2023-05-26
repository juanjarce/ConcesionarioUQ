package co.edu.uniquindio.concesionario.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.AlquilerNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoAlquiladoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoCompradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroAlquilerController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
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
    	if(validarDatos(inputTotal.getText(), inputVehiculo.getText(), inputCliente.getText(), this.fechaTransaccion, this.fechaInicio, this.fechaEntrega)) {
        	Vehiculo vehiculo = miEmpleado.obtenerVehiculo(inputVehiculo.getText().toString());
        	Cliente cliente = miEmpleado.obtenerCliente(inputCliente.getText().toString());
    		try {
    			
    			String mensaje = miEmpleado.AlquilarVehiculo(Double.parseDouble(inputTotal.getText()), vehiculo, miEmpleado, cliente, fechaTransaccion, fechaInicio, fechaEntrega);
    			mostrarMensaje("Mensaje Informativo", "Transaccion Realizada", mensaje, AlertType.INFORMATION);
    			inputVehiculo.setText(null);
    			inputCliente.setText(null);
    			inputTotal.setText(null);
    			
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			
    		} catch (NumberFormatException | ClienteNoRegistradoException | EmpleadoNoRegistradoException
    				| VehiculoAlquiladoException | VehiculoNoCompradoException | VehiculoNoRegistradoException e) {
    			mostrarMensaje("Mensaje Informativo", "Error realizando transaccion", e.getMessage(), AlertType.WARNING);
    		}
    	}
    }

    @FXML
    void devolverVehiculoDeAlquiler(ActionEvent event) {
    	int consecutivoAlquiler = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el consecutivo del alquiler"));
    	try {
			String mensaje = miEmpleado.devolverVehiculoAlquiler(consecutivoAlquiler);
			mostrarMensaje("Mensaje Informativo", "Devolucion Realizada", mensaje, AlertType.INFORMATION);
			
			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Se almacenan los datos en archivos
			ModelFactoryController.getInstance().serializar();
			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
			
		} catch (AlquilerNoRegistradoException e) {
			mostrarMensaje("Mensaje Informativo", "Error devolviendo el vehiculo del alquiler", e.getMessage(), AlertType.WARNING);
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

    public void initDesdeAdmin(Stage stage, VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.ventanaPrincipalEmpleadoController = null;
		this.stage = stage;
		this.miEmpleado = ModelFactoryController.getInstance().getMiAdministrativo();
	}

	public void initDesdeEmpleado(Stage stage, VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController) {
		this.ventanaPrincipalAdministrativoController = null;
		this.ventanaPrincipalEmpleadoController = ventanaPrincipalEmpleadoController;
		this.stage = stage;
		this.miEmpleado = ModelFactoryController.getInstance().getMiEmpleado();
	}
	
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}
	
    private boolean validarDatos(String total, String vehiculo, String cliente, String fechaTransaccion, String fechaInicio, String fechaEntrega) {
		String mensaje = "";

		if(total == null || total.equals(""))
			mensaje += "El total es invalido \n";

		if(vehiculo == null || vehiculo.equals(""))
			mensaje += "El vehiculo es invalido \n";

		if(cliente == null || cliente.equals(""))
			mensaje += "El cliente es invalido \n";

		if(fechaTransaccion == null || fechaTransaccion.equals(""))
			mensaje += "La fecha de transaccion es invalida \n";

		if(fechaInicio == null || fechaInicio.equals(""))
			mensaje += "La fecha de inicio es invalida \n";

		if(fechaEntrega == null || fechaEntrega.equals(""))
			mensaje += "La fecha de entrega es invalida \n";

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información Empleado", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

}

