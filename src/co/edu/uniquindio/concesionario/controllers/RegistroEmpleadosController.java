package co.edu.uniquindio.concesionario.controllers;

import java.awt.HeadlessException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.concesionario.exceptions.CrearEmpleadoException;
import co.edu.uniquindio.concesionario.exceptions.EmpleadoNoRegistradoException;
import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegistroEmpleadosController implements Initializable{

	private VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController;
	private Stage stage;
	private Administrativo miAdministrativo;
    private ObservableList<Empleado> listaEmpleadosData;
    private Empleado empleadoSeleccionado;

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
    private TextField inputUsuario;

    @FXML
    private PasswordField inputContrasenia;

    @FXML
    private TextField inputCorreo;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCambiarEstado;

    @FXML
    private Button btnActualizarCorreo;

    @FXML
    private TextField inputRespuestaSeguridad;

    @FXML
    private TableView<Empleado> tableEmpleados;

    @FXML
    private TableColumn<Empleado, String> columnNombres;

    @FXML
    private TableColumn<Empleado, String> columnApellidos;

    @FXML
    private TableColumn<Empleado, String> columnIdentificacion;

    @FXML
    private TableColumn<Empleado, String> columnCorreo;

    @FXML
    private TableColumn<Empleado, String> columnUsuario;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnVolver;

    @FXML
    void actualizarCorreoEmpleadoEvent(ActionEvent event) {
    	if(this.empleadoSeleccionado!=null) {
        	try {
    			String mensaje = miAdministrativo.actualizarCorreoEmpleado(this.empleadoSeleccionado.getIdentificacion(), inputCorreo.getText());
    			mostrarMensaje("Mensaje Informativo", "Actualización del correo electronico", mensaje, AlertType.INFORMATION);
    			
				this.empleadoSeleccionado.setCorreo(inputCorreo.getText());
				this.tableEmpleados.refresh();

    			inputNombres.setText(null);
    			inputApellidos.setText(null);
    			inputIdentificacion.setText(null);
    			inputUsuario.setText(null);
    			inputContrasenia.setText(null);
    			inputCorreo.setText(null);
    			inputRespuestaSeguridad.setText(null);
    			
    			this.empleadoSeleccionado = null;

    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    		} catch (HeadlessException | EmpleadoNoRegistradoException e) {
    			mostrarMensaje("Mensaje Informativo", "Error de Empleado", e.getMessage(), AlertType.WARNING);
    		}
    	}
    	else {
			mostrarMensaje("Información Empleado", "Empleado No Seleccionado", "No se ha seleccionado ningun empleado", AlertType.WARNING);
    	}
    }

    @FXML
    void actualizarEmpleadoEvent(ActionEvent event) {
    	if(this.empleadoSeleccionado!=null) {
    		String nombres = inputNombres.getText();
    		String apellidos = inputApellidos.getText();
    		if(validarDatos(nombres, apellidos, this.empleadoSeleccionado.getIdentificacion(), "usuario", "contrasenia", "correo", "respuestaSeguridad")) {
    			try {
    				String mensaje = miAdministrativo.modificarEmpleado(nombres, apellidos, this.empleadoSeleccionado.getIdentificacion(), ModelFactoryController.getInstance().getMiConcesionario());
    				mostrarMensaje("Mensaje Informativo", "Informacion del Empleado Modificada", mensaje, AlertType.INFORMATION);
    				
    				this.empleadoSeleccionado.setNombres(nombres);
    				this.empleadoSeleccionado.setApellidos(apellidos);
    				
    				this.tableEmpleados.refresh();
      
        			inputNombres.setText(null);
        			inputApellidos.setText(null);
        			inputIdentificacion.setText(null);
        			inputUsuario.setText(null);
        			inputContrasenia.setText(null);
        			inputCorreo.setText(null);
        			inputRespuestaSeguridad.setText(null);
        			
        			this.empleadoSeleccionado = null;

    				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    				//Se almacenan los datos en archivos
    				ModelFactoryController.getInstance().serializar();
    				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    				
    			} catch (HeadlessException | EmpleadoNoRegistradoException e1) {
    				mostrarMensaje("Mensaje Informativo", "Error de Modificacion", e1.getMessage(), AlertType.WARNING);
    			}
  		    }
    	}
    	else {
			mostrarMensaje("Información Empleado", "Empleado No Seleccionado", "No se ha seleccionado ningun empleado", AlertType.WARNING);
    	}
    }

    @FXML
    void agregarEmpleadoEvent(ActionEvent event) {
    	String nombres = inputNombres.getText();
    	String apellidos = inputApellidos.getText();
    	String identificacion = inputIdentificacion.getText();
    	String usuario = inputUsuario.getText();
    	String contrasenia = inputContrasenia.getText();
    	String correo = inputCorreo.getText();
    	String respuestaSeguridad = inputRespuestaSeguridad.getText();
    	
    	if(validarDatos(nombres, apellidos, identificacion, usuario, contrasenia, correo, respuestaSeguridad)) {
        	try {
    			String mensaje = miAdministrativo.crearEmpleado(nombres, apellidos, identificacion, usuario, contrasenia, correo, respuestaSeguridad);
    			mostrarMensaje("Mensaje Informativo", "Registro de Empleado", mensaje, AlertType.INFORMATION);
    			
        		this.listaEmpleadosData.add(ModelFactoryController.getInstance().obtenerEmpleado(identificacion));
        		this.tableEmpleados.setItems(listaEmpleadosData);

    			inputNombres.setText(null);
    			inputApellidos.setText(null);
    			inputIdentificacion.setText(null);
    			inputUsuario.setText(null);
    			inputContrasenia.setText(null);
    			inputCorreo.setText(null);
    			inputRespuestaSeguridad.setText(null);
    			
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			
    		} catch (CrearEmpleadoException e1) {
    			mostrarMensaje("Mensaje Informativo", "Error creando el empleado", e1.getMessage(), AlertType.WARNING);
    		}
    	}
    }

    @FXML
    void buscarEmpleadoEvent(ActionEvent event) {
		Empleado empleado = ModelFactoryController.getInstance().obtenerEmpleado(JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del empleado:"));
		if(empleado != null) {
			inputNombres.setText(empleado.getNombres());
			inputApellidos.setText(empleado.getApellidos());
			inputIdentificacion.setText(empleado.getIdentificacion());
			inputUsuario.setText(empleado.getUsuario());
			inputContrasenia.setText(empleado.getContrasenia());
			inputCorreo.setText(empleado.getCorreo());
			inputRespuestaSeguridad.setText("La respuesta a la pregunta de seguridad es privada");
		}
		else {
			mostrarMensaje("Mensaje Informativo", "Error de Empleado", "El empleado no se encuentra registrado", AlertType.WARNING);
		}
    }

    @FXML
    void cambiarEstadoEmpleadoEvent(ActionEvent event) {
    	if(this.empleadoSeleccionado!=null) {
    		try {
    			String mensaje = miAdministrativo.cambiarEstadoEmpleado(this.empleadoSeleccionado.getIdentificacion());
    			mostrarMensaje("Mensaje Informativo", "Cambiar Estado de Empleado", mensaje, AlertType.INFORMATION);

				this.empleadoSeleccionado.setEstado(ModelFactoryController.getInstance().obtenerEmpleado(this.empleadoSeleccionado.getIdentificacion()).getEstado());
				this.tableEmpleados.refresh();

    			inputNombres.setText(null);
    			inputApellidos.setText(null);
    			inputIdentificacion.setText(null);
    			inputUsuario.setText(null);
    			inputContrasenia.setText(null);
    			inputCorreo.setText(null);
    			inputRespuestaSeguridad.setText(null);
    			
    			this.empleadoSeleccionado = null;

    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			
    		} catch (HeadlessException | EmpleadoNoRegistradoException e1) {
    			mostrarMensaje("Mensaje Informativo", "Error de Empleado", e1.getMessage(), AlertType.WARNING);
    		}
    	}
    	else {
			mostrarMensaje("Información Empleado", "Empleado No Seleccionado", "No se ha seleccionado ningun empleado", AlertType.WARNING);
    	}
    }

    @FXML
    void eliminarEmpleadoEvent(ActionEvent event) {
    	if(this.empleadoSeleccionado!=null) {
    		try {
    			String mensaje = miAdministrativo.eliminarEmpleado(this.empleadoSeleccionado.getIdentificacion());
    			mostrarMensaje("Mensaje Informativo", "Empleado Eliminado", mensaje, AlertType.INFORMATION);

        		this.listaEmpleadosData.remove(this.empleadoSeleccionado);
        		this.tableEmpleados.refresh();
        		
    			inputNombres.setText(null);
    			inputApellidos.setText(null);
    			inputIdentificacion.setText(null);
    			inputUsuario.setText(null);
    			inputContrasenia.setText(null);
    			inputCorreo.setText(null);
    			inputRespuestaSeguridad.setText(null);
    			
    			this.empleadoSeleccionado = null;

    			//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//Se almacenan los datos en archivos
    			ModelFactoryController.getInstance().serializar();
    			//---------------------------------------------------------------------------------------------------------------------------------------------------------------
    			
    		} catch (HeadlessException | EmpleadoNoRegistradoException e1) {
    			mostrarMensaje("Mensaje Informativo", "Error de eliminacion", e1.getMessage(), AlertType.WARNING);
    		}
    	}
    	else {
			mostrarMensaje("Información Empleado", "Empleado No Seleccionado", "No se ha seleccionado ningun empleado", AlertType.WARNING);
    	}
    }

    @FXML
    void nuevoEmpleadoEvent(ActionEvent event) {
		inputNombres.setText(null);
		inputApellidos.setText(null);
		inputIdentificacion.setText(null);
		inputUsuario.setText(null);
		inputContrasenia.setText(null);
		inputCorreo.setText(null);
		inputRespuestaSeguridad.setText(null);
    }

    @FXML
    void seleccionarEmpleadoEvent(MouseEvent event) {
    	this.empleadoSeleccionado = this.tableEmpleados.getSelectionModel().getSelectedItem();
    	
    	if(this.empleadoSeleccionado!=null) {
			inputNombres.setText(empleadoSeleccionado.getNombres());
			inputApellidos.setText(empleadoSeleccionado.getApellidos());
			inputIdentificacion.setText(empleadoSeleccionado.getIdentificacion());
			inputUsuario.setText(empleadoSeleccionado.getUsuario());
			inputContrasenia.setText(empleadoSeleccionado.getContrasenia());
			inputCorreo.setText(empleadoSeleccionado.getCorreo());
			inputRespuestaSeguridad.setText("La respuesta a la pregunta de seguridad es privada");
    	}
    }

    @FXML
    void volverEvent(ActionEvent event) {
    	ventanaPrincipalAdministrativoController.show();
    	stage.close();
    }

	public void init(Stage stage, VentanaPrincipalAdministrativoController ventanaPrincipalAdministrativoController) {
		// TODO Auto-generated method stub
		this.ventanaPrincipalAdministrativoController = ventanaPrincipalAdministrativoController;
		this.stage = stage;
		this.miAdministrativo = ModelFactoryController.getInstance().getMiAdministrativo();
	}

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaEmpleadosData = FXCollections.observableArrayList();
		
		this.columnNombres.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombres"));
		this.columnApellidos.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellidos"));
		this.columnIdentificacion.setCellValueFactory(new PropertyValueFactory<Empleado, String>("identificacion"));
		this.columnCorreo.setCellValueFactory(new PropertyValueFactory<Empleado, String>("correo"));
		this.columnUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("usuario"));

		
		listaEmpleadosData.addAll(ModelFactoryController.getInstance().obtenerListaEmpleados());
		tableEmpleados.setItems(listaEmpleadosData);
	}

    private boolean validarDatos(String nombre, String apellidos, String identificacion, String usuario, String contrasenia, String correo, String respuestaSeguridad) {
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

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información Empleado", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}

	}

}

