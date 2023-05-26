package co.edu.uniquindio.concesionario.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegistroDeTransaccionesController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private Stage stage;
	private String fechaInicio;
	private String fechaFinal;

    @FXML
    private DatePicker inputFechaInicio;

    @FXML
    private DatePicker inputFechaFinal;

    @FXML
    void generarReporte(ActionEvent event) {
    	if(validarDatos(this.fechaInicio, this.fechaFinal)) {
        	TablaRegistroDeTransacciones newFrame = new TablaRegistroDeTransacciones(fechaInicio, fechaFinal);
        	newFrame.setVisible(true);
    	}
    }

    @FXML
    void getFechaFinal(ActionEvent event) {
    	LocalDate myDate = inputFechaFinal.getValue();
    	fechaFinal = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void getFechaInicio(ActionEvent event) {
    	LocalDate myDate = inputFechaInicio.getValue();
    	fechaInicio = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @FXML
    void volverButton(ActionEvent event) {
    	ventanaPrincipalAdministrativoController.show();
    	stage.close();
    }
    
    public void init(Stage stage, VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.stage = stage;
	}

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}

    private boolean validarDatos(String fechaInicio, String fechaFinal) {
		String mensaje = "";

		if(fechaInicio == null || fechaInicio.equals(""))
			mensaje += "La fecha de inicio es invalida \n";

		if(fechaFinal == null || fechaFinal.equals(""))
			mensaje += "La fecha final es invalida \n";

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información Empleado", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

}
