package ec.edu.espoch.transportesmediociclo.model;

public class InterpretiveTour extends Tour {
    private int tiempoEducativo;

    public InterpretiveTour(String codigo, String nombre, int maxTrails, int tiempoEducativo) {
        super(codigo, nombre, maxTrails);
        this.tiempoEducativo = tiempoEducativo;
    }

    @Override
    public double calcularDuracionTotal() {
        return super.calcularDuracionTotal() + tiempoEducativo;
    }

    public int getTiempoEducativo() {
        return tiempoEducativo;
    }

    public void setTiempoEducativo(int tiempoEducativo) {
        this.tiempoEducativo = tiempoEducativo;
    }
}