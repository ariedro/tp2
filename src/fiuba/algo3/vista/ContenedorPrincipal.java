package fiuba.algo3.vista;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.vista.eventos.BotonComprarPropiedadHandler;
import fiuba.algo3.vista.eventos.BotonFinalizarTurnoHandler;
import fiuba.algo3.vista.eventos.BotonPagarFianzaHandler;
import fiuba.algo3.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.vista.eventos.BotonVenderPropiedadHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage, AlgoPoly algoPoly) {
        
    	this.setMenu(stage);
        this.setCentro();
        this.setConsola();
        this.setBotonera(algoPoly);
        
    }

    private void setBotonera(AlgoPoly algoPoly) {
    	
    	Button botonDados = new Button();
        botonDados.setText("Tirar Dados");
        BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(algoPoly);
        botonDados.setOnAction(tirarDadosHandler);

    	Button botonComprar = new Button();
        botonComprar.setText("Comprar Propiedad");
        BotonComprarPropiedadHandler comprarPropiedadHandler = new BotonComprarPropiedadHandler(algoPoly);
        botonComprar.setOnAction(comprarPropiedadHandler);

    	Button botonVender = new Button();
        botonVender.setText("Vender Propiedad");
        BotonVenderPropiedadHandler venderPropiedadHandler = new BotonVenderPropiedadHandler(algoPoly);
        botonVender.setOnAction(venderPropiedadHandler);
       
        Button botonPagarFianza = new Button();
        botonPagarFianza.setText("Pagar Fianza");
        BotonPagarFianzaHandler pagarFianzaHandler = new BotonPagarFianzaHandler(algoPoly);
        botonPagarFianza.setOnAction(pagarFianzaHandler);
        
        
        Button botonFinalizarTurno = new Button();
        botonFinalizarTurno.setText("Finalizar Turno");
        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(algoPoly);
        botonFinalizarTurno.setOnAction(finalizarTurnoHandler);
        
        VBox contenedorVertical = new VBox(botonDados, botonComprar, botonVender,botonPagarFianza, botonFinalizarTurno);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
        
    }

    private void setMenu(Stage stage) {
        
    	this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
    	
    	canvasCentral = new Canvas(460, 220);

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/fiuba/algo3/vista/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    		
    }

    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}
