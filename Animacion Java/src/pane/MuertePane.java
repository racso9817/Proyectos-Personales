package pane;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MuertePane {
    private BorderPane root;
    private Label lblMuerte;
    private Button aceptar;
    private VBox opciones;
    
    public MuertePane(){
        inicializarPaneles();
        organizarPaneles();
    }
    
    void inicializarPaneles(){
        root = new BorderPane();
        opciones = new VBox();
        lblMuerte = new Label("Su Mascota ha muerto");
        aceptar = new Button("Aceptar");
        
        aceptar.setOnAction(e -> {
            matarConBoton(e);
        });
    }
    
    void organizarPaneles(){
        opciones.getChildren().addAll(lblMuerte,aceptar);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(8);
        root.setCenter(opciones);
    }
    
    void matarConBoton(Event e){
        Platform.exit();
    }

    public BorderPane getRoot() {
        return root;
    }
    
    
}
