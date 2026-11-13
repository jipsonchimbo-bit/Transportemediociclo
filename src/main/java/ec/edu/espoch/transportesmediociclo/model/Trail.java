
package ec.edu.espoch.transportesmediociclo.model;

public class Trail {
    private String nombre;
    private double longitud; 
    private int tiempoCaminata; 
    private boolean habilitado;

    public Trail(String nombre, double longitud, int tiempoCaminata) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.tiempoCaminata = tiempoCaminata;
        this.habilitado = true; 
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    public int getTiempoCaminata() { return tiempoCaminata; }
    public void setTiempoCaminata(int tiempoCaminata) { this.tiempoCaminata = tiempoCaminata; }

    public boolean isHabilitado() { return habilitado; }
    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }
}
    

