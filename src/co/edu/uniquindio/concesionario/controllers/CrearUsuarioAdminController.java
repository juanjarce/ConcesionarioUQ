package co.edu.uniquindio.concesionario.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.model.Cargo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearUsuarioAdminController implements Initializable{

	private LoginController loginController;
	private Stage stage;
	
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
    private ComboBox comboCargo;

    @FXML
    void crearAdministrativo(ActionEvent event) {
    	String nombres = inputNombres.getText();
    	String apellidos = inputApellidos.getText();
    	String identificacion = inputIdentificacion.getText();
    	String usuario = inputUsuario.getText();
    	String contrasenia = inputContrasenia.getText();
    	String correo = inputCorreo.getText();
    	String respuestaSeguridad = inputRespuestaSeguridad.getText();
		Cargo cargo = Cargo.valueOf(comboCargo.getSelectionModel().getSelectedItem().toString());
		if(validarDatos(nombres, apellidos, identificacion, usuario, contrasenia, correo, respuestaSeguridad, cargo)) {
			try {
				String mensaje = ModelFactoryController.getInstance().crearAdministrativo(nombres, apellidos, identificacion, usuario, contrasenia, correo, respuestaSeguridad, cargo);
				mostrarMensaje("Mensaje Informativo", "Administrativo Registrado", mensaje, AlertType.INFORMATION);
				inputNombres.setText(null);
				inputApellidos.setText(null);
				inputIdentificacion.setText(null);
				inputUsuario.setText(null);
				inputContrasenia.setText(null);
				inputCorreo.setText(null);
				inputRespuestaSeguridad.setText(null);
				comboCargo.getSelectionModel().clearSelection();
			} catch (CrearAdministrativoException e1) {
				mostrarMensaje("Mensaje Informativo", "Error en creacion de administartivo", e1.getMessage(), AlertType.WARNING);
			}
		}
    }

    @FXML
    void volverButton(ActionEvent event) {
     	loginController.show();
    	stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	ObservableList<String> list = FXCollections.observableArrayList("ADMINISTRADOR", "GERENTE", "SUBGERENTE");
    	comboCargo.setItems(list);
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

    private boolean validarDatos(String nombre, String apellidos, String identificacion, String usuario, String contrasenia, String correo, String respuestaSeguridad, Cargo cargo) {
		String mensaje = "";

		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n";

		if(apellidos == null || apellidos.equals(""))
			mensaje += "Los apellidos son invalidos \n";

		if(identificacion == null || identificacion.equals(""))
			mensaje += "La identificacion es invalida \n";

		if(usuario == null || usuario.equals(""))
			mensaje += "El usuario es invalido \n";

		if(contrasenia == null || contrasenia.equals(""))
			mensaje += "La contrasenia es invalida \n";

		if(correo == null || correo.equals(""))
			mensaje += "El correo es invalido \n";

		if(respuestaSeguridad == null || respuestaSeguridad.equals(""))
			mensaje += "La respuesta de seguridad es invalida \n";
		
		if(cargo == null)
			mensaje += "El cargo es invalido \n";

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información Empleado", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}
    
}
