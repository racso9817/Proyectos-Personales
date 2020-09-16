package users;

import java.io.Serializable;
import proyectosegundoparcialsilvaavila.Mascota;

public class User implements Serializable{
    /**
     * User es una de las clases principales, ya que corresponde
     * como objeto de cada uno de los jugadores.
     */
    private String nombre;
    private Mascota mascota;
    
    public User(String nombre){
        this.nombre = nombre;
        this.mascota = new Mascota();
    }

    public String getNombre() {
        return this.nombre;
    }

    public Mascota getMascota() {
        return this.mascota;
    }

    @Override
    public String toString() {
        return "User{" + "nombre=" + nombre + ", mascota=" + mascota + '}';
    }   
}
