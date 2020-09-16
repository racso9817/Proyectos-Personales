package jueguitopou;

import acciones.AccionBotones;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * @author Oscar
 * Clase creada para manejar las flechas
 */

public class Flecha {    
    private static final String FLECHA="/imagenes/flecha.png";    
    private Line line;
    public Rectangle rec;
    Flecha(){
        inicializarElementos();            
    }
    
    public void inicializarElementos(){
        rec = new Rectangle(30,30);
        line = new Line();
        ImagePattern imagePattern = new ImagePattern(new Image(FLECHA));
        rec.setFill(imagePattern);
    }
    
    /**
     * Método usado para la animación de las flechas
     */
    public void animacion(double x){
        PathTransition transicion = new PathTransition();
        transicion.setNode(rec);
        transicion.setPath(parametrizarLinea(x));
        transicion.setDuration(Duration.seconds(1));
        transicion.setCycleCount(1);
        transicion.setOnFinished(ev->{
            AccionBotones.paneCofre.getPaneJuego().getChildren().remove(rec);
        });
        transicion.play();
    }
    
    /**
     * Método para poner la línea en la posición deseada
     */
    
    public Line parametrizarLinea(double x){
        System.out.println(x);
        
        line.setStartX(x+90);
        line.setEndX(x+90);
        line.setEndY(0);
        line.setStartY(1000-70);
        return line;
    }
    
    public Line getLine() {
        return line;
    }

    public Rectangle getRec() {
        return rec;
    }
}
