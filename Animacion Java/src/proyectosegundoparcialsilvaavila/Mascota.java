package proyectosegundoparcialsilvaavila;

import globales.Constantes;
import java.io.Serializable;
import java.time.LocalDateTime;
import javafx.scene.image.Image;
import pane.MascotaPane;
import static pane.MascotaPane.datosMascota;
import reloj.Tiempo;

public class Mascota implements Serializable {
    /**
     * La clase Mascota es la que se encarga de hacer el
     * manejo de todos los datos de la mascota del usuario
     * con sus respectivos metodos.
     */
    private int alimentacion, animo, limpieza;
    private double dinero;
    private Tiempo vida;
    public LocalDateTime tempSalida;  
    
    //booleans para el bajo de vida en 100
    boolean ocurAlimentacion=true;
    boolean ocurAnimo=true;
    boolean ocurLimpieza=true;
    
    public Mascota(){
        this.alimentacion = Constantes.ALIMENTACION;
        this.dinero = Constantes.DINERO;
        this.limpieza = Constantes.LIMPIEZA;
        this.animo = Constantes.ANIMO;
        this.vida = new Tiempo();
    }

    public int getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(int alimentacion) {
        this.alimentacion = alimentacion;
    }

    public int getAnimo() {
        return animo;
    }

    public void setAnimo(int animo) {
        this.animo = animo;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    public boolean posiblePagar(double dinero){
        if(this.dinero<dinero){
            return false;
        }
        else{
            return true;
        }
    }
    
    public Tiempo getVida() {
        return vida;
    }
    
    //aumentar y restar
    public void aumentarDinero(double dinero){
        if((this.dinero+=dinero)<0){
            this.dinero=0;
        }
        else if((this.dinero+=dinero)>0){
            this.dinero+=dinero;
        }
    }
    
    public void restarDinero(double dinero){
        if(this.dinero>0){
            this.dinero-=dinero;
        }
    }
    
    public void aumentarAlimentacion(int alimentacion){
        this.ocurAlimentacion=true;
        if(this.alimentacion<10){
            if((this.alimentacion+alimentacion)>10){
                this.alimentacion=10;
            }
            else{
                this.alimentacion+=alimentacion;
            }
        }
    }
    
    public void restarAlimentacion(int alimentacion){
        if(this.alimentacion>alimentacion){
            this.alimentacion-=alimentacion;
        }
        else{
            this.alimentacion=0;
            if(ocurAlimentacion){
                datosMascota.restarVida(100);
            }
            this.ocurAlimentacion=false;
        }     
    }
    
    public void aumentarAnimo(int animo){
        this.ocurAnimo=true;
        if(this.animo<10){
            if((this.animo+animo)>10){
                this.animo=10;
            }
            else{
               this.animo+=animo;
            }
        }
    }
    
    public void restarAnimo(int animo){
        if(this.animo>animo){
            this.animo-=animo;
        }
        else{
            this.animo=0;
            if(ocurAnimo){
                datosMascota.restarVida(100);
            }
            this.ocurAnimo=false;
        }      
    }
    
    public void aumentarLimpieza(){
        this.ocurLimpieza=true;
        this.limpieza=10;
        MascotaPane.mascota.setImage(new Image(Constantes.RUTA_IMAGEN_POU));
    }
    
    public void restarLimpieza(int limpieza){
        if(this.limpieza>limpieza){
            this.limpieza-=limpieza;
        }
        else{
            this.limpieza=0;
            if(ocurLimpieza){
                datosMascota.restarVida(100);
            }
            this.ocurLimpieza=false;
        }      
    }
    
    public void aumentarVida(int vida){
        if(this.vida.tiempo+vida>500){
            this.vida.tiempo=500;
        }
        else{
            this.vida.tiempo+=vida;
        }
    }
    
    public void restarVida(int vida){
        if(this.vida.tiempo>vida){
            this.vida.tiempo-=vida;
        }
        else{
            this.vida.tiempo=0;
        }
    }
}
