package co.edu.uniquindio.concesionario.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import co.edu.uniquindio.concesionario.model.Administrativo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class RegistroDeTransaccionesController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private Stage stage;
	private Administrativo miAdministrativo;
	private String fechaInicio;
	private String fechaFinal;

    @FXML
    private DatePicker inputFechaInicio;

    @FXML
    private DatePicker inputFechaFinal;

    @FXML
    void generarReporte(ActionEvent event) {
    	TablaRegistroDeTransacciones newFrame = new TablaRegistroDeTransacciones(miAdministrativo, fechaInicio, fechaFinal);
    	newFrame.setVisible(true);
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
    
    public void init(Administrativo miAdministrativo, Stage stage, VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.stage = stage;
		this.miAdministrativo = miAdministrativo;
	}

}
