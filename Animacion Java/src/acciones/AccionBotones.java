package acciones;

import alimentos.*;
import archivos.ManejoArchivos;
import pane.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import globales.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import jueguitopou.PaneCofres;
import proyectosegundoparcialsilvaavila.ProyectoSegundoParcialSilvaAvila;
import reloj.Tiempo;

public class AccionBotones {
    /**
     * Esta clase contiene todas las acciones que hacen los botones en las difernetes clases
     */
    static Cookie cookie = new Cookie("Cookie",1,10);
    static Lasagna lasagna = new Lasagna("Lasagna",5,75);
    static Pizza pizza = new Pizza("Pizza",3,50);
    static RoastedChicken roastedChicken = new RoastedChicken("Roasted Chicken",10,10);
    public static List<String> list = new ArrayList<>();
    public static PaneCofres paneCofre;
    
    public static void ManejarBotones(ActionEvent event) throws IOException, InterruptedException {
        if (event.getSource().equals(MascotaPane.jugar)){
            list.add("X2");
            list.add("X3");
            list.add("X5");
            list.add("MonedaPositiva");
            list.add("MonedaNegativa");
            list.add("BOMBA");
            
            Tiempo.vida.stop();
            Tiempo.t1.stop();
            Tiempo.t2.stop();
            Tiempo.t4.stop();
            Tiempo.t5.stop();
            Tiempo.t6.stop();
            ManejoArchivos.serializar();
            
            paneCofre = new PaneCofres();
            ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.close();
            ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.setTitle("Jueguito Pou");
            Scene scene4 = new Scene(paneCofre.getPaneJuego(),1040,1000 );
            scene4.onKeyPressedProperty().bind(paneCofre.getPaneJuego().onKeyPressedProperty());
            ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.setScene(scene4);
            ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.show();
        }
        else if (event.getSource().equals(MascotaPane.bañar)){
            MascotaPane.datosMascota.aumentarLimpieza();
        }
        else if (event.getSource().equals(MascotaPane.alimentar)){
            String opcion = (String) MascotaPane.cbComida.getValue();
            if(opcion.equals("Cookie")){
                if(MascotaPane.datosMascota.posiblePagar(cookie.getPrecio())){
                    cookie.comer();
                    cookie.pagar();  
                    Thread firstAction = new Thread(new EjecutorAnimacion(Constantes.RUTA_IMAGEN_COOKIE));
                    firstAction.start();              
                }
            }
            else if(opcion.equals("Lasagna")){
                if(MascotaPane.datosMascota.posiblePagar(lasagna.getPrecio())){
                    lasagna.comer();
                    lasagna.pagar();
                    Thread firstAction = new Thread(new EjecutorAnimacion(Constantes.RUTA_IMAGEN_LASAGNA));
                    firstAction.start(); 
                }
            }
            else if(opcion.equals("Pizza")){
                if(MascotaPane.datosMascota.posiblePagar(pizza.getPrecio())){
                    pizza.comer();
                    pizza.pagar();
                    Thread firstAction = new Thread(new EjecutorAnimacion(Constantes.RUTA_IMAGEN_PIZZA));
                    firstAction.start(); 
                }
            }
            else if(opcion.equals("RoastedChicken")){
                if(MascotaPane.datosMascota.posiblePagar(roastedChicken.getPrecio())){
                    roastedChicken.comer();
                    roastedChicken.pagar();
                    Thread firstAction = new Thread(new EjecutorAnimacion(Constantes.RUTA_IMAGEN_CHICKEN));
                    firstAction.start();
                }
            }
            
        }
        else if (event.getSource().equals(MascotaPane.curar)){
            if(MascotaPane.datosMascota.posiblePagar(ProyectoSegundoParcialSilvaAvila.enfermedadRemedio.get(Tiempo.presEnf).getCosto())){
                MascotaPane.datosMascota.restarDinero(ProyectoSegundoParcialSilvaAvila.enfermedadRemedio.get(Tiempo.presEnf).getCosto());
                MascotaPane.datosMascota.aumentarVida(ProyectoSegundoParcialSilvaAvila.enfermedadRemedio.get(Tiempo.presEnf).getDevuelveAniosVida());
            }
        }
        else if (event.getSource().equals(IngresarPane.ingresar)){
            
            if (IngresarPane.jugador!=""){
                ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.close();
                Scene scene2 = new Scene(new MascotaPane().getRoot(),Constantes.TAMANO_PANE_MASCOTA,Constantes.TAMANO_PANE_MASCOTA);
                ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.setTitle("Mascota Virtual");
                ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.setScene(scene2);
                ProyectoSegundoParcialSilvaAvila.pantallaPrincipal.show();
            }
        }
    }
 
    static class EjecutorAnimacion implements Runnable{
        public String ruta;
        
        EjecutorAnimacion(String ruta){
            this.ruta =  ruta;
        }
        
        @Override
        public void run() {
            Platform.runLater(()->MascotaPane.mascota.setImage(new Image(ruta)));
            
            try{
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AccionBotones.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Platform.runLater(()->MascotaPane.mascota.setImage(new Image(Constantes.RUTA_IMAGEN_POU)));
        }
    }
}
