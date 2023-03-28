package co.edu.uniquindio.concesionario.controllers;

import java.io.IOException;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	private Concesionario miConcesionario = new Concesionario("Carros UQ", "12345", " Carrera 15 #12N, Armenia, Quindío");
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
    	controller.init(miConcesionario, stage, this);
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
    	controller.init(miConcesionario, stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void ingresarButton(ActionEvent event) throws IOException {
		int pos = miConcesionario.entonctrarPosUsuario(inputUsuario.getText());
		if(pos != -1) {
			if(inputContrasenia.getText().equals(miConcesionario.listaEmpleados.get(pos).getContrasenia())) {
				String identificacion = miConcesionario.listaEmpleados.get(pos).getIdentificacion();
				miAdministrativo = miConcesionario.obtenerAdministrativo(identificacion);
				miEmpleado = miConcesionario.obtenerEmpleado(identificacion);
				if(miAdministrativo!=null && miAdministrativo.getEstado()=="ACTIVO") {
					inputUsuario.setText(null);
					inputContrasenia.setText(null);
			    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/VentanaPrincipalAdministrativo.fxml"));
			    	Parent root = loader.load();
			    	VentanaPrincipalAdministrativoController controller = loader.getController();
			    	Scene scene = new Scene(root);
			    	Stage stage = new Stage();
			    	stage.setScene(scene);
			    	controller.init(miConcesionario, miAdministrativo, stage, this);
			    	stage.show();
			    	this.stage.close();
				}
				else {
					if(miEmpleado!=null && miEmpleado.getEstado()=="ACTIVO") {
						inputUsuario.setText(null);
						inputContrasenia.setText(null);
				    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/VentanaPrincipalEmpleado.fxml"));
				    	Parent root = loader.load();
				    	VentanaPrincipalEmpleadoController controller = loader.getController();
				    	Scene scene = new Scene(root);
				    	Stage stage = new Stage();
				    	stage.setScene(scene);
				    	controller.init(miConcesionario, miEmpleado, stage, this);
				    	stage.show();
				    	this.stage.close();

					}
					else {
						JOptionPane.showMessageDialog(null, "El usuario se encuentra bloqueado");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "El usuario no esta registrado");
		}

    }

	public void setStage(Stage primaryStage) {
		stage = primaryStage;
	}

	public void show() {
		// TODO Auto-generated method stub
		stage.show();
	}

}
