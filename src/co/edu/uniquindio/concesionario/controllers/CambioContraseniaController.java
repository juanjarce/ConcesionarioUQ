package co.edu.uniquindio.concesionario.controllers;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.UsuarioException;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.email.EnvioCorreos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CambioContraseniaController {

	private LoginController loginController;
	private Stage stage;
	private String codigoVerificacion = null;
	
    @FXML
    private TextField inputUsuario;

    @FXML
    private TextField inputContrasenia;

    @FXML
    private TextField inputRespuestaSeguridad;

    @FXML
    private TextField inputCodigo;

    @FXML
    void enviarCodigoVerificacion(ActionEvent event) {
		codigoVerificacion = ModelFactoryController.getInstance().generarStringAleatorio();
		String identificacion = JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del usuario");
		Empleado empleado = ModelFactoryController.getInstance().obtenerEmpleado(identificacion);
		if(empleado != null) {
			EnvioCorreos envioCorreos = new EnvioCorreos();
			envioCorreos.createEmail(empleado.getCorreo(), "Codigo de verificacion", codigoVerificacion);
			envioCorreos.sendEmail();
			mostrarMensaje("Mensaje Informativo", "Envio de Correo",  "Codigo enviado al correo:"+" "+empleado.getCorreo(), AlertType.INFORMATION);
		}
		else {
			mostrarMensaje("Mensaje Informativo", "Error de usuario",  "El usuario no se encuentra registrado", AlertType.WARNING);
		}
    }

    @FXML
    void modificarUsuario(ActionEvent event) {
		if(codigoVerificacion.equals(inputCodigo.getText())) {
			String identificacion = JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del usuario");
			Empleado empleado = ModelFactoryController.getInstance().obtenerEmpleado(identificacion);
			if(empleado != null) {
				if(empleado.getRespuestaPreguntaSeguridad().equals(inputRespuestaSeguridad.getText())) {
					String mensaje;
					try {
						mensaje = ModelFactoryController.getInstance().cambiarInformacionUsuario(empleado, inputUsuario.getText(), inputContrasenia.getText());
						mostrarMensaje("Mensaje Informativo", "Informacion de Cuenta Actualizada", mensaje, AlertType.INFORMATION);
						inputUsuario.setText(null);
						inputContrasenia.setText(null);
						inputRespuestaSeguridad.setText(null);
						inputCodigo.setText(null);
												
					} catch (UsuarioException e) {
						mostrarMensaje("Mensaje Informativo", "Error de Cambio Usuario",  e.getMessage(), AlertType.WARNING);
					}				
				}
				else {
					mostrarMensaje("Mensaje Informativo", "Error de Respuesta Seguridad",  "La respuesta de seguridad no coincide", AlertType.WARNING);
				}
			}
			else {
				mostrarMensaje("Mensaje Informativo", "Error de Usuario",  "El usuario no esta registrado", AlertType.WARNING);
			}
		}
		else {
			mostrarMensaje("Mensaje Informativo", "Error de Codigo Verificacion",  "El codigo de verificacion es incorrecto", AlertType.WARNING);
		}
    }

    @FXML
    void volverButton(ActionEvent event) {
       	loginController.show();
    	stage.close();
    }

	public void init(Stage stage, LoginController loginController) {
		// TODO Auto-generated method stub
		this.loginController = loginController;
		this.stage = stage;
	}

    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}

}
