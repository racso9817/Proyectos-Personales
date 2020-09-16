package alimentos;

import pane.MascotaPane;

public abstract class Comida {
    /**
     * En esta clase se maneja todos los datos de las diferentes comidas
     * que se encuentran en el juego, con el fin de identificar diferentes
     * valores para los atributos de cada una.
     */
    private String nombre;
    private int incrementa;
    private double precio;

    public Comida(String nombre, int incrementa, double precio) {
        this.nombre = nombre;
        this.incrementa = incrementa;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getIncrementa() {
        return incrementa;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void comer() {
        MascotaPane.datosMascota.aumentarAlimentacion(this.getIncrementa());
    }
    
    public void pagar() {
        MascotaPane.datosMascota.restarDinero(this.getPrecio());
    } 
}
