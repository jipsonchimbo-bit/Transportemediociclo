
package ec.edu.espoch.transportesmediociclo.model;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    protected String codigo;
    protected String nombre;
    protected int maxTrails;
    protected List<Trail> trails;
    protected double factorDificultad = 1.0;

    public Tour(String codigo, String nombre, int maxTrails) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.maxTrails = maxTrails;
        this.trails = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getfactorDificultad() {
        return factorDificultad;
    }

    public void setFactorDificultad(double factorDificultad) {
        this.factorDificultad = factorDificultad;
    }

    public double calcularDuracionTotal() {
        double tiempoTotal = 0;
        for (Trail trail : trails) {
            if (trail.isHabilitado()) {
                tiempoTotal += trail.getTiempoCaminata();
            }
        }
        return tiempoTotal;
    }

    public void agregarTrail(Trail trail) {
        if (trails.size() < maxTrails) {
            trails.add(trail);
        }
    }

    public boolean asignarRecursos(CommunicationDevice device, Guide guide) {
        if (device.isDisponible() && guide.isDisponible()) {
            device.setDisponible(false);
            guide.setDisponible(false);
            return true;
        }
        return false;
    }

    public void desactivarTrail(String nombreTrail) {
        for (Trail trail : trails) {
            if (trail.getNombre().equalsIgnoreCase(nombreTrail)) {
                trail.setHabilitado(false);
            }
        }
    }
}