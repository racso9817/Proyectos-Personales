package pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import acciones.*;

public class IngresarPane {
    /**
     * En esta clase es donde ocurre todo lo necesario para mostrar
     * la forma de ingreso al juego, donde se pide como inicia un nombre
     * de usuario.
     */   
    private HBox root;
    private Label lbl1;
    public static TextField txt1;
    public static Button ingresar;
    public static String jugador;
    
    public IngresarPane(){
        iniciarControles();
        organizarControles();
    }
    
    /**
     * iniciarControles() se encarga de definir cada uno de los objetos como
     * atributos de esta clase.
     */
    void iniciarControles(){
        root = new HBox();
        lbl1 = new Label("Ingrese usuario: ");
        txt1 = new TextField();
        ingresar = new Button("Ingresar");
        ingresar.setOnAction(e -> {
            try {
                jugador=txt1.getText().trim();
                AccionBotones.ManejarBotones(e);
            } catch (IOException ex) {
                Logger.getLogger(IngresarPane.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(IngresarPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });       
    }
    
    /**
     * organizarControles() se encarga de poner cada uno de los objetos de esta clase en su lugar;
     */
    void organizarControles(){
        root.getChildren().addAll(lbl1,txt1,ingresar);
        root.setSpacing(8);
    }

    public HBox getRoot() {
        return root;
    }   
}