package proyectosegundoparcialsilvaavila;

import enfermedadades.Enfermedad;
import enfermedadades.Remedio;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import archivos.ManejoArchivos;
import globales.Constantes;
import java.time.LocalDateTime;
import pane.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProyectoSegundoParcialSilvaAvila extends Application {
    /**Clase principal donde todo comienza, iniciando por 
     * mandar la clase de IngresarPane 
     * que permite el ingreso del usuario con el que se quiere jugar.
     */
    public static HashMap<Enfermedad, Remedio> enfermedadRemedio = new HashMap<>();
    public static List<String> enfermed = new ArrayList<>();
    
    public static Stage pantallaPrincipal;
    @Override
    public void start(Stage stage) {
        pantallaPrincipal = stage;
        
        pantallaPrincipal.setOnCloseRequest(event -> {

            try{
            MascotaPane.datosMascota.tempSalida=LocalDateTime.now();
            ManejoArchivos.serializar();
            }catch(NullPointerException e){
            }
        });
 
        Scene scene = new Scene(new IngresarPane().getRoot(),Constantes.PANTALLA_X,Constantes.PANTALLA_Y);
        stage.setTitle("Mascota Virtual");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {       
        /**Se hace el metodo de deserializar para obtener los datos guardados del juego.
         */
        String rutaEnfermedades = "enfermedades-remedios.csv";
        ingresoEnfermedades(rutaEnfermedades);
        ManejoArchivos.deserializar();
        launch(args);
    }
    
    static void ingresoEnfermedades(String archivo) throws IOException{
        Path path = Paths.get(archivo);
        List<String> datos = new ArrayList<String>();
        datos = Files.readAllLines(path);
        
        for(int i=1;i<(datos.size());i++){
            String enf = datos.get(i);
            String[] a = enf.split(",");
            enfermed.add(a[0].trim());
            enfermedadRemedio.put(new Enfermedad(a[0].trim(),Integer.parseInt(a[1].trim())),
                    new Remedio(a[2].trim(),Integer.parseInt(a[3].trim()),Integer.parseInt(a[4].trim())));
        }
    }
}
