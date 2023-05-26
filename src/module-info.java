module ConcesionarioUQ {
	requires javafx.controls;
	requires java.desktop;
	requires mail;
	requires java.logging;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires junit;
	requires org.junit.jupiter.api;
	
	opens co.edu.uniquindio.concesionario.model to javafx.base;
	opens co.edu.uniquindio.concesionario.controllers to javafx.fxml;
	opens co.edu.uniquindio.concesionario.application to javafx.graphics, javafx.fxml;
}
