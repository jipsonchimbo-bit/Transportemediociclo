
package ec.edu.espoch.transportesmediociclo.DataSources;




public interface TourDAO {
    boolean guardar(Tour tour);
    Tour buscarPorCodigo(String codigo);
    Tour[] listarTodos();
    boolean actualizar(Tour tour);
    boolean eliminar(String codigo);
}
    

