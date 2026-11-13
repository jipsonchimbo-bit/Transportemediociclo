package ec.edu.espoch.transportesmediociclo;

import ec.edu.espoch.transportesmediociclo.DataSources.TourMemoryDao;
import ec.edu.espoch.transportesmediociclo.model.CommunicationDevice;
import ec.edu.espoch.transportesmediociclo.model.Guide;
import ec.edu.espoch.transportesmediociclo.model.InterpretiveTour;
import ec.edu.espoch.transportesmediociclo.model.RegularTour;
import ec.edu.espoch.transportesmediociclo.model.Tour;
import ec.edu.espoch.transportesmediociclo.model.Trail;
import java.util.Scanner;
import ec.edu.espoch.transportesmediociclo.DataSources.TourDao;

public class TransportesMedioCiclo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TourDao tourDao = new TourMemoryDao(10);

        CommunicationDevice dev1 = new CommunicationDevice("DEV-01", "Radio Satelital");
        CommunicationDevice dev2 = new CommunicationDevice("DEV-02", "Radio VHF");
        Guide guide1 = new Guide("1501234567", "Carlos Perez");
        Guide guide2 = new Guide("1507654321", "María Andy");

        RegularTour tour1 = new RegularTour("T-01", "Sendero Selva Adentro", 3);
        tour1.agregarTrail(new Trail("Anaconda", 4.5, 60));
        tour1.agregarTrail(new Trail("Ceiba Gigante", 2.0, 30));

        InterpretiveTour tour2 = new InterpretiveTour("T-02", "Ruta Etnobotánica", 3, 45);
        tour2.agregarTrail(new Trail("Plantas Medicinales", 3.0, 50));

        tourDao.guardar(tour1);
        tourDao.guardar(tour2);

        System.out.println("SISTEMA YASUNI EXPLORA TRANSPORTES MEDIO CICLO");

        boolean asignado = tour1.asignarRecursos(dev1, guide1);
        System.out.println("Asignacion de recursos a Tour 1: " + (asignado ? "Exitoso" : "Fallido"));

        System.out.println("Listado de tour");
        Tour[] lista = tourDao.listarTodos();
        for (Tour t : lista) {
            if (t != null) {
                System.out.println("Tour: " + t.getNombre() + 
                                   " - Duracion Total: " + t.calcularDuracionTotal() + " min");
            }
        }

        System.out.print("Ingrese el incremento porcentual de dificultad ej. 0.2 para 20%: ");
        double incremento = scanner.nextDouble();
        double factorSimulado = tour1.getfactorDificultad() + (tour1.getfactorDificultad() * incremento);
        System.out.println("Factor simulado calculado: " + factorSimulado + " (Valor actual intacto: " + tour1.getfactorDificultad() + ")");

        System.out.print("¿Desea aceptar el nuevo factor? (s/n): ");
        char rta = scanner.next().charAt(0);
        if (rta == 's' || rta == 'S') {
            tour1.setFactorDificultad(factorSimulado);
            tourDao.actualizar(tour1);
            System.out.println("Factor actualizado exitosamente mediante el DAO!");
        }

        System.out.println("\nReportando cierre del sendero 'Ceiba Gigante' en el Tour 1...");
        tour1.desactivarTrail("Ceibo Gigante");

        System.out.println("\nLISTADO DESPUES DE LA CLAUSURA");
        Tour[] listaActualizada = tourDao.listarTodos();
        for (Tour t : listaActualizada) {
            if (t != null) {
                System.out.println("Tour: " + t.getNombre() + 
                                   " - Duracion Total: " + t.calcularDuracionTotal() + " min");
            }
        }

        scanner.close();
    }
}