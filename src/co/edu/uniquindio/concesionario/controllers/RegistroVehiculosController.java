
package co.edu.uniquindio.concesionario.controllers;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.VehiculoRegistradoException;
import co.edu.uniquindio.concesionario.exceptions.VehiculoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.CategoriaVehiculo;
import co.edu.uniquindio.concesionario.model.Empleado;
import co.edu.uniquindio.concesionario.model.TipoCamion;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class RegistroVehiculosController implements Initializable{

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
	private Empleado miEmpleado;
	private ArrayList<String> imagenesVehiculo = new ArrayList<String>();
	
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
    private Label frenosAireLabel;

    @FXML
    private Label tipoCamionLabel;

    @FXML
    private ComboBox comboFrenosAire;

    @FXML
    private ComboBox comboTipoCamion;

    @FXML
    void agregarImagen(ActionEvent event) {
    	
    	//Se crea el dialogo para seleccionar los archivos
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
    			new ExtensionFilter("Archivo PNG", "*.png"),
		        new ExtensionFilter("Archivo JPG", "*.jpg"),
		        new ExtensionFilter("Archivo BMP", "*.bmp"),
		        new ExtensionFilter("Archivo GIF", "*.gif"));
		
		//Se abre el dialogo para seleccionar los archivos
		File file = fileChooser.showOpenDialog(null);
		
		//Se verifica que el archivo seleccionado sea una imagen
		if(file.isFile() && (file.getName().contains(".jpg") || file.getName().contains(".png") ||
				file.getName().contains(".bmp") || file.getName().contains(".gif"))) {
			
			try {
				String imageURL = file.toURI().toURL().toString();
				
				//Se agrega la imagen a las imagenes del vehiculo
				imagenesVehiculo.add(imageURL);
				mostrarMensaje("Mensaje Informativo", "Imagenes del vehiculo", "Imagen agregada exitosamente", AlertType.INFORMATION);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		else {
			mostrarMensaje("Mensaje Informativo", "Imagenes del vehiculo", "El formato del archivo no es una imagen", AlertType.WARNING);
		}
		
   }

    @FXML
    void buscarVehiculo(ActionEvent event) throws IOException {
    	Vehiculo vehiculo = miEmpleado.obtenerVehiculo(JOptionPane.showInputDialog(null, "Ingrese el codigo del vehiculo que se va a consultar:"));
    	if(vehiculo != null) {
    		ModelFactoryController.getInstance().setVehiculo(vehiculo);
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/MostrarInfoVehiculos.fxml"));
        	Parent root = loader.load();
        	MostrarInfoVehiculosController controller = loader.getController();
        	Scene scene = new Scene(root);
        	Stage stage = new Stage();
        	stage.setScene(scene);
        	controller.init(stage, this);
        	stage.show();
        	this.stage.close();
    	}
    	else {
			mostrarMensaje("Mensaje Informativo", "Vehiculo No Registrado", "El vehiculo no se encuentra registrado", AlertType.WARNING);
    	}
    }

    @FXML
    void crearVehiculo(ActionEvent event) {
    	//Se verifica que se agregaron las fotos del vehiculo
    	if(imagenesVehiculo.size()!=0) {
    		
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
    				String mensaje = miEmpleado.crearBus(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
    						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
    						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.BUS, 
    						autonomia, tiempoCarga, enchufable, tipoHibrido, Integer.parseInt(inputNumeroEjes.getText()), Integer.parseInt(inputNumeroSalidasEmergencia.getText()));
       				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
    				
    				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    				//Se actualiza la informacion del registro del vehiculo
    				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
    				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
    				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
    				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
    				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
    		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
    		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
    		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
    		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
    		    	numeroEjesLabel.setVisible(false); inputNumeroEjes.setVisible(false); inputNumeroEjes.setText(null);
    		    	numeroSalidasEmergenciaLabel.setVisible(false); inputNumeroSalidasEmergencia.setVisible(false); inputNumeroSalidasEmergencia.setText(null);
    		    	imagenesVehiculo.removeAll(imagenesVehiculo);
    		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    			} catch (NumberFormatException | VehiculoRegistradoException e) {
    				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
    			}
        	}
        	else {
            	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMION")) {
            		try {
        				String mensaje = miEmpleado.crearCamion(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
        						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
        						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.CAMION, 
        						autonomia, tiempoCarga, enchufable, tipoHibrido, Double.parseDouble(inputCapacidadCarga.getText()), Integer.parseInt(inputNumeroEjes.getText()), Integer.parseInt(inputNumeroSalidasEmergencia.getText()), Boolean.parseBoolean(comboFrenosAire.getSelectionModel().getSelectedItem().toString()), TipoCamion.valueOf(comboTipoCamion.getSelectionModel().getSelectedItem().toString()));
        				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
        				
        				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
        				//Se actualiza la informacion del registro del vehiculo
        				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
        				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
        				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
        				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
        				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
        		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
        		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
        		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
        		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
        		    	capacidadCargaLabel.setVisible(false); inputCapacidadCarga.setVisible(false); inputCapacidadCarga.setText(null);
        		    	numeroEjesLabel.setVisible(false); inputNumeroEjes.setVisible(false); inputNumeroEjes.setText(null);
        		    	numeroSalidasEmergenciaLabel.setVisible(false); inputNumeroSalidasEmergencia.setVisible(false); inputNumeroSalidasEmergencia.setText(null);
        		    	frenosAireLabel.setVisible(false); comboFrenosAire.setVisible(false); comboFrenosAire.getSelectionModel().clearSelection();
        		    	tipoCamionLabel.setVisible(false); comboTipoCamion.setVisible(false); comboTipoCamion.getSelectionModel().clearSelection();
        		    	imagenesVehiculo.removeAll(imagenesVehiculo);
        		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

        			} catch (NumberFormatException | VehiculoRegistradoException e) {
        				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
        			}
            	}
            	else {
                	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("SEDAN")) {
                		try {
            				String mensaje = miEmpleado.crearSedan(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
            						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
            						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.SEDAN, 
            						autonomia, tiempoCarga, enchufable, tipoHibrido, Boolean.parseBoolean(comboSensorColision.getSelectionModel().getSelectedItem().toString()),  Boolean.parseBoolean(comboSensorTraficoCruzado.getSelectionModel().getSelectedItem().toString()),  Boolean.parseBoolean(comboPermanenciaCarril.getSelectionModel().getSelectedItem().toString()));
            				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
            				
            				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
            				//Se actualiza la informacion del registro del vehiculo
            				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
            				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
            				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
            				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
            				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
            		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
            		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
            		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
            		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
            		    	sensorColisionLabel.setVisible(false); comboSensorColision.setVisible(false); comboSensorColision.getSelectionModel().clearSelection();
            		    	sensorTraficoCruzadoLabel.setVisible(false); comboSensorTraficoCruzado.setVisible(false); comboSensorTraficoCruzado.getSelectionModel().clearSelection();
            		    	permanenciaCarrilLabel.setVisible(false); comboPermanenciaCarril.setVisible(false); comboPermanenciaCarril.getSelectionModel().clearSelection();
            		    	imagenesVehiculo.removeAll(imagenesVehiculo);
            		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

            			} catch (NumberFormatException | VehiculoRegistradoException e) {
            				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
            			}
                	}
                	else {
                    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMIONETA")) {
                    		try {
                				String mensaje =miEmpleado.crearCamioneta(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
                						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
                						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.CAMIONETA, 
                						autonomia, tiempoCarga, enchufable, tipoHibrido, Boolean.parseBoolean(comboSensorColision.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboSensorTraficoCruzado.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboPermanenciaCarril.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(combo4x4.getSelectionModel().getSelectedItem().toString()));
                				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
                				
                				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
                				//Se actualiza la informacion del registro del vehiculo
                				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
                				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
                				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
                				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
                				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
                		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
                		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
                		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
                		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
                		    	sensorColisionLabel.setVisible(false); comboSensorColision.setVisible(false); comboSensorColision.getSelectionModel().clearSelection();
                		    	sensorTraficoCruzadoLabel.setVisible(false); comboSensorTraficoCruzado.setVisible(false); comboSensorTraficoCruzado.getSelectionModel().clearSelection();
                		    	permanenciaCarrilLabel.setVisible(false); comboPermanenciaCarril.setVisible(false); comboPermanenciaCarril.getSelectionModel().clearSelection();
                		    	is4x4Label.setVisible(false); combo4x4.setVisible(false); combo4x4.getSelectionModel().clearSelection();
                		    	imagenesVehiculo.removeAll(imagenesVehiculo);
                		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

                			} catch (NumberFormatException | VehiculoRegistradoException e) {
                				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
                			}
                    	}
                    	else {
                        	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("PICKUP")) {
                        		try {
                    				String mensaje = miEmpleado.crearPickUp(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
                    						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
                    						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.PICKUP, 
                    						autonomia, tiempoCarga, enchufable, tipoHibrido, Boolean.parseBoolean(combo4x4.getSelectionModel().getSelectedItem().toString()), Double.parseDouble(inputCapacidadCajaCargas.getText()));
                    				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
                    				
                    				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
                    				//Se actualiza la informacion del registro del vehiculo
                    				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
                    				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
                    				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
                    				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
                    				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
                    		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
                    		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
                    		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
                    		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
                    		    	is4x4Label.setVisible(false); combo4x4.setVisible(false); combo4x4.getSelectionModel().clearSelection();
                    		    	capacidadCajaCargasLabel.setVisible(false); inputCapacidadCajaCargas.setVisible(false); inputCapacidadCajaCargas.setText(null);
                    		    	imagenesVehiculo.removeAll(imagenesVehiculo);
                    		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

                    			} catch (NumberFormatException | VehiculoRegistradoException e) {
                    				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
                    			}
                        	}
                        	else {
                            	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("DEPORTIVO")) {
                            		try {
                        				String mensaje = miEmpleado.crearDeportivo(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
                        						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
                        						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.DEPORTIVO, 
                        						autonomia, tiempoCarga, enchufable, tipoHibrido, Double.parseDouble(inputCaballosFuerza.getText()), Integer.parseInt(inputSegundos100.getText()));
                        				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
                        				
                        				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
                        				//Se actualiza la informacion del registro del vehiculo
                        				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
                        				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
                        				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
                        				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
                        				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
                        		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
                        		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
                        		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
                        		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
                        		    	caballosFuerzaLabel.setVisible(false); inputCaballosFuerza.setVisible(false); inputCaballosFuerza.setText(null);
                        		    	segundos100Label.setVisible(false); inputSegundos100.setVisible(false); inputSegundos100.setText(null);
                        		    	imagenesVehiculo.removeAll(imagenesVehiculo);
                        		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

                        			} catch (NumberFormatException | VehiculoRegistradoException e) {
                        				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
                        			}
                            	}
                            	else {
                                	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("MOTO")) {
                                		try {
                            				String mensaje = miEmpleado.crearMoto(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
                            						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
                            						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.MOTO, 
                            						autonomia, tiempoCarga, enchufable, tipoHibrido);
                            				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
                            				
                            				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
                            				//Se actualiza la informacion del registro del vehiculo
                            				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
                            				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
                            				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
                            				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
                            				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
                            		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
                            		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
                            		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
                            		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
                            		    	imagenesVehiculo.removeAll(imagenesVehiculo);
                            		    	System.out.println(imagenesVehiculo);
                            		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

                            			} catch (NumberFormatException | VehiculoRegistradoException e) {
                            				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
                            			}
                                	}
                                	else {
                                    	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("VAN")) {
                                    		try {
                                				String mensaje = miEmpleado.crearVan(imagenesVehiculo, inputCodigo.getText(), inputMarca.getText(), comboCondicion.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(inputModelo.getText()), comboTransmicion.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(inputVelocidadMaxima.getText()),
                                						Double.parseDouble(inputCilindraje.getText()), Integer.parseInt(inputNumeroPasajeros.getText()), Integer.parseInt(inputNumeroPuertas.getText()), Double.parseDouble(inputCapacidadMaletero.getText()), Boolean.parseBoolean(comboAire.getSelectionModel().getSelectedItem().toString()), Boolean.parseBoolean(comboCamaraReversa.getSelectionModel().getSelectedItem().toString()), 
                                						Boolean.parseBoolean(comboVelocidadCrucero.getSelectionModel().getSelectedItem().toString()), Integer.parseInt(inputNumeroBolsasAire.getText()), Boolean.parseBoolean(comboAbs.getSelectionModel().getSelectedItem().toString()), TipoVehiculo.valueOf(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().toUpperCase()), CategoriaVehiculo.VAN, 
                                						autonomia, tiempoCarga, enchufable, tipoHibrido);
                                				mostrarMensaje("Mensaje Informativo", "Registro Vehiculo", mensaje, AlertType.INFORMATION);
                                				
                                				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
                                				//Se actualiza la informacion del registro del vehiculo
                                				inputCodigo.setText(null); comboCondicion.getSelectionModel().clearSelection(); inputModelo.setText(null); comboTransmicion.getSelectionModel().clearSelection(); 
                                				inputVelocidadMaxima.setText(null); inputCilindraje.setText(null); inputNumeroPasajeros.setText(null); inputNumeroPuertas.setText(null); 
                                				inputCapacidadMaletero.setText(null); comboAire.getSelectionModel().clearSelection(); comboCamaraReversa.getSelectionModel().clearSelection(); comboVelocidadCrucero.getSelectionModel().clearSelection(); 
                                				inputNumeroBolsasAire.setText(null); comboAbs.getSelectionModel().clearSelection(); inputMarca.setText(null);
                                				comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
                                 		    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
                                		    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
                                		    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
                                		    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
                                		    	imagenesVehiculo.removeAll(imagenesVehiculo);
                                		    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

                                			} catch (NumberFormatException | VehiculoRegistradoException e) {
                                				mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", e.getMessage(), AlertType.WARNING);
                                			}
                                    	}
                                	}
                            	}
                        	}
                    	}
                	}
            	}
        	}
    		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    		//Se almacenan los datos en archivos
        	ModelFactoryController.getInstance().serializar();
    		//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    	}
    	else{
    		mostrarMensaje("Mensaje Informativo", "Error Registro Vehiculo", "No se han agregado fotos del vehiculo", AlertType.WARNING);
    	}
    }

    @FXML
    void eliminarVehiculo(ActionEvent event) {
		try {
			String mensaje = miEmpleado.eliminarVehiculo(JOptionPane.showInputDialog(null, "Ingrese el codigo de registro del vehiculo:"));
			mostrarMensaje("Mensaje Informativo", "Eliminacion Vehiculo", mensaje, AlertType.INFORMATION);
			
			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Se almacenan los datos en archivos
			ModelFactoryController.getInstance().serializar();
			//--------------------------------------------------------------------------------------------------------------------------------------------------------------

			} 
		catch (HeadlessException | VehiculoNoRegistradoException e) {
			mostrarMensaje("Mensaje Informativo", "Error en eliminacion del vehiculo", e.getMessage(), AlertType.WARNING);
		}
    }

    @FXML
    void refrescarAtributosCategoriaVehiculo(ActionEvent event) {
    	try {
        	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("BUS")) {
        		numeroEjesLabel.setVisible(true); inputNumeroEjes.setVisible(true);
        		numeroSalidasEmergenciaLabel.setVisible(true); inputNumeroSalidasEmergencia.setVisible(true);
        	}
        	if(comboCategoriaVehiculo.getSelectionModel().getSelectedItem().toString().equals("CAMION")) {
        		capacidadCargaLabel.setVisible(true); inputCapacidadCarga.setVisible(true);
        		numeroEjesLabel.setVisible(true); inputNumeroEjes.setVisible(true);
        		numeroSalidasEmergenciaLabel.setVisible(true); inputNumeroSalidasEmergencia.setVisible(true);
        		frenosAireLabel.setVisible(true); comboFrenosAire.setVisible(true);
        		tipoCamionLabel.setVisible(true); comboTipoCamion.setVisible(true);
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
    	catch(Exception e) {
    		
    	}
    }

    @FXML
    void refrescarAtributosTipoVehiculo(ActionEvent event) {
    	try {
        	if(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().equals("ELECTRICO")) {
        		autonomiaLabel.setVisible(true); inputAutonomia.setVisible(true);
        		tiempoCargaLabel.setVisible(true); inputTiempoCarga.setVisible(true);
        	}
        	if(comboTipoVehiculo.getSelectionModel().getSelectedItem().toString().equals("HIBRIDO")) {
        		enchufableLabel.setVisible(true); comboEnchufable.setVisible(true);
        		tipoHibridoLabel.setVisible(true); comboTipoHibrido.setVisible(true);
        	}
    	}
    	catch(Exception e) {
    		
    	}
    }

    @FXML
    void refrescarButton(ActionEvent event) {
		comboTipoVehiculo.getSelectionModel().clearSelection(); comboCategoriaVehiculo.getSelectionModel().clearSelection();
    	autonomiaLabel.setVisible(false); inputAutonomia.setVisible(false); inputAutonomia.setText(null);
    	tiempoCargaLabel.setVisible(false); inputTiempoCarga.setVisible(false); inputTiempoCarga.setText(null);
    	enchufableLabel.setVisible(false); comboEnchufable.setVisible(false); comboEnchufable.getSelectionModel().clearSelection();
    	tipoHibridoLabel.setVisible(false); comboTipoHibrido.setVisible(false); comboTipoHibrido.getSelectionModel().clearSelection();
    	capacidadCargaLabel.setVisible(false); inputCapacidadCarga.setVisible(false); inputCapacidadCarga.setText(null);
    	numeroEjesLabel.setVisible(false); inputNumeroEjes.setVisible(false); inputNumeroEjes.setText(null);
    	numeroSalidasEmergenciaLabel.setVisible(false); inputNumeroSalidasEmergencia.setVisible(false); inputNumeroSalidasEmergencia.setText(null);
    	sensorColisionLabel.setVisible(false); comboSensorColision.setVisible(false); comboSensorColision.getSelectionModel().clearSelection();
    	sensorTraficoCruzadoLabel.setVisible(false); comboSensorTraficoCruzado.setVisible(false); comboSensorTraficoCruzado.getSelectionModel().clearSelection();
    	permanenciaCarrilLabel.setVisible(false); comboPermanenciaCarril.setVisible(false); comboPermanenciaCarril.getSelectionModel().clearSelection();
    	is4x4Label.setVisible(false); combo4x4.setVisible(false); combo4x4.getSelectionModel().clearSelection();
    	capacidadCajaCargasLabel.setVisible(false); inputCapacidadCajaCargas.setVisible(false); inputCapacidadCajaCargas.setText(null);
    	caballosFuerzaLabel.setVisible(false); inputCaballosFuerza.setVisible(false); inputCaballosFuerza.setText(null);
    	segundos100Label.setVisible(false); inputSegundos100.setVisible(false); inputSegundos100.setText(null);
    	frenosAireLabel.setVisible(false); comboFrenosAire.setVisible(false); comboFrenosAire.getSelectionModel().clearSelection();
    	tipoCamionLabel.setVisible(false); comboTipoCamion.setVisible(false); comboTipoCamion.getSelectionModel().clearSelection();
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

    @FXML
    void borrarSeleccionImagenes(ActionEvent event) {
    	imagenesVehiculo.removeAll(imagenesVehiculo);
    	JOptionPane.showMessageDialog(null, "Seleccion de imagenes borrado exitosamente");
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
    	comboFrenosAire.setItems(listBoleanos);
    	ObservableList<String> listTipoCamion= FXCollections.observableArrayList("TURBO", "SENCILLO", "DOBLETROQUE", "MANIMULA", "TRACTOMULA");
    	comboTipoCamion.setItems(listTipoCamion);
    	
    	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    	//Esconder los atributod adicionales del tipo y categoria del vehiculo
   
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
    	frenosAireLabel.setVisible(false); comboFrenosAire.setVisible(false);
    	tipoCamionLabel.setVisible(false); comboTipoCamion.setVisible(false);

       	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    }

	public void initDesdeAdmin(Stage stage, VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.ventanaPrincipalEmpleadoController = null;
		this.stage = stage;
		this.miEmpleado = ModelFactoryController.getInstance().getMiAdministrativo();
	}

	public void initDesdeEmpleado(Stage stage, VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = null;
		this.ventanaPrincipalEmpleadoController = ventanaPrincipalEmpleadoController;
		this.stage = stage;
		this.miEmpleado = ModelFactoryController.getInstance().getMiEmpleado();
	}

	public void show() {
		stage.show();
	}
	
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}
	
}
