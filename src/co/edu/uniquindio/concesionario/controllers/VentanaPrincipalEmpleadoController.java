package co.edu.uniquindio.concesionario.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaPrincipalEmpleadoController {

	private LoginController loginController;
	private Stage stage;
	private Concesionario miConcesionario;
	private Empleado miEmpleado;
    @FXML
    void alquilarVehiculo(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/RegistroAlquiler.fxml"));
    	Parent root = loader.load();
    	RegistroAlquilerController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.initDesdeEmpleado(miConcesionario, miEmpleado, stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void cerrarSesion(ActionEvent event) {
    	loginController.show();
    	stage.close();
    }

    @FXML
    void comprarVehiculo(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/RegistroCompra.fxml"));
    	Parent root = loader.load();
    	RegistroCompraController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.initDesdeEmpleado(miConcesionario, miEmpleado, stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void mostrarReportesDeNegocio(ActionEvent event) {
    	TablaReporteDeNegocios newFrame = new TablaReporteDeNegocios(miEmpleado);
    	newFrame.setVisible(true);
    }

    @FXML
    void registrarCliente(ActionEvent event) throws IOException {
      	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/RegistroClientes.fxml"));
    	Parent root = loader.load();
    	RegistroClientesController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.initDesdeEmpleado(miConcesionario, miEmpleado, stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void registrarVehiculo(ActionEvent event) throws IOException {
      	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/RegistroVehiculos.fxml"));
    	Parent root = loader.load();
    	RegistroVehiculosController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.initDesdeEmpleado(miConcesionario, miEmpleado, stage, this);
    	stage.show();
    	this.stage.close();
    }

    @FXML
    void venderVehiculo(ActionEvent event) throws IOException {
      	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/RegistroVenta.fxml"));
    	Parent root = loader.load();
    	RegistroVentaController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.initDesdeEmpleado(miConcesionario, miEmpleado, stage, this);
    	stage.show();
    	this.stage.close();
    }

	public void init(Concesionario miConcesionario, Empleado miEmpleado, Stage stage,
			LoginController loginController) {
		// TODO Auto-generated method stub
		this.loginController = loginController;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
		this.miEmpleado = miEmpleado;
	}

	public void show() {
		// TODO Auto-generated method stub
		stage.show();
	}

}

