package archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import users.*;

public class ManejoArchivos {
    
    /**
     * Metodo para serializar el ArrayList de objetos User, nos ayuda a grabar
     * los datos de los jugadores en el juego en un archivo .ser.
     */
    public static void serializar(){
        try{
            FileOutputStream fos= new FileOutputStream("usuarios.ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(Usuarios.usuarios);
            oos.close();
            fos.close();                    
            System.out.println("Serializado");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    /**
     * Metodo para poder recuperar los datos de un archivo .ser necesarios
     * para el inicio del juego e informacion de sus jugadores.
     */
    public static void deserializar(){     
        try
        {
            FileInputStream fis = new FileInputStream("usuarios.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Usuarios.usuarios= (ArrayList) ois.readObject();
            ois.close();
            fis.close();

            for(User i: Usuarios.usuarios){
                System.out.println(i.toString());
            }
            
            System.out.println("deserializado");   
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}
