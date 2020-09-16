package jueguitopou;

import acciones.AccionBotones;
import archivos.ManejoArchivos;
import globales.Constantes;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import pane.MascotaPane;
import proyectosegundoparcialsilvaavila.*;

/**
 * Clase principal del juego donde se organizan los elementos y
 * la lógica para acumular los puntos y las colisiones
 * @author Oscar
 */
        
public class PaneCofres {
    private Pane paneJuego;
    private Pou pou;
    private Label lbl, txt, txt2;
    String a,b;
    Random rand = new Random();
    int contador = 0;
    static int num;
    Flecha flecha;
    
    public PaneCofres(){
        paneJuego = new Pane();
        pou = new Pou();
        txt = new Label();
        txt2 = new Label("");
        lbl = new Label("Score:  ");
        paneJuego.setStyle("-fx-background-image: url('/imagenes/tesoro.jpg'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: 1040 1000");
        
        txt2.setStyle("-fx-font: 30 arial;"
                + "-fx-background-image: url(imagenes/label.png);"
                +"-fx-background-position: center;");
        lbl.setStyle("-fx-font: 30 arial;"
                + "-fx-background-image: url(imagenes/label.png);"
                +"-fx-background-position: center;");
        txt.setStyle("-fx-font: 20 arial;"
                + "-fx-background-image: url(imagenes/label.png);"
                +"-fx-background-position: center;");
        agregarPane();
        ubicarElementos();
        manejarEvento();
        Thread t = new Thread (new EjecutorAnimacion());
        t.start();
    }
    
    void agregarPane(){
        paneJuego.getChildren().addAll(pou.getImagenPou(),txt,txt2,lbl);
    }
    
    void ubicarElementos(){
        pou.getImagenPou().setLayoutX(500);
        pou.getImagenPou().setLayoutY(900);
        txt.setLayoutX(0);
        txt.setLayoutY(500);
        txt2.setLayoutX(100);
        txt2.setLayoutY(600);
        lbl.setLayoutX(0);
        lbl.setLayoutY(600);
    }
    
    void manejarEvento(){
        paneJuego.setOnKeyPressed(e -> moverObjeto(e));
        paneJuego.setOnMouseClicked(e -> lanzarFlechas(e));
    }
    
    public void lanzarFlechas(MouseEvent e){
        flecha = new Flecha();
        paneJuego.getChildren().add(flecha.getRec());
        flecha.animacion(pou.getImagenPou().getLayoutX());
    }
    
    public void moverObjeto(KeyEvent e){    
        if (e.getCode().equals(KeyCode.RIGHT)){
            pou.getImagenPou().setLayoutX(pou.getImagenPou().getLayoutX()+5);
        }
        else if (e.getCode().equals(KeyCode.LEFT)){
            pou.getImagenPou().setLayoutX(pou.getImagenPou().getLayoutX()-5);
        }
    }
    
    /**
     * Método donde se crean nuevos cofres y además se revisa si existe una colisión entre la flecha y un cofre
     */
    
    void crearCofres(){
        Cofres d = new Cofres();
        
        paneJuego.getChildren().addAll(d.getRec());
        Timeline tColis = new Timeline();
        KeyFrame kfhora = new KeyFrame(Duration.millis(50),e->{
            try {
                checkCollision(d.getRec(), flecha.getRec(), tColis);
            } catch (IOException ex) {
                Logger.getLogger(PaneCofres.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (NullPointerException ex){
            }
        });
        tColis.getKeyFrames().addAll(kfhora);
        tColis.setCycleCount(Timeline.INDEFINITE);
        tColis.setOnFinished(ev->paneJuego.getChildren().remove(flecha.getRec()));
        tColis.play();
    }
    
    public Pane getPaneJuego(){
        return paneJuego;
    }
    
    /**
     * Método para calcular el puntaje obtenido durante el juego
     * @throws IOException 
     */
    
    void puntajeCalc() throws IOException{
        num = rand.nextInt(6);     
        txt.setText(AccionBotones.list.get(num));
        
        if(AccionBotones.list.get(num).equals("MonedaPositiva")){
            int pos = rand.nextInt(10);
            a = Integer.toString(pos);
            txt.setText(a);
            contador += pos;
        }
        else if(AccionBotones.list.get(num).equals("MonedaNegativa")){
            int neg = rand.nextInt(1);
            b = Integer.toString(neg);
            txt.setText(b);
            contador -= neg;
        }
       else if (AccionBotones.list.get(num).equals("X2")){
           contador = contador*2;
       }
       else if (AccionBotones.list.get(num).equals("X3")){
           contador = contador*3;
       }
       else if (AccionBotones.list.get(num).equals("X5")){
           contador = contador*5;
       }
       else if (AccionBotones.list.get(num).equals("BOMBA")){
           MascotaPane.datosMascota.aumentarDinero(contador);
           MascotaPane.datosMascota.aumentarAnimo(3);
           ManejoArchivos.serializar();
           ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.close();
           Scene scene5 = new Scene(new MascotaPane().getRoot(),Constantes.TAMANO_PANE_MASCOTA,Constantes.TAMANO_PANE_MASCOTA);
           ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.setScene(scene5);
           ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.show();
       }
       txt2.setText(Integer.toString(contador));
    }
    
    public static int getNum(){
        return num;
    }
    
    /**
     * Clase para uso de threads para crear varios cofres
     */
    
    class EjecutorAnimacion implements Runnable{
        
        @Override
        public void run() {
            int i;
            for (i = 0; i < 4; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PaneCofres.class.getName()).log(Level.SEVERE, null, ex);
                }
                Platform.runLater(() -> crearCofres());
            }
        }
    }
    
    public void checkCollision(Rectangle a, Rectangle b, Timeline tiempo) throws IOException{
        if(a.getBoundsInParent().intersects(b.getBoundsInParent())){
            paneJuego.getChildren().remove(a);
            crearCofres();
            tiempo.stop();
            puntajeCalc();
        }
    }
}
