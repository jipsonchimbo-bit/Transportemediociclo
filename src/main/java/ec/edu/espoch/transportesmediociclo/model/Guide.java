
package ec.edu.espoch.transportesmediociclo.model;

public class Guide {

    private String nationalId;
    private String nombre;
    private boolean disponible;

    public Guide(String nationalId, String nombre) {
        this.nationalId = nationalId;
        this.nombre = nombre;
        this.disponible = true;
    }

    public String getNationalId() { return nationalId; }
    public String getNombre() { return nombre; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
    
