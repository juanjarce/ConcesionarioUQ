package co.edu.uniquindio.concesionario.controllers;

import java.awt.HeadlessException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.CrearClienteException;
import co.edu.uniquindio.concesionario.exceptions.ClienteNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Cliente;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegistroClientesController implements Initializable{

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private VentanaPrincipalEmpleadoController ventanaPrincipalEmpleadoController;
	private Stage stage;
	private Empleado miEmpleado;
    private ObservableList<Cliente> listaClientesData;
    private Cliente clienteSeleccionado;

    @FXML
    private TextField inputNombres;

    @FXML
    private TextField inputApellidos;

    @FXML
    private TextField inputIdentificacion;
    
    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TableColumn<Cliente, String> columnNombres;

    @FXML
    private TableColumn<Cliente, String> columnApellidos;

    @FXML
    private TableColumn<Cliente, String> columnIdentificacion;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnVolver;

    @FXML
    void actualizarClienteEvent(ActionEvent event) {
    	if(this.clienteSeleccionado!=null) {
    		String nombres = inputNombres.getText();
    		String apellidos = inputApellidos.getText();
    		if(validarDatos(nombres, apellidos, this.clienteSeleccionado.getIdentificacion())) {
    			try {
    				String mensaje = miEmpleado.modificarCliente(nombres, apellidos, this.clienteSeleccionado.getIdentificacion());
    				mostrarMensaje("Mensaje Informativo", "Cliente Modificado", mensaje, AlertType.INFORMATION);
    				
    				this.clienteSeleccionado.setNombres(nombres);
    				this.clienteSeleccionado.setApellidos(apellidos);
    				
    				this.tableClientes.refresh();
    				
    		    	inputNombres.setText(null);
    		    	inputApellidos.setText(null);
    		    	inputIdentificacion.setText(null);
    		    	
    		    	this.clienteSeleccionado = null;

    				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    				//Se almacenan los datos en archivos
    				ModelFactoryController.getInstance().serializar();
    				//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    			} catch (HeadlessException | ClienteNoRegistradoException e1) {
    				mostrarMensaje("Mensaje Informativo", "Cliente No Registrado", e1.getMessage(), AlertType.WARNING);
    			}
    		}
    	}
    	else {
			mostrarMensaje("Información Cliente", "Cliente No Seleccionado", "No se ha seleccionado ningun cliente", AlertType.WARNING);
    	}
    }

    @FXML
    void agregarClienteEvent(ActionEvent event) {
    	String nombres = inputNombres.getText();
    	String apellidos = inputApellidos.getText();
    	String identificacion = inputIdentificacion.getText();
   	
    	if(validarDatos(nombres, apellidos, identificacion)) {
    		try {
    			String mensaje = miEmpleado.crearCliente(nombres, apellidos, identificacion);
    			mostrarMensaje("Mensaje Informativo", "Cliente Registrado", mensaje, AlertType.INFORMATION);
    			
        		this.listaClientesData.add(miEmpleado.obtenerCliente(identificacion));
        		this.tableClientes.setItems(listaClientesData);

    			inputNombres.setText(null);
    			inputApellidos.setText(null);
    			inputIdentificacion.setText(null);
    			
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    		} catch (CrearClienteException e1) {
    			mostrarMensaje("Mensaje Informativo", "Error de registro de cliente", e1.getMessage(), AlertType.WARNING);
    		}
    	}
    }

    @FXML
    void buscarClienteEvent(ActionEvent event) {
		try {
			String mensaje = miEmpleado.devolverCliente(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del cliente:"));
			mostrarMensaje("Mensaje Informativo", "Informacion del Cliente", mensaje, AlertType.INFORMATION);
		} catch (HeadlessException | ClienteNoRegistradoException e1) {
			mostrarMensaje("Mensaje Informativo", "Cliente No Registrado", e1.getMessage(), AlertType.WARNING);
		}
    }

    @FXML
    void eliminarClienteEvent(ActionEvent event) {
    	if(this.clienteSeleccionado!=null) {
    		try {
    			String mensaje = miEmpleado.eliminarCliente(this.clienteSeleccionado.getIdentificacion());
    			mostrarMensaje("Mensaje Informativo", "Cliente Eliminado", mensaje, AlertType.INFORMATION);
    			
        		this.listaClientesData.remove(this.clienteSeleccionado);
        		this.tableClientes.refresh();

    			inputNombres.setText(null);
    			inputApellidos.setText(null);
    			inputIdentificacion.setText(null);

    			this.clienteSeleccionado = null;
    			
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    		} catch (HeadlessException | ClienteNoRegistradoException e1) {
    			mostrarMensaje("Mensaje Informativo", "Cliente No Registrado", e1.getMessage(), AlertType.WARNING);
    		}
    	}
    	else {
			mostrarMensaje("Información Cliente", "Cliente No Seleccionado", "No se ha seleccionado ningun cliente", AlertType.WARNING);
    	}
    }

    @FXML
    void nuevoClienteEvent(ActionEvent event) {
    	inputNombres.setText(null);
    	inputApellidos.setText(null);
    	inputIdentificacion.setText(null);
    }

    @FXML
    void seleccionarClienteEvent(MouseEvent event) {
    	this.clienteSeleccionado = this.tableClientes.getSelectionModel().getSelectedItem();
    	
    	if(this.clienteSeleccionado!=null) {
    		inputNombres.setText(this.clienteSeleccionado.getNombres());
    		inputApellidos.setText(this.clienteSeleccionado.getApellidos());
    		inputIdentificacion.setText(this.clienteSeleccionado.getIdentificacion());
    	}
    }

    @FXML
    void volverEvent(ActionEvent event) {
    	if(ventanaPrincipalAdministrativoController != null) {
    		ventanaPrincipalAdministrativoController.show();
        	stage.close();
    	}
    	else {
    		ventanaPrincipalEmpleadoController.show();
    		stage.close();
    	}
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

	 public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle(titulo);
	    alert.setHeaderText(header);
	    alert.setContentText(contenido);
	    alert.showAndWait();
	}

	    private boolean validarDatos(String nombres, String apellidos, String identificacion) {
			String mensaje = "";

			if(nombres == null || nombres.equals(""))
				mensaje += "Los nombres es invalido \n";

			if(apellidos == null || apellidos.equals(""))
				mensaje += "Los apellidos son invalidos \n";

			if(identificacion == null || identificacion.equals(""))
				mensaje += "La identificacion es invalida \n";

			if(mensaje.equals("")){
				return true;
			}else{
				mostrarMensaje("Información Empleado", "Datos invalidos", mensaje, AlertType.WARNING);
				return false;
			}
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			listaClientesData = FXCollections.observableArrayList();
			
			this.columnNombres.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombres"));
			this.columnApellidos.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellidos"));
			this.columnIdentificacion.setCellValueFactory(new PropertyValueFactory<Cliente, String>("identificacion"));
			
			listaClientesData.addAll(ModelFactoryController.getInstance().obtenerListClientes());
			tableClientes.setItems(listaClientesData);
		}

}


