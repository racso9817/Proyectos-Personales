package enfermedadades;

public class Enfermedad {
    private String nombre;
    private int quitaAniosVida;

    public Enfermedad(String nombre, int quitaAniosVida) {
        this.nombre = nombre;
        this.quitaAniosVida = quitaAniosVida;
    }
    
    public int getQuitaAniosVida() {
        return quitaAniosVida;
    }
}
