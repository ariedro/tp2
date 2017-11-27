package fiuba.algo3.vista.eventos;


import java.io.File;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianzaException;
import fiuba.algo3.excepciones.JugadorYaTiroDadosException;
import fiuba.algo3.vista.VistaDados;
import fiuba.algo3.vista.VistaInfoJugadores;
import fiuba.algo3.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	private final VistaTablero vistaTablero;
	private final VistaDados vistaDados;
	private final VistaInfoJugadores vistaInfoJugadores;
	private final Button botonFinTurno;
	private final Button botonVender;
	
	public BotonTirarDadosHandler(VistaTablero unaVistaTablero, VistaDados unaVistaDados, VistaInfoJugadores unaVistaInfoJugadores, AlgoPoly juego, Button unBotonFinTurno, Button botonVender) {
		this.algoPoly = juego;
		this.vistaTablero = unaVistaTablero;
		this.vistaDados = unaVistaDados;
		this.vistaInfoJugadores = unaVistaInfoJugadores;
		this.botonFinTurno = unBotonFinTurno;
		this.botonVender = botonVender;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = this.algoPoly.getJugadorActual();
		try {
			this.algoPoly.turnar(jugadorActual);	
			// Hay que cambiar aca para que aparezca en otra ruta el archivo dados. 
			String musicFile = "dados.mp3";     
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		} catch(JugadorYaTiroDadosException e){
			tirarAlertaQueYaTiroDados();
		}
		this.vistaTablero.update();
		this.vistaDados.update();
		this.vistaInfoJugadores.update();
		this.botonFinTurno.setDisable(false);
		this.botonVender.setDisable(true);
	}
	
	public void tirarAlertaQueYaTiroDados() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Jugada ilegal");
        String mensaje = "Ya tiraste los dados";
        alert.setContentText(mensaje);
        
        alert.show();
	}
	
}






