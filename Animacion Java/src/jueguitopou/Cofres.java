package jueguitopou;

import java.util.Random;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * @author Oscar
 * Clase creada para manejar los cofres
 */

public class Cofres {
    private static final String COFRE="/imagenes/cofre.jpg";
    Random rand = new Random();
    int num;
    public Rectangle rec;
    
    Cofres(){
        rec = new Rectangle(60,60);
        ImagePattern imagePattern = new ImagePattern(new Image(COFRE));
        rec.setFill(imagePattern);
        animacion();   
    }

    /**
     * Método que realiza el movimiento de la animación para los cofres
     */
    public void animacion() {
        PathTransition transition = new PathTransition();
        transition.setNode(rec);
        Random r = new Random();
        int num = 1+r.nextInt((int) 10)*80;
        Line linea = new Line();
        linea.setStartX(200);
        linea.setStartY(num+100);
        linea.setEndX(800);
        linea.setEndY(num+100);
        String a = Integer.toString(num);
        transition.setDuration(Duration.seconds(5));
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setPath(linea);
        transition.setAutoReverse(true);
        transition.play();
    }

    public Rectangle getRec() {
        return rec;
    }
}
