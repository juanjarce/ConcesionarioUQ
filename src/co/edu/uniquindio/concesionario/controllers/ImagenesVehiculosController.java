package co.edu.uniquindio.concesionario.controllers;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ImagenesVehiculosController {

	private MostrarInfoVehiculosController mostrarInfoVehiculosController;
	private Stage stage;
	private ArrayList<String> listaImagenesVehiculo = new ArrayList<String>();
	private Integer posRecorrida=0;
 
    @FXML
    private ImageView imageView;

    @FXML
    void aniadirImagen(ActionEvent event) {

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
				listaImagenesVehiculo.add(imageURL);
				ModelFactoryController.getInstance().setListaImagenes(listaImagenesVehiculo);
				
				//Se informa de la imagen añadida
				mostrarMensaje("Mensaje Informativo", "Imagen añadida al vehiculo", "La imagen fue añadida exitosamente", AlertType.INFORMATION);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}

    }

    @FXML
    void desplazarDerecha(ActionEvent event) {

    	if(posRecorrida<(listaImagenesVehiculo.size()-1)){
    		
    		//Se setea la primera imagen del vehiculo
    		posRecorrida++;
			String imageURL = listaImagenesVehiculo.get(posRecorrida);
			Image imgLoad = new Image(imageURL);
			imageView.setImage(imgLoad);

    	}
    	
    }

    @FXML
    void desplazarIzquierda(ActionEvent event) {

    	if(posRecorrida>0){
    		
    		//Se setea la primera imagen del vehiculo
    		posRecorrida--;
			String imageURL = listaImagenesVehiculo.get(posRecorrida);
			Image imgLoad = new Image(imageURL);
			imageView.setImage(imgLoad);

    	}

    }

    @FXML
    void eliminarImagen(ActionEvent event) {

    	if(listaImagenesVehiculo.size()==1) {
    		mostrarMensaje("Mensaje Informativo", "Error eliminando imagen", "La imagen no se puede elminar porque el vehiculo cuenta con una unica imagen", AlertType.WARNING);
    	}
    	else {
    		listaImagenesVehiculo.remove(listaImagenesVehiculo.get(posRecorrida));
        	ModelFactoryController.getInstance().setListaImagenes(listaImagenesVehiculo);
        	
        	//Se informa de la imagen eliminada
			mostrarMensaje("Mensaje Informativo", "Imagen eliminada del vehiculo", "La imagen fue eliminada exitosamente", AlertType.INFORMATION);
        	
        	//Se vuelve a la imagen inicial
        	posRecorrida = 0;
        	
        	String imageURL = listaImagenesVehiculo.get(0);
			Image imgLoad = new Image(imageURL);
			imageView.setImage(imgLoad);
    	}
    	
    }

    @FXML
    void volverButton(ActionEvent event) {
    	mostrarInfoVehiculosController.show();
    	stage.close();

    }
 
	public void init(Stage stage, MostrarInfoVehiculosController mostrarInfoVehiculosController) {
		this.mostrarInfoVehiculosController = mostrarInfoVehiculosController;
		this.stage = stage;
		this.listaImagenesVehiculo.addAll(ModelFactoryController.getInstance().getListaImagenes());
        this.posRecorrida = 0;
    	
    	//Se setea la primera imagen del vehiculo
		String imageURL = listaImagenesVehiculo.get(0);
		Image imgLoad = new Image(imageURL);
		imageView.setImage(imgLoad);
		
	}
    
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}
    
}

