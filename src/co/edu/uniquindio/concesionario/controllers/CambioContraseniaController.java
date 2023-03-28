package co.edu.uniquindio.concesionario.controllers;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.UsuarioException;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.EnvioCorreos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CambioContraseniaController {

	private LoginController loginController;
	private Stage stage;
	private Concesionario miConcesionario;
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
		codigoVerificacion = miConcesionario.generarStringAleatorio();
		String identificacion = JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del usuario");
		Empleado empleado = miConcesionario.obtenerEmpleado(identificacion);
		if(empleado != null) {
			EnvioCorreos envioCorreos = new EnvioCorreos();
			envioCorreos.createEmail(empleado.getCorreo(), "Codigo de verificacion", codigoVerificacion);
			envioCorreos.sendEmail();
			JOptionPane.showMessageDialog(null, "Codigo enviado al correo:"+" "+empleado.getCorreo());
		}
		else {
			JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
		}
    }

    @FXML
    void modificarUsuario(ActionEvent event) {
		if(codigoVerificacion.equals(inputCodigo.getText())) {
			String identificacion = JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del usuario");
			Empleado empleado = miConcesionario.obtenerEmpleado(identificacion);
			if(empleado != null) {
				if(empleado.getRespuestaPreguntaSeguridad().equals(inputRespuestaSeguridad.getText())) {
					String mensaje;
					try {
						mensaje = miConcesionario.cambiarInformacionUsuario(empleado, inputUsuario.getText(), inputContrasenia.getText());
						JOptionPane.showMessageDialog(null, mensaje);
						inputUsuario.setText(null);
						inputContrasenia.setText(null);
						inputRespuestaSeguridad.setText(null);
						inputCodigo.setText(null);
					} catch (UsuarioException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
					}				}
				else {
					JOptionPane.showMessageDialog(null, "La respuesta de seguridad no coincide");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no esta registrado");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "El codigo de verificacion es incorrecto");
		}
    }

    @FXML
    void volverButton(ActionEvent event) {
       	loginController.show();
    	stage.close();
    }

	public void init(Concesionario miConcesionario, Stage stage, LoginController loginController) {
		// TODO Auto-generated method stub
		this.loginController = loginController;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
	}

}
