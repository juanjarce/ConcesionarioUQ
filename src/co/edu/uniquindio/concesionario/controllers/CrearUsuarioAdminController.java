package co.edu.uniquindio.concesionario.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.CrearAdministrativoException;
import co.edu.uniquindio.concesionario.model.Cargo;
import co.edu.uniquindio.concesionario.model.Concesionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearUsuarioAdminController implements Initializable{

	private LoginController loginController;
	private Concesionario miConcesionario;
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
		Cargo cargo = Cargo.valueOf(comboCargo.getSelectionModel().getSelectedItem().toString());
		try {
			String mensaje = miConcesionario.crearAdministrativo(inputNombres.getText(), inputApellidos.getText(), inputIdentificacion.getText(), miConcesionario, inputUsuario.getText(), inputContrasenia.getText(), inputCorreo.getText(), inputRespuestaSeguridad.getText(), cargo);
			JOptionPane.showMessageDialog(null, mensaje);
			inputNombres.setText(null);
			inputApellidos.setText(null);
			inputIdentificacion.setText(null);
			inputUsuario.setText(null);
			inputContrasenia.setText(null);
			inputCorreo.setText(null);
			inputRespuestaSeguridad.setText(null);
		} catch (CrearAdministrativoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
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

	public void init(Concesionario miConcesionario, Stage stage, LoginController loginController) {
		// TODO Auto-generated method stub
		this.loginController = loginController;
		this.stage = stage;
		this.miConcesionario = miConcesionario;
	}

}
