package co.edu.uniquindio.concesionario.serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.concesionario.model.Concesionario;

public class Serializacion {

	/**
	 * Metodo para guardar la informacion del concesionario en archivos
	 * @param miConcesionario
	 */
	public static void serializar(Concesionario miConcesionario) {
		try {
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("C:/ArchivosConcesionario/Concesionario.dat"));
			escribiendo_fichero.writeObject(miConcesionario);
			escribiendo_fichero.close();
		}
		catch(Exception e) {
		}
	}
	
	/**
	 * metodo para deserializar la informacion guardad en archivos del concesionario
	 * @return
	 */
	public static Concesionario deserializar() {
		Concesionario miConcesionario = null;
		try {
			ObjectInputStream recuperando_ficheroConcesionario = new ObjectInputStream(new FileInputStream("C:/ArchivosConcesionario/Concesionario.dat"));
			miConcesionario = (Concesionario) recuperando_ficheroConcesionario.readObject();
			recuperando_ficheroConcesionario.close();														
		} 
		catch (Exception e) {
			
		}
		return miConcesionario;
	}
}
