
package ec.edu.espoch.transportesmediociclo.DataSources;


package DataSources;

public class TourMemoryDAO implements TourDAO {
    private Tour[] tours;
    private int contador;

    public TourMemoryDAO(int capacidad) {
        this.tours = new Tour[capacidad];
        this.contador = 0;
    }

    @Override
    public boolean guardar(Tour tour) {
        if (contador < tours.length) {
            tours[contador++] = tour;
            return true;
        }
        return false;
    }

    @Override
    public Tour buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (tours[i].getCodigo().equalsIgnoreCase(codigo)) {
                return tours[i];
            }
        }
        return null;
    }

    @Override
    public Tour[] listarTodos() {
        Tour[] activos = new Tour[contador];
        System.arraycopy(tours, 0, activos, 0, contador);
        return activos;
    }

    @Override
    public boolean actualizar(Tour tour) {
        for (int i = 0; i < contador; i++) {
            if (tours[i].getCodigo().equalsIgnoreCase(tour.getCodigo())) {
                tours[i] = tour;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (tours[i].getCodigo().equalsIgnoreCase(codigo)) {
                for (int j = i; j < contador - 1; j++) {
                    tours[j] = tours[j + 1];
                }
                tours[--contador] = null;
                return true;
            }
        }
        return false;
    }
}
    

