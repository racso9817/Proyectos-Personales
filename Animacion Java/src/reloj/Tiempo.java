package reloj;

import enfermedadades.Enfermedad;
import archivos.ManejoArchivos;
import globales.Constantes;
import java.io.Serializable;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.util.Duration;
import pane.MascotaPane;
import static pane.MascotaPane.datosMascota;
import pane.MuertePane;
import proyectosegundoparcialsilvaavila.ProyectoSegundoParcialSilvaAvila;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Tiempo implements Serializable{
    public int tiempo;
    public static Timeline vida,t1,t2,t4,t5,t6;
    static Random ran = new Random();
    public static Enfermedad presEnf;
    
    public Tiempo(){
        this.tiempo=Constantes.MAX_TIEMPO_VIDA;
    }
    
    public int getTiempo() {
        return tiempo;
    }
    
    public void manejarTiempo(){
        vida = new Timeline();
        KeyFrame kfhora = new KeyFrame(Duration.hours(Constantes.TIEMPO_DISMINUCION),e->controlVida());
        vida.getKeyFrames().addAll(kfhora);
        vida.setCycleCount(Timeline.INDEFINITE);
        vida.play();
    }
    
    void controlVida(){
        MascotaPane.datosMascota.getVida().tiempo-=1;
    }
    
    public static void actDatos(){
        t1 = new Timeline();
        KeyFrame kfhora = new KeyFrame(Duration.millis(1),e->updateLabels());
        t1.getKeyFrames().addAll(kfhora);
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.play();
    }
    
    static void updateLabels(){
        MascotaPane.vida.setText("Vida: "+Integer.toString(datosMascota.getVida().getTiempo()));
        MascotaPane.dinero.setText("Dinero: $"+datosMascota.getDinero());
        MascotaPane.animo.setText("Animo: "+datosMascota.getAnimo());
        MascotaPane.limpieza.setText("Limpieza: "+datosMascota.getLimpieza());
        MascotaPane.alimentacion.setText("Alimentacion: "+datosMascota.getAlimentacion());
    }
    
    public static void acabarJuego(){
        t2 = new Timeline();
        KeyFrame kfhora = new KeyFrame(Duration.millis(1),e->matarMascota());
        t2.getKeyFrames().addAll(kfhora);
        t2.setCycleCount(Timeline.INDEFINITE);
        t2.play();
    }
    
    static void matarMascota(){
        if(datosMascota.getVida().getTiempo() == 0){
            vida.stop();
            t2.stop();
            ManejoArchivos.serializar();
            Scene scene3 = new Scene(new MuertePane().getRoot(),300,300);
            ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.setScene(scene3);
        }
    }
    
    public static void disminuirVida(){
        t4 = new Timeline();
        KeyFrame kfhora = new KeyFrame(Duration.minutes(1),e->quitarEstados());
        t4.getKeyFrames().addAll(kfhora);
        t4.setCycleCount(Timeline.INDEFINITE);
        t4.play();
    }
    
    
    static void quitarEstados(){
        datosMascota.restarAlimentacion(1);
        datosMascota.restarAnimo(1);
        datosMascota.restarLimpieza(1);
    }
    
    public static KeyFrame randomSuciedad(){
        int num = ran.nextInt(5)+1;
        KeyFrame kmin = new KeyFrame(Duration.minutes(num),e->ensuciarPou());
        return kmin;
    }
    
    static void crearTlRand(){
        t5 = new Timeline();
        t5.getKeyFrames().add(randomSuciedad());
        t5.setCycleCount(1);
        t5.setOnFinished(e ->{
            t5.getKeyFrames().clear();
            t5.getKeyFrames().add(randomSuciedad());
            t5.play();
        });
        t5.play();
    }
    
    static void ensuciarPou(){
        datosMascota.restarLimpieza(3);
    }
    
    static void enfermarPou(){
        t6 = new Timeline();
        KeyFrame kfhora = new KeyFrame(Duration.seconds(10),e->enfermar());
        t6.getKeyFrames().add(kfhora);
        t6.setCycleCount(1);
        t6.play();
    }
    
    static void enfermar(){
        int num = ran.nextInt(ProyectoSegundoParcialSilvaAvila.enfermedadRemedio.size());
        Set m = ProyectoSegundoParcialSilvaAvila.enfermedadRemedio.keySet();
        List<Enfermedad> danio = new ArrayList<>();
        danio.addAll(m);
        presEnf = danio.get(num);
        datosMascota.restarVida(presEnf.getQuitaAniosVida());
    }
    
    public static void lanzarAccionesTiempo(){
        datosMascota.getVida().manejarTiempo();
        acabarJuego();
        disminuirVida();
        crearTlRand();
        enfermarPou();
    }
}
