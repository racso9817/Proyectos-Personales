package enfermedadades;

public class Remedio {
    private String nombreRemedio;
    private double costo;
    private int devuelveAniosVida;

    public Remedio(String nombreRemedio, double costo, int devuelveAniosVida) {
        this.nombreRemedio = nombreRemedio;
        this.costo = costo;
        this.devuelveAniosVida = devuelveAniosVida;
    }

    public String getNombreRemedio() {
        return nombreRemedio;
    }

    public double getCosto() {
        return costo;
    }

    public int getDevuelveAniosVida() {
        return devuelveAniosVida;
    }
}
