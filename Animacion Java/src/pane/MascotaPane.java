package pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import acciones.AccionBotones;
import acciones.Animaciones;
import alimentos.*;
import proyectosegundoparcialsilvaavila.Mascota;
import users.User;
import users.Usuarios;
import globales.Constantes;
import javafx.scene.control.ComboBox;
import archivos.ManejoArchivos;
import static java.lang.Math.toIntExact;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import reloj.Tiempo;

public class MascotaPane {
    public static Label alimentacion, animo, dinero, limpieza, vida;
    public static Button alimentar, jugar, bañar, curar;
    public static ImageView mascota;
    public static Mascota datosMascota;
    public static ComboBox cbComida;
    BorderPane root;
    VBox estados;
    HBox acciones;
    Pane paneMascota;
    User user; 
    HBox comidas; 
    Label lblAlimentar;
    
    
    public MascotaPane() throws IOException{
        inicializarJugador();
        iniciarControles();
        organizarControles();
        difTiempo();
        Tiempo.actDatos();
        Tiempo.lanzarAccionesTiempo();
    }
    
    void iniciarControles(){
        comidas = new HBox();
        cbComida = new ComboBox();
        lblAlimentar = new Label("Comidas");
        
        datosMascota=user.getMascota();
        root = new BorderPane();
        estados = new VBox();
        acciones = new HBox();
        alimentacion = new Label("Alimentación: "+datosMascota.getAlimentacion());
        animo = new Label("Ánimo: "+datosMascota.getAnimo());
        dinero = new Label("Dinero: $"+datosMascota.getDinero());
        limpieza = new Label("Limpieza: "+datosMascota.getLimpieza());
        vida = new Label("Vida: "+Integer.toString(datosMascota.getVida().getTiempo()));
        root.setAlignment(vida,Pos.CENTER);
        alimentar = new Button("Alimentar");
        jugar = new Button("Jugar");
        bañar = new Button("Bañar");
        curar = new Button("Curar");
        mascota = new ImageView();
        mascota.setImage(new Image(Constantes.RUTA_IMAGEN_POU));
        mascota.setFitHeight(100);
        mascota.setFitWidth(100);
        mascota.setX(100);
        mascota.setY(200);
        paneMascota = new Pane();
        
        alimentacion.setFont(new Font("Arial", 30));
        animo.setFont(new Font("Arial", 30));
        dinero.setFont(new Font("Arial", 30));
        limpieza.setFont(new Font("Arial", 30));
        alimentar.setFont(Font.font("Arial",FontWeight.BOLD, 25));
        jugar.setFont(Font.font("Arial",FontWeight.BOLD, 25));
        bañar.setFont(Font.font("Arial",FontWeight.BOLD, 25));
        curar.setFont(Font.font("Arial",FontWeight.BOLD, 25));
        
        alimentar.setStyle("-fx-background-image: url(imagenes/button.png);  -fx-background-position: center; "
                            +"-fx-background-size:"+ Integer.toString(10) +" "+ Integer.toString(10) + ";");
        bañar.setStyle("-fx-background-image: url(imagenes/button.png);  -fx-background-position: center; "
                            +"-fx-background-size:"+ Integer.toString(10) +" "+ Integer.toString(10) + ";");
        jugar.setStyle("-fx-background-image: url(imagenes/button.png);  -fx-background-position: center; "
                            +"-fx-background-size:"+ Integer.toString(10) +" "+ Integer.toString(10) + ";");
        curar.setStyle("-fx-background-image: url(imagenes/button.png);  -fx-background-position: center; "
                            +"-fx-background-size:"+ Integer.toString(10) +" "+ Integer.toString(10) + ";");
        
        alimentacion.setStyle("-fx-background-image: url(imagenes/label.png);"
                +"-fx-background-position: center; ");
        animo.setStyle("-fx-background-image: url(imagenes/label.png);  "
                + "-fx-background-position: center; ");
        dinero.setStyle("-fx-background-image: url(imagenes/label.png);  "
                + "-fx-background-position: center; ");
        limpieza.setStyle("-fx-background-image: url(imagenes/label.png);  "
                + "-fx-background-position: center; ");
        vida.setStyle("-fx-background-image: url(imagenes/label.png);  "
                + "-fx-background-position: center; ");
        lblAlimentar.setStyle("-fx-background-image: url(imagenes/label.png);  "
                + "-fx-background-position: center; ");
        
        alimentacion.setStyle("-fx-background-image: url(imagenes/label.png);  -fx-background-position: center; ");
        animo.setStyle("-fx-background-image: url(imagenes/label.png);  -fx-background-position: center; ");
        dinero.setStyle("-fx-background-image: url(imagenes/label.png);  -fx-background-position: center; ");
        limpieza.setStyle("-fx-background-image: url(imagenes/label.png);  -fx-background-position: center; ");
        vida.setStyle("-fx-background-image: url(imagenes/label.png);  -fx-background-position: center; ");
        lblAlimentar.setStyle("-fx-background-image: url(imagenes/label.png);  -fx-background-position: center; ");
        
        /**
         * Se define el metodo para la accion de cada uno de los botones.
         */
        jugar.setOnAction(e -> {
            try {
                AccionBotones.ManejarBotones(e);
            } catch (IOException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        alimentar.setOnAction(e -> {
            try {
                AccionBotones.ManejarBotones(e);
            } catch (IOException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        bañar.setOnAction(e -> {
            try {
                AccionBotones.ManejarBotones(e);
            } catch (IOException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        curar.setOnAction(e -> {
            try {
                AccionBotones.ManejarBotones(e);
            } catch (IOException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MascotaPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Animaciones.AnimacionMascota();
    }
    
    void organizarControles(){
        paneMascota.getChildren().add(mascota);
        acciones.getChildren().addAll(alimentar, jugar, bañar, curar);
        acciones.setSpacing(8);
        estados.getChildren().addAll(alimentacion, animo, dinero, limpieza);
        estados.setSpacing(8);
        root.setCenter(paneMascota);
        root.setLeft(estados);
        root.setBottom(acciones);
        root.setTop(vida);
        cbComida.getItems().addAll(new Cookie("Cookie",1,10).getNombre(),
                new Lasagna("Lasagna",5,75).getNombre(),
                new Pizza("Pizza",3,20).getNombre(),
                new RoastedChicken("RoastedChicken",10,100).getNombre());
        comidas.getChildren().addAll(lblAlimentar, cbComida);
        comidas.setSpacing(8);
        root.setRight(comidas);
        
        root.setStyle("-fx-background-image: url('/imagenes/jaula.jpg'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size:"+ Constantes.TAMANO_PANE_MASCOTA +" "+ Constantes.TAMANO_PANE_MASCOTA + ";"
        );
    }
    
    void difTiempo(){
        try{
            LocalDateTime temporal=datosMascota.tempSalida;
            LocalDateTime tempEntrada = LocalDateTime.now();
            LocalDateTime tempDateTime = LocalDateTime.from(temporal);
            long hours = tempDateTime.until(tempEntrada, ChronoUnit.HOURS);
            datosMascota.restarVida(toIntExact(hours));
            
            long minutes = tempDateTime.until(tempEntrada,ChronoUnit.MINUTES);
            datosMascota.restarAlimentacion(toIntExact(minutes));
            datosMascota.restarAnimo(toIntExact(minutes));
            datosMascota.restarLimpieza(toIntExact(minutes));
        }catch(NullPointerException e){
            
        }
    }
    
    
    /**
 * Metodos necesarios para poder iniciar el juego
 * con el jugador deseado.
 */
    public void inicializarJugador(){
        user=buscarJugador(IngresarPane.jugador.trim());
        if(user==null){
            user=new User(IngresarPane.jugador.trim());
            Usuarios.usuarios.add(user);
            ManejoArchivos.serializar();
        }
    }
    
    public User buscarJugador(String a){
        for (User i : Usuarios.usuarios){
            if (i.getNombre().equals(a)){
                System.out.println("usuario encontrado");
                return i;
            }
        }
        return null;
    }

    public BorderPane getRoot() {
        return root;
    }
}