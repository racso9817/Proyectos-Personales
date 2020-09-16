package acciones;

import pane.MascotaPane;
import java.util.Random;
import javafx.animation.PathTransition;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Animaciones {
    /**
     * En esta clase se encuentran todas las animaciones usadas para el
     * movimiento de imagenes o figuras.
     */
    public static Random ran = new Random();
    public static PathTransition path = new PathTransition();
    
    public static void AnimacionMascota(){
        path.setNode(MascotaPane.mascota);
        path.setPath(crearPath());
        path.setDuration(Duration.seconds(2));
        path.setCycleCount(1);
        path.setOnFinished(e -> {
                path.setPath(crearPath());
                path.play();
        });
        path.play();
    }
    
    public static void AnimacionJugar(){
        path.stop();
        path.setNode(MascotaPane.mascota);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            250.0, 250.0,
            100.0, 100.0,
            10.0, 20.0 });
        path.setPath(polygon);
        path.setDuration(Duration.seconds(5));
        path.setCycleCount(2);
        path.play();
    }
    
    static Rectangle crearPath(){
        int num = ran.nextInt(50);
        Rectangle r = new Rectangle();
        r.setX(num);
        r.setY(250);
        r.setWidth(num);
        r.setHeight(num);
        r.setArcWidth(num);
        r.setArcHeight(num);
        return r;
    }
}
        
        /*Ellipse elipse = new Ellipse(10,10);
        path.setNode(MascotaPane.mascota);
        path.setPath(elipse);
        elipse.setLayoutX(100);
        elipse.setLayoutY(100);
        path.setDuration(Duration.seconds(10));
        path.setCycleCount(2);
        path.play();
    
    
    public static void AnimacionMascota(){
        
        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(javafx.util.Duration.millis(500));
        pathTransition.setPath(createPath());
        pathTransition.setNode(MascotaPane.mascota);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(2);
        pathTransition.setAutoReverse(true);
        pathTransition.setOnFinished(e -> {

            pathTransition.setPath(createPath());
            pathTransition.play();

        });
        pathTransition.play();

    }
    
    private static Path createPath(){
        int loc = ran.nextInt(600 - 300 + 1) + 300; // min=300 , max=600

        Path path = new Path();
        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new LineTo(loc, 600));

        return path;
    }*/
