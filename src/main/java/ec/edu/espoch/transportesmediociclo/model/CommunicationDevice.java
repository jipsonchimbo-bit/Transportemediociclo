
package ec.edu.espoch.transportesmediociclo.model;

public class CommunicationDevice {
    private String codigo;
    private String descripcion;
    private boolean disponible;

    public CommunicationDevice(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.disponible = true;
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
