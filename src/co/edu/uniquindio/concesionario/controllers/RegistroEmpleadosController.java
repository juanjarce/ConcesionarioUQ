package co.edu.uniquindio.concesionario.controllers;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.CrearEmpleadoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroEmpleadosController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private Stage stage;
	private Concesionario miConcesionario;
	private Administrativo miAdministrativo;
    @FXML
    private TextField inputNombres;

    @FXML
    private TextField inputApellidos;

    @FXML
    private TextField inputIdentificacion;

    @FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputContrasenia;

    @FXML
    private TextField inputCorreo;

    @FXML
    private TextField inputRespuestaSeguridad;

    @FXML
    void buscarEmpleado(ActionEvent event) {
		Empleado empleado = miConcesionario.obtenerEmpleado(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del empleado:"));
		if(empleado != null) {
			inputNombres.setText(empleado.getNombres());
			inputApellidos.setText(empleado.getApellidos());
			inputIdentificacion.setText(empleado.getIdentificacion());
			inputUsuario.setText(empleado.getUsuario());
			inputContrasenia.setText(empleado.getContrasenia());
			inputCorreo.setText(empleado.getCorreo());
			inputRespuestaSeguridad.setText("La respuesta a la pregunta de seguridad es privada");
		}
		else {
			JOptionPane.showMessageDialog(null, "El empleado no se encuentra registrado");
		}
    }

    @FXML
    void cambiarEstadoEmpleado(ActionEvent event) {
		try {
			String mensaje = miAdministrativo.cambiarEstadoEmpleado(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del empleado:"));
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (HeadlessException | EmpleadoNoRegistradoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
    }

    @FXML
    void crearEmpleado(ActionEvent event) {
    	try {
			String mensaje = miAdministrativo.crearEmpleado(inputNombres.getText(), inputApellidos.getText(), inputIdentificacion.getText(), inputUsuario.getText(), inputContrasenia.getText(), inputCorreo.getText(), inputRespuestaSeguridad.getText());
			JOptionPane.showMessageDialog(null, mensaje);
			inputNombres.setText(null);
			inputApellidos.setText(null);
			inputIdentificacion.setText(null);
			inputUsuario.setText(null);
			inputContrasenia.setText(null);
			inputCorreo.setText(null);
			inputRespuestaSeguridad.setText(null);
		} catch (CrearEmpleadoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
    }

    @FXML
    void eliminarEmpleado(ActionEvent event) {
		try {
			String mensaje = miAdministrativo.eliminarEmpleado(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del empleado:"));
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (HeadlessException | EmpleadoNoRegistradoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
    }

    @FXML
    void modificarEmpleado(ActionEvent event) {
		try {
			String mensaje = miAdministrativo.modificarEmpleado(JOptionPane.showInputDialog(null, "Ingrese los nombres del empleado:"), JOptionPane.showInputDialog(null, "Ingrese los apellidos del empleado:"), JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del empleado:"), miConcesionario);
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (HeadlessException | EmpleadoNoRegistradoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
    }

    @FXML
    void volverButton(ActionEvent event) {
    	ventanaPrincipalAdministrativoController.show();
    	stage.close();
    }

	public void init(Concesionario miConcesionario, Administrativo miAdministrativo, Stage stage,
			VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
		this.miAdministrativo = miAdministrativo;
	}

}
