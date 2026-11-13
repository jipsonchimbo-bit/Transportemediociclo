
package ec.edu.espoch.transportesmediociclo.model;

import ec.edu.espoch.transportesmediociclo.model.ComunicationDevice.CommunicationDevice;

public abstract class Tour {

    protected String codigo;
    protected String nombre;
    protected Trail[] trails;
    protected int numTrails;
    protected double factorDificultad;
    protected CommunicationDevice device;
    protected Guide guide;

    public Tour(String codigo, String nombre, int maxTrails) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.trails = new Trail[maxTrails];
        this.numTrails = 0;
        this.factorDificultad = 1.0;
    }

    public void agregarTrail(Trail trail) {
        if (numTrails < trails.length) {
            trails[numTrails++] = trail;
        }
    }

    public void desactivarTrail(String nombreTrail) {
        for (int i = 0; i < numTrails; i++) {
            if (trails[i].getNombre().equalsIgnoreCase(nombreTrail)) {
                trails[i].setHabilitado(false);
                break;
            }
        }
    }

    public double calcularDistancia() {
        double distanciaTotal = 0;
        for (int i = 0; i < numTrails; i++) {
            if (trails[i].isHabilitado()) {
                distanciaTotal += trails[i].getLongitud();
            }
        }
        return distanciaTotal;
    }

    public int calcularTiempoBaseCaminata() {
        int tiempoTotal = 0;
        for (int i = 0; i < numTrails; i++) {
            if (trails[i].isHabilitado()) {
                tiempoTotal += trails[i].getTiempoCaminata();
            }
        }
        return tiempoTotal;
    }

    public double calcularTiempoAjustado() {
        return calcularTiempoBaseCaminata() * factorDificultad;
    }

    public abstract double calcularDuracionTotal();

    public boolean asignarRecursos(CommunicationDevice dev, Guide g) {
        if (dev.isDisponible() && g.isDisponible() && this.device == null && this.guide == null) {
            this.device = dev;
            this.guide = g;
            dev.setDisponible(false);
            g.setDisponible(false);
            return true;
        }
        return false;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getFactorDificultad() { return factorDificultad; }
    public void setFactorDificultad(double factorDificultad) { this.factorDificultad = factorDificultad; }
    public CommunicationDevice getDevice() { return device; }
    public Guide getGuide() { return guide; }
    public Trail[] getTrails() { return trails; }
    public int getNumTrails() { return numTrails; }
}
    

