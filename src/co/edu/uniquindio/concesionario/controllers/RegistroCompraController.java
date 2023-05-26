package co.edu.uniquindio.concesionario.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoCompradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoPasaRevisionException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroCompraController implements Initializable{

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
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
    private ComboBox inputRevision;

    @FXML
    void getFecha(ActionEvent event){
       	LocalDate myDate = inputFecha.getValue();
    	fechaTransaccion = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void realizarTransaccion(ActionEvent event) {
    	if(validarDatos(inputTotal.getText(), inputVehiculo.getText(), inputCliente.getText(), this.fechaTransaccion, inputRevision.getSelectionModel().getSelectedItem().toString())) {
        	Vehiculo vehiculo = miEmpleado.obtenerVehiculo(inputVehiculo.getText().toString());
        	Cliente cliente = miEmpleado.obtenerCliente(inputCliente.getText().toString());
    		try {
    			
    			String mensaje = miEmpleado.comprarVehiculo(Double.parseDouble(inputTotal.getText()), vehiculo, miEmpleado, cliente, fechaTransaccion, inputRevision.getSelectionModel().getSelectedItem().toString());
    			mostrarMensaje("Mensaje Informativo", "Transaccion Realizada", mensaje, AlertType.INFORMATION);
    			inputVehiculo.setText(null);
    			inputCliente.setText(null);
    			inputTotal.setText(null);
    			inputRevision.getSelectionModel().clearSelection();
    			
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			
    		} catch (NumberFormatException | VehiculoNoPasaRevisionException | ClienteNoRegistradoException
    				| EmpleadoNoRegistradoException | VehiculoCompradoException | VehiculoNoRegistradoException e) {
    			mostrarMensaje("Mensaje Informativo", "Error Realizando Transaccion", e.getMessage(), AlertType.WARNING);
    		}
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	ObservableList<String> listCondicion = FXCollections.observableArrayList("SI", "NO");
    	inputRevision.setItems(listCondicion);
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
	
    private boolean validarDatos(String total, String vehiculo, String cliente, String fechaTransaccion, String revision) {
		String mensaje = "";

		if(total == null || total.equals(""))
			mensaje += "El total es invalido \n";

		if(vehiculo == null || vehiculo.equals(""))
			mensaje += "El vehiculo es invalido \n";

		if(cliente == null || cliente.equals(""))
			mensaje += "El cliente es invalido \n";

		if(fechaTransaccion == null || fechaTransaccion.equals(""))
			mensaje += "La fecha de transaccion es invalida \n";

		if(revision == null || revision.equals(""))
			mensaje += "La revision es invalida \n";

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información Empleado", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

}
