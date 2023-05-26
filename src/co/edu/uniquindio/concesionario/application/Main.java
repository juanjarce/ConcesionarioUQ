package co.edu.uniquindio.concesionario.application;
	
import java.io.IOException;

import co.edu.uniquindio.concesionario.controllers.LoginController;
import co.edu.uniquindio.concesionario.controllers.ModelFactoryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
		
	@Override
	public void start(Stage primaryStage) throws IOException {	
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/Login.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		LoginController controller = loader.getController();
		controller.setStage(primaryStage);
		primaryStage.show();
		
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getListaEmpleados());
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getListaClientes());
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getListaVehiculos());
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getListaTransacciones());
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getConsecutivoAlquileres());
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getConsecutivoCompras());
		System.out.println(ModelFactoryController.getInstance().getMiConcesionario().getConsecutivoVentas());
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
