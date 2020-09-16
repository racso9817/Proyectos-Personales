package jueguitopou;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase para inicializar la imagen de la mascota virtual y sus atributos
 * @author Oscar
 */

public class Pou {
    private ImageView pou;
    private static final String ARCHIVO_IMAGEN="/imagenes/poo.jpg";
    
    Pou(){
        inicializarElementos();
    }
    
    public void inicializarElementos(){
        pou = new ImageView(new Image(ARCHIVO_IMAGEN));
        pou.setFitHeight(100);
        pou.setFitWidth(100);
    }
    
    public ImageView getImagenPou() {
        return pou;
    }
}
