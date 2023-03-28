package co.edu.uniquindio.concesionario.controllers;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.CrearClienteException;
import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroClientesController {

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
	private Concesionario miConcesionario;
	private Empleado miEmpleado;
    @FXML
    private TextField inputNombres;

    @FXML
    private TextField inputApellidos;

    @FXML
    private TextField inputIdentificacion;

    @FXML
    void buscarCliente(ActionEvent event) {
		try {
			String mensaje = miEmpleado.devolverCliente(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del cliente:"));
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (HeadlessException | ClienteNoRegistradoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
   }

    @FXML
    void crearCliente(ActionEvent event) {
		try {
			String mensaje = miEmpleado.crearCliente(inputNombres.getText(), inputApellidos.getText(), inputIdentificacion.getText());
			JOptionPane.showMessageDialog(null, mensaje);
			inputNombres.setText(null);
			inputApellidos.setText(null);
			inputIdentificacion.setText(null);
		} catch (CrearClienteException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
    }

    @FXML
    void eliminarCliente(ActionEvent event) {
		try {
			String mensaje = miEmpleado.eliminarCliente(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del cliente:"));
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (HeadlessException | ClienteNoRegistradoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
    }

    @FXML
    void modificarCliente(ActionEvent event) {
		try {
			String mensaje = miEmpleado.modificarCliente(JOptionPane.showInputDialog(null, "Ingrese los nombres del cliente:"), JOptionPane.showInputDialog(null, "Ingrese los apellidos del cliente:"), JOptionPane.showInputDialog(null, "Ingrese la identificacion del cliente:"));
			JOptionPane.showMessageDialog(null, mensaje);
		} catch (HeadlessException | ClienteNoRegistradoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
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
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.ventanaPrincipalEmpleadoController = null;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
		this.miEmpleado = miAdministrativo;
	}

	public void initDesdeEmpleado(Concesionario miConcesionario, Empleado miEmpleado, Stage stage,
			VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = null;
		this.ventanaPrincipalEmpleadoController = ventanaPrincipalEmpleadoController;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
		this.miEmpleado = miEmpleado;
	}

}

