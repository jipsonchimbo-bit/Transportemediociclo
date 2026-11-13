
package ec.edu.espoch.transportesmediociclo.model;

public class RegularTour extends Tour {

    public RegularTour(String codigo, String nombre, int maxTrails) {
        super(codigo, nombre, maxTrails);
    }

    @Override
    public double calcularDuracionTotal() {
        return super.calcularDuracionTotal() * factorDificultad;
    }
}