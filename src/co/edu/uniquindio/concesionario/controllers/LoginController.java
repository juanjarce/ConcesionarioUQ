package co.edu.uniquindio.concesionario.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	private Empleado miEmpleado;
	private Administrativo miAdministrativo;
	private Stage stage;
  
	@FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputContrasenia;

    @FXML
    void cambiarContraseniaButton(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/CambioContrasenia.fxml"));
    	Parent root = loader.load();
    	CambioContraseniaController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.init(stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void crearAdminButton(ActionEvent event) throws IOException {
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/CrearUsuarioAdmin.fxml"));
    	Parent root = loader.load();
    	CrearUsuarioAdminController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.init(stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void ingresarButton(ActionEvent event) throws IOException {
		int pos = ModelFactoryController.getInstance().encontrarPosUsuario(inputUsuario.getText());
		if(pos != -1) {
			if(inputContrasenia.getText().equals(ModelFactoryController.getInstance().getMiConcesionario().getListaEmpleados().get(pos).getContrasenia())) {
				String identificacion = ModelFactoryController.getInstance().getMiConcesionario().getListaEmpleados().get(pos).getIdentificacion();
				miAdministrativo = ModelFactoryController.getInstance().obtenerAdministrativo(identificacion);
				miEmpleado = ModelFactoryController.getInstance().obtenerEmpleado(identificacion);
				if(miAdministrativo!=null && miAdministrativo.getEstado().equals("ACTIVO")) {
					inputUsuario.setText(null);
					inputContrasenia.setText(null);
					ModelFactoryController.getInstance().setMiAdministrativo(miAdministrativo);
			    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/VentanaPrincipalAdministrativo.fxml"));
			    	Parent root = loader.load();
			    	VentanaPrincipalAdministrativoController controller = loader.getController();
			    	Scene scene = new Scene(root);
			    	Stage stage = new Stage();
			    	stage.setScene(scene);
			    	controller.init(stage, this);
			    	stage.show();
			    	this.stage.close();
				}
				else {
					if(miEmpleado!=null && miEmpleado.getEstado().equals("ACTIVO")) {
						inputUsuario.setText(null);
						inputContrasenia.setText(null);
						ModelFactoryController.getInstance().setMiEmpleado(miEmpleado);
				    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/VentanaPrincipalEmpleado.fxml"));
				    	Parent root = loader.load();
				    	VentanaPrincipalEmpleadoController controller = loader.getController();
				    	Scene scene = new Scene(root);
				    	Stage stage = new Stage();
				    	stage.setScene(scene);
				    	controller.init(stage, this);
				    	stage.show();
				    	this.stage.close();

					}
					else {
						mostrarMensaje("Mensaje Informativo", "Usuario Bloqueado", "El usuario se encuentra bloqueado", AlertType.WARNING);
					}
				}
			}
			else {
				mostrarMensaje("Mensaje Informativo", "Contraseña incorrecta", "La contraseña ingresada es incorrecta", AlertType.WARNING);
			}
		}
		else {
			mostrarMensaje("Mensaje Informativo", "Usuario no registrado", "El usuario no se encuentra registrado", AlertType.WARNING);
		}

    }

	public void setStage(Stage primaryStage) {
		stage = primaryStage;
	}

	public void show() {
		// TODO Auto-generated method stub
		stage.show();
	}

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}
	
}
