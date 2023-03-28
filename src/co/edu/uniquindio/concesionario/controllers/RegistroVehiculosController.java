
package co.edu.uniquindio.concesionario.controllers;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.VehiculoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.CategoriaVehiculo;
import co.edu.uniquindio.concesionario.model.Concesionario;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.TipoVehiculo;
import co.edu.uniquindio.concesionario.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroVehiculosController implements Initializable{

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
	private Concesionario miConcesionario;
	private Empleado miEmpleado;
	
    @FXML
    private Label autonomiaLabel;

    @FXML
    private Label tiempoCargaLabel;

    @FXML
    private Label enchufableLabel;

    @FXML
    private Label tipoHibridoLabel;

    @FXML
    private Label capacidadCargaLabel;

    @FXML
    private Label numeroEjesLabel;

    @FXML
    private Label numeroSalidasEmergenciaLabel;

    @FXML
    private Label sensorColisionLabel;

    @FXML
    private Label sensorTraficoCruzadoLabel;

    @FXML
    private Label permanenciaCarrilLabel;

    @FXML
    private Label is4x4Label;

    @FXML
    private Label capacidadCajaCargasLabel;

    @FXML
    private Label caballosFuerzaLabel;

    @FXML
    private Label segundos100Label;

    @FXML
    private TextField inputDireccionImagen;

    @FXML
    private TextField inputCodigo;

    @FXML
    private ComboBox comboCondicion;

    @FXML
    private TextField inputModelo;

    @FXML
    private ComboBox comboTransmicion;

    @FXML
    private TextField inputVelocidadMaxima;

    @FXML
    private TextField inputCilindraje;

    @FXML
    private TextField inputNumeroPasajeros;

    @FXML
    private TextField inputNumeroPuertas;

    @FXML
    private TextField inputCapacidadMaletero;

    @FXML
    private ComboBox comboAire;

    @FXML
    private ComboBox comboCamaraReversa;

    @FXML
    private ComboBox comboVelocidadCrucero;

    @FXML
    private TextField inputNumeroBolsasAire;

    @FXML
    private ComboBox comboTipoVehiculo;

    @FXML
    private ComboBox comboCategoriaVehiculo;

    @FXML
    private TextField inputAutonomia;

    @FXML
    private TextField inputTiempoCarga;

    @FXML
    private ComboBox comboEnchufable;

    @FXML
    private ComboBox comboTipoHibrido;

    @FXML
    private TextField inputCapacidadCarga;

    @FXML
    private TextField inputNumeroEjes;

    @FXML
    private TextField inputNumeroSalidasEmergencia;

    @FXML
    private ComboBox comboSensorColision;

    @FXML
    private ComboBox comboSensorTraficoCruzado;

    @FXML
    private ComboBox comboPermanenciaCarril;

    @FXML
    private ComboBox combo4x4;

    @FXML
    private TextField inputCapacidadCajaCargas;

    @FXML
    private TextField inputCaballosFuerza;

    @FXML
    private TextField inputSegundos100;

    @FXML
    private ComboBox comboAbs;

    @FXML
    private TextField inputMarca;

    @FXML
    void buscarVehiculo(ActionEvent event) throws IOException {
    	Vehiculo vehiculo = miEmpleado.obtenerVehiculo(JOptionPane.showInputDialog(null, "Ingrese el codigo del vehiculo que se va a consultar:"));
    	if(vehiculo != null) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/MostrarInfoVehiculos.fxml"));
        	Parent root = loader.load();
        	MostrarInfoVehiculosController controller = loader.getController();
        	Scene scene = new Scene(root);
        	Stage stage = new Stage();
        	stage.setScene(scene);
        	controller.init(vehiculo, stage, this);
        	stage.show();
        	this.stage.close();
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra registrado");
    	}
    }

    @FXML
    void crearVehiculo(ActionEvent event) {
    	int autonomia = 0;
		int tiempoCarga = 0;
		if(TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()).equals(TipoVehiculo.ELECTRICO)) {
			autonomia = Integer.parseInt(inputAutonomia.getText()); tiempoCarga = Integer.parseInt(inputTiempoCarga.getText());
		}
		boolean enchufable = false;
		String tipoHibrido = "NO APLICA";
		if(TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()).equals(TipoVehiculo.HIBRIDO)) {
			enchufable = Boolean.parseBoolean(comboEnchufable.getSelectionModel().getSelectedItem().toString()); tipoHibrido = comboTipoHibrido.getSelectionModel().getSelectedItem().toString();
		}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("BUS")) {
    		try {
				String mensaje = miEmpleado.crearBus(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.BUS, 
						autonomia, tiempoCarga, enchufable, tipoHibrido, Integer.parseInt(inputNumeroEjes.getText()), Integer.parseInt(inputNumeroSalidasEmergencia.getText()));
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMION")) {
    		try {
				String mensaje = miEmpleado.crearCamion(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.CAMION, 
						autonomia, tiempoCarga, enchufable, tipoHibrido, Double.parseDouble(inputCapacidadCarga.getText()), Integer.parseInt(inputNumeroEjes.getText()), Integer.parseInt(inputNumeroSalidasEmergencia.getText()));
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("SEDAN")) {
    		try {
				String mensaje = miEmpleado.crearSedan(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.SEDAN, 
						autonomia, tiempoCarga, enchufable, tipoHibrido, Boolean.parseBoolean(comboSensorColision.getSelectionModel().getSelectedItem().toString()),  Boolean.parseBoolean(comboSensorTraficoCruzado.getSelectionModel().getSelectedItem().toString()),  Boolean.parseBoolean(comboPermanenciaCarril.getSelectionModel().getSelectedItem().toString()));
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMIONETA")) {
    		try {
				String mensaje =miEmpleado.crearCamioneta(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.CAMIONETA, 
						autonomia, tiempoCarga, enchufable, tipoHibrido, Boolean.parseBoolean(comboSensorColision.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboSensorTraficoCruzado.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboPermanenciaCarril.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(combo4x4.getSelectionModel().getSelectedItem().toString()));
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("PICKUP")) {
    		try {
				String mensaje = miEmpleado.crearPickUp(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.PICKUP, 
						autonomia, tiempoCarga, enchufable, tipoHibrido, Boolean.parseBoolean(combo4x4.getSelectionModel().getSelectedItem().toString()), Double.parseDouble(inputCapacidadCajaCargas.getText()));
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("DEPORTIVO")) {
    		try {
				String mensaje = miEmpleado.crearDeportivo(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.DEPORTIVO, 
						autonomia, tiempoCarga, enchufable, tipoHibrido, Double.parseDouble(inputCaballosFuerza.getText()), Integer.parseInt(inputSegundos100.getText()));
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("MOTO")) {
    		try {
				String mensaje = miEmpleado.crearMoto(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.MOTO, 
						autonomia, tiempoCarga, enchufable, tipoHibrido);
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("VAN")) {
    		try {
				String mensaje = miEmpleado.crearVan(inputDireccionImagen.getText(), inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), inputVelocidadMaxima.getText(),
						inputCilindraje.getText(), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.VAN, 
						autonomia, tiempoCarga, enchufable, tipoHibrido);
				JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException | VehiculoRegistradoException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    }

    @FXML
    void eliminarVehiculo(ActionEvent event) {
		try {
			String mensaje = miEmpleado.eliminarVehiculo(JOptionPane.showInputDialog(null, "Ingrese el codigo de registro del vehiculo:"));
			JOptionPane.showMessageDialog(null, mensaje);		
			} 
		catch (HeadlessException | VehiculoNoRegistradoException e) {
			// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    @FXML
    void refrescarAtributosCategoriaVehiculo(ActionEvent event) {
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("BUS")) {
    		numeroEjesLabel.setVisible(true); inputNumeroEjes.setVisible(true);
    		numeroSalidasEmergenciaLabel.setVisible(true); inputNumeroSalidasEmergencia.setVisible(true);
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMION")) {
    		capacidadCargaLabel.setVisible(true); inputCapacidadCarga.setVisible(true);
    		numeroEjesLabel.setVisible(true); inputNumeroEjes.setVisible(true);
    		numeroSalidasEmergenciaLabel.setVisible(true); inputNumeroSalidasEmergencia.setVisible(true);
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("SEDAN")) {
    		sensorColisionLabel.setVisible(true); comboSensorColision.setVisible(true);
    		sensorTraficoCruzadoLabel.setVisible(true); comboSensorTraficoCruzado.setVisible(true);
    		permanenciaCarrilLabel.setVisible(true); comboPermanenciaCarril.setVisible(true);
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMIONETA")) {
    		sensorColisionLabel.setVisible(true); comboSensorColision.setVisible(true);
    		sensorTraficoCruzadoLabel.setVisible(true); comboSensorTraficoCruzado.setVisible(true);
    		permanenciaCarrilLabel.setVisible(true); comboPermanenciaCarril.setVisible(true);
    		is4x4Label.setVisible(true); combo4x4.setVisible(true);
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("PICKUP")) {
    		is4x4Label.setVisible(true); combo4x4.setVisible(true);
    		capacidadCajaCargasLabel.setVisible(true); inputCapacidadCajaCargas.setVisible(true);
    	}
    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("DEPORTIVO")) {
    		caballosFuerzaLabel.setVisible(true); inputCaballosFuerza.setVisible(true);
    		segundos100Label.setVisible(true); inputSegundos100.setVisible(true);
    	}
    }

    @FXML
    void refrescarAtributosTipoVehiculo(ActionEvent event) {
    	if(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().equals("ELECTRICO")) {
    		autonomiaLabel.setVisible(true); inputAutonomia.setVisible(true);
    		tiempoCargaLabel.setVisible(true); inputTiempoCarga.setVisible(true);
    	}
    	if(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().equals("HIBRIDO")) {
    		enchufableLabel.setVisible(true); comboEnchufable.setVisible(true);
    		tipoHibridoLabel.setVisible(true); comboTipoHibrido.setVisible(true);
    	}
    }

    @FXML
    void refrescarButton(ActionEvent event) {
    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false);
    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false);
    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false);
    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false);
    	capacidadCargaLabel.setVisible(false); inputCapacidadCarga.setVisible(false);
    	numeroEjesLabel.setVisible(false); inputNumeroEjes.setVisible(false);
    	numeroSalidasEmergenciaLabel.setVisible(false); inputNumeroSalidasEmergencia.setVisible(false);
    	sensorColisionLabel.setVisible(false); comboSensorColision.setVisible(false);
    	sensorTraficoCruzadoLabel.setVisible(false); comboSensorTraficoCruzado.setVisible(false);
    	permanenciaCarrilLabel.setVisible(false); comboPermanenciaCarril.setVisible(false);
    	is4x4Label.setVisible(false); combo4x4.setVisible(false);
    	capacidadCajaCargasLabel.setVisible(false); inputCapacidadCajaCargas.setVisible(false);
    	caballosFuerzaLabel.setVisible(false); inputCaballosFuerza.setVisible(false);
    	segundos100Label.setVisible(false); inputSegundos100.setVisible(false);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	ObservableList<String> listCondicion = FXCollections.observableArrayList("NUEVO", "USADO");
    	comboCondicion.setItems(listCondicion);
    	ObservableList<String> listTransmision = FXCollections.observableArrayList("MANUAL", "AUTOMATICA");
    	comboTransmicion.setItems(listTransmision);
    	ObservableList<String> listBoleanos= FXCollections.observableArrayList("true", "false");
    	comboAire.setItems(listBoleanos);
    	comboCamaraReversa.setItems(listBoleanos);
    	comboVelocidadCrucero.setItems(listBoleanos);
    	comboAbs.setItems(listBoleanos);
    	ObservableList<String> listTipoVehiculos= FXCollections.observableArrayList("GASOLINA", "DIESEL", "ELECTRICO", "HIBRIDO");
    	comboTipoVehiculo.setItems(listTipoVehiculos);
    	ObservableList<String> listCategoriaVehiculos= FXCollections.observableArrayList("MOTO", "SEDAN", "DEPORTIVO", "CAMIONETA", "PICKUP", "VAN", "BUS", "CAMION");
    	comboCategoriaVehiculo.setItems(listCategoriaVehiculos);
    	comboEnchufable.setItems(listBoleanos);
    	ObservableList<String> listTipoHibridos= FXCollections.observableArrayList("LIGERO", "PESADO");
    	comboTipoHibrido.setItems(listTipoHibridos);
    	comboSensorColision.setItems(listBoleanos);
    	comboSensorTraficoCruzado.setItems(listBoleanos);
    	comboPermanenciaCarril.setItems(listBoleanos);
    	combo4x4.setItems(listBoleanos);
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

	public void show() {
		stage.show();
	}
}
