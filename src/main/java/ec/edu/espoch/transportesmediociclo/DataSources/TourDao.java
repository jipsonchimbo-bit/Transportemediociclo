package ec.edu.espoch.transportesmediociclo.DataSources;

import ec.edu.espoch.transportesmediociclo.model.Tour;

public interface TourDao {
    boolean guardar(Tour tour);
    Tour buscarPorCodigo(String codigo);
    Tour[] listarTodos();
    boolean actualizar(Tour tour);
    boolean eliminar(String codigo);
}