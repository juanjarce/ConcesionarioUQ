package co.edu.uniquindio.concesionario.controllers;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.concesionario.model.Administrativo;
import co.edu.uniquindio.concesionario.model.Alquiler;
import co.edu.uniquindio.concesionario.model.Compra;
import co.edu.uniquindio.concesionario.model.Transaccion;
import co.edu.uniquindio.concesionario.model.Venta;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaRegistroDeTransacciones extends JFrame {

	private JPanel contentPane;
	private JTable tableReporte;
	private DefaultTableModel model;
	private Administrativo miAdministrativo;
	private String fechaInicio;
	private String fechaFinal;


	/**
	 * Create the frame.
	 */
	public TablaRegistroDeTransacciones(String fechaInicio, String fechaFinal) {
	
		this.miAdministrativo = ModelFactoryController.getInstance().getMiAdministrativo();
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		
		setTitle("TABLA REGISTRO DE TRANSACCIONES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 595, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		generarPanelMedio();
		
	}
	public void generarPanelMedio()
	{
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1,1));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		{
			tableReporte = new JTable();
			model = new DefaultTableModel();
			tableReporte.setModel(model);
			
			model.addColumn("Tipo Transaccion");
			model.addColumn("Consecutivo");
			model.addColumn("Total");
			model.addColumn("Fecha de Transaccion");
			model.addColumn("Empleado");
			model.addColumn("Cliente");
			model.addColumn("Vehiculo");
			model.addColumn("Fecha de inicio");
			model.addColumn("Fecha de entrega");
			
			scrollPane.setViewportView(tableReporte);
		}
		llenarTabla();
	}
	
	public void llenarTabla()
	{
		List<Transaccion> listaTransaccionesEntreFechas = miAdministrativo.obtenerTransaccionesEntreFechas(fechaInicio, fechaFinal);
		
		for(Transaccion transaccion : listaTransaccionesEntreFechas) {
			try {
				Compra compra = (Compra) transaccion;
				Object[] fila = new Object[9];
				fila[0]="COMPRA";
				fila[1]=compra.getConsecutivoCompra();
				fila[2]=compra.getTotal();
				fila[3]=compra.getFecha();
				fila[4]=compra.getEmpleadoTransaccion().getIdentificacion();
				fila[5]=compra.getClienteTransaccion().getIdentificacion();
				fila[6]=compra.getVehiculo().getCodigo();
				
				model.addRow(fila);
			}
			catch(Exception e) {
				
			}
			try {
				Venta venta = (Venta) transaccion;
				Object[] fila = new Object[9];
				fila[0]="VENTA";
				fila[1]=venta.getConsecutivoVenta();
				fila[2]=venta.getTotal();
				fila[3]=venta.getFecha();
				fila[4]=venta.getEmpleadoTransaccion().getIdentificacion();
				fila[5]=venta.getClienteTransaccion().getIdentificacion();
				fila[6]=venta.getVehiculo().getCodigo();
				
				model.addRow(fila);
			}
			catch(Exception e) {
				
			}
			try {
				Alquiler alquiler = (Alquiler) transaccion;
				Object[] fila = new Object[9];
				fila[0]="ALQUILER";
				fila[1]=alquiler.getConsecutivoAlquiler();
				fila[2]=alquiler.getTotal();
				fila[3]=alquiler.getFecha();
				fila[4]=alquiler.getEmpleadoTransaccion().getIdentificacion();
				fila[5]=alquiler.getClienteTransaccion().getIdentificacion();
				fila[6]=alquiler.getVehiculo().getCodigo();
				fila[7]=alquiler.getFechaInicio();
				fila[8]=alquiler.getFechaFinal();
				
				model.addRow(fila);
			}
			catch(Exception e) {
				
			}
		}
	}
}
