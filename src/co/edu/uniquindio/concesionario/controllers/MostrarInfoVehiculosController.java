package co.edu.uniquindio.concesionario.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionario.model.Bus;
import co.edu.uniquindio.concesionario.model.Camion;
import co.edu.uniquindio.concesionario.model.Camioneta;
import co.edu.uniquindio.concesionario.model.CategoriaVehiculo;
import co.edu.uniquindio.concesionario.model.Deportivo;
import co.edu.uniquindio.concesionario.model.PickUp;
import co.edu.uniquindio.concesionario.model.Sedan;
import co.edu.uniquindio.concesionario.model.TipoVehiculo;
import co.edu.uniquindio.concesionario.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MostrarInfoVehiculosController {

	private RegistroVehiculosController registroVehiculosController;
	private Stage stage;
	private Vehiculo vehiculo;
	
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
    private TextField inputCodigo;

    @FXML
    private TextField inputModelo;

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
    private TextField inputNumeroBolsasAire;

    @FXML
    private TextField inputAutonomia;

    @FXML
    private TextField inputTiempoCarga;

    @FXML
    private TextField inputCapacidadCarga;

    @FXML
    private TextField inputNumeroEjes;

    @FXML
    private TextField inputNumeroSalidasEmergencia;

    @FXML
    private TextField inputCapacidadCajaCargas;

    @FXML
    private TextField inputCaballosFuerza;

    @FXML
    private TextField inputSegundos100;

    @FXML
    private TextField inputMarca;

    @FXML
    private TextField inputCondicion;

    @FXML
    private TextField inputTransmision;

    @FXML
    private TextField inputAire;

    @FXML
    private TextField inputCamaraReversa;

    @FXML
    private TextField inputVelocidadCrucero;

    @FXML
    private TextField inputAbs;

    @FXML
    private TextField inputTipoVehiculo;

    @FXML
    private TextField inputCategoriaVehiculo;

    @FXML
    private TextField inputEnchufable;

    @FXML
    private TextField inputTipoHibrido;

    @FXML
    private TextField inputSensorColision;

    @FXML
    private TextField inputSensorTraficoCruzado;

    @FXML
    private TextField inputPermanenciaCarril;

    @FXML
    private TextField input4x4;

    @FXML
    private Label frenosAireLabel;

    @FXML
    private Label tipoCamionLabel;

    @FXML
    private TextField inputFrenosAire;

    @FXML
    private TextField inputTipoCamion;

    @FXML
    void mostrarInformacion(ActionEvent event) {
    	inputCodigo.setText(vehiculo.getCodigo()); inputCondicion.setText(vehiculo.getCondicion()); inputModelo.setText(vehiculo.getModelo().toString());
    	inputTransmision.setText(vehiculo.getTransmicion()); inputVelocidadMaxima.setText(vehiculo.getVelocidadMaxima()+""+"km/h"); inputCilindraje.setText(vehiculo.getCilindraje()+" "+"cm^3"); inputNumeroPasajeros.setText(vehiculo.getNumeroPasajeros().toString());
    	inputNumeroPuertas.setText(vehiculo.getNumeroPuertas().toString()); inputCapacidadMaletero.setText(vehiculo.getCapacidadMaletero()+" "+"kg"); inputAire.setText(String.valueOf(vehiculo.isAireAcondicionado())); inputCamaraReversa.setText(String.valueOf(vehiculo.isCamaraReversa())); 
    	inputVelocidadCrucero.setText(String.valueOf(vehiculo.isVelocidadCrucero())); inputNumeroBolsasAire.setText(vehiculo.getNumeroBolsasDeAire().toString()); inputAbs.setText(String.valueOf(vehiculo.isABS())); inputMarca.setText(vehiculo.getMarca());
    	inputTipoVehiculo.setText(vehiculo.getTipoVehiculo().toString()); inputCategoriaVehiculo.setText(vehiculo.getCategoriaVehiculo().toString());
    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false);
    	enchufableLabel.setVisible(false); inputEnchufable.setVisible(false); tipoHibridoLabel.setVisible(false); inputTipoHibrido.setVisible(false);
    	if(vehiculo.getTipoVehiculo().equals(TipoVehiculo.ELECTRICO)) {
    		autonomiaLabel.setVisible(true); inputAutonomia.setVisible(true); tiempoCargaLabel.setVisible(true); inputTiempoCarga.setVisible(true);
    		inputAutonomia.setText(vehiculo.getElectrico_autonomia()+" "+"km"); inputTiempoCarga.setText(vehiculo.getElectrico_tiempoCarga()+" "+"horas");
    	}
    	if(vehiculo.getTipoVehiculo().equals(TipoVehiculo.HIBRIDO)) {
    		enchufableLabel.setVisible(true); inputEnchufable.setVisible(true); tipoHibridoLabel.setVisible(true); inputTipoHibrido.setVisible(true);
    		inputEnchufable.setText(String.valueOf(vehiculo.isHibrido_isEnchufable())); inputTipoHibrido.setText(vehiculo.getTipoHibrido()); 
    	}
    	capacidadCargaLabel.setVisible(false); inputCapacidadCarga.setVisible(false); numeroEjesLabel.setVisible(false); inputNumeroEjes.setVisible(false); numeroSalidasEmergenciaLabel.setVisible(false); inputNumeroSalidasEmergencia.setVisible(false); sensorColisionLabel.setVisible(false); inputSensorColision.setVisible(false);
    	sensorTraficoCruzadoLabel.setVisible(false); inputSensorTraficoCruzado.setVisible(false); permanenciaCarrilLabel.setVisible(false); inputPermanenciaCarril.setVisible(false); is4x4Label.setVisible(false); input4x4.setVisible(false); capacidadCajaCargasLabel.setVisible(false); inputCapacidadCajaCargas.setVisible(false);
    	caballosFuerzaLabel.setVisible(false); inputCaballosFuerza.setVisible(false); segundos100Label.setVisible(false); inputSegundos100.setVisible(false); frenosAireLabel.setVisible(false); inputFrenosAire.setVisible(false); tipoCamionLabel.setVisible(false); inputTipoCamion.setVisible(false);
    	if(vehiculo.getCategoriaVehiculo().equals(CategoriaVehiculo.BUS)) {
    		Bus bus = (Bus) vehiculo;
    		 numeroEjesLabel.setVisible(true); inputNumeroEjes.setVisible(true); numeroSalidasEmergenciaLabel.setVisible(true); inputNumeroSalidasEmergencia.setVisible(true);
    		 inputNumeroEjes.setText(bus.getNumeroEjes().toString()); inputNumeroSalidasEmergencia.setText(bus.getNumeroSalidasEmergencia().toString());
    	}
    	if(vehiculo.getCategoriaVehiculo().equals(CategoriaVehiculo.CAMION)) {
    		Camion camion = (Camion) vehiculo;
    		capacidadCargaLabel.setVisible(true); inputCapacidadCarga.setVisible(true); numeroEjesLabel.setVisible(true); inputNumeroEjes.setVisible(true); numeroSalidasEmergenciaLabel.setVisible(true); inputNumeroSalidasEmergencia.setVisible(true); frenosAireLabel.setVisible(true); inputFrenosAire.setVisible(true); tipoCamionLabel.setVisible(true); inputTipoCamion.setVisible(true);
    		inputCapacidadCarga.setText(camion.getCapacidadCarga().toString()+" "+"kg"); inputNumeroEjes.setText(camion.getNumeroEjes().toString()); inputNumeroSalidasEmergencia.setText(camion.getNumeroSalidasEmergencia().toString()); inputFrenosAire.setText(camion.getFrenosAire().toString()); inputTipoCamion.setText(camion.getTipoCamion().toString());
    	}
    	if(vehiculo.getCategoriaVehiculo().equals(CategoriaVehiculo.SEDAN)) {
    		Sedan sedan = (Sedan) vehiculo;
    		sensorColisionLabel.setVisible(true); inputSensorColision.setVisible(true);sensorTraficoCruzadoLabel.setVisible(true); inputSensorTraficoCruzado.setVisible(true); permanenciaCarrilLabel.setVisible(true); inputPermanenciaCarril.setVisible(true);
    		inputSensorColision.setText(String.valueOf(sedan.isSensorColision())); inputSensorTraficoCruzado.setText(String.valueOf(sedan.isSensorTraficoCruzado())); inputPermanenciaCarril.setText(String.valueOf(sedan.isPermanenciaCarril()));
    	}
    	if(vehiculo.getCategoriaVehiculo().equals(CategoriaVehiculo.CAMIONETA)) {
    		Camioneta camioneta = (Camioneta) vehiculo;
    		sensorColisionLabel.setVisible(true); inputSensorColision.setVisible(true);sensorTraficoCruzadoLabel.setVisible(true); inputSensorTraficoCruzado.setVisible(true); permanenciaCarrilLabel.setVisible(true); inputPermanenciaCarril.setVisible(true); is4x4Label.setVisible(true); input4x4.setVisible(true);
    		inputSensorColision.setText(String.valueOf(camioneta.isSensorColision())); inputSensorTraficoCruzado.setText(String.valueOf(camioneta.isSensorTraficoCruzado())); inputPermanenciaCarril.setText(String.valueOf(camioneta.isPermanenciaCarril())); input4x4.setText(String.valueOf(camioneta.isIs4x4()));
    	}
    	if(vehiculo.getCategoriaVehiculo().equals(CategoriaVehiculo.PICKUP)) {
    		PickUp pickUp = (PickUp) vehiculo;
    		is4x4Label.setVisible(true); input4x4.setVisible(true); capacidadCajaCargasLabel.setVisible(true); inputCapacidadCajaCargas.setVisible(true);
    		input4x4.setText(String.valueOf(pickUp.isIs4x4())); inputCapacidadCajaCargas.setText(pickUp.getCapacidadCajaDeCargas()+" "+"kg");
    	}
    	if(vehiculo.getCategoriaVehiculo().equals(CategoriaVehiculo.DEPORTIVO)) {
    		Deportivo deportivo = (Deportivo) vehiculo;
    		caballosFuerzaLabel.setVisible(true); inputCaballosFuerza.setVisible(true); segundos100Label.setVisible(true); inputSegundos100.setVisible(true);
    		inputCaballosFuerza.setText(deportivo.getNumeroCaballosDeFuerza().toString()); inputSegundos100.setText(deportivo.getSegundosAlcanza100().toString()+" "+"segundos");
    	}
    }

    @FXML
    void mostrarImagenes(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/ImagenesVehiculos.fxml"));
    	Parent root = loader.load();
    	ImagenesVehiculosController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	controller.init(stage, this);
    	stage.show();
    	this.stage.close();
    }
    
    @FXML
    void volverButton(ActionEvent event) {
    	registroVehiculosController.show();
    	stage.close();
    }

	public void init(Stage stage, RegistroVehiculosController registroVehiculosController) {
		// TODO Auto-generated method stub
		this.registroVehiculosController = registroVehiculosController;
		this.stage = stage;
		this.vehiculo = ModelFactoryController.getInstance().getVehiculo();
	}

	public void show() {
		stage.show();
	}

}
