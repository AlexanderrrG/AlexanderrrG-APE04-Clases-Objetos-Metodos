import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    // Función para validar que las notas estén entre 0 y 10
    public static double leerNotaValida(Scanner sc, String mensaje) {
        double nota;
        do {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("Error: La nota debe estar entre 0 y 10. Intente de nuevo.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        int cantidad = 5; // Registrar mínimo 5 estudiantes

        System.out.println("--- SISTEMA DE CONTROL DE ESTUDIANTES Y CALIFICACIONES ---");

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Ingreso de datos Estudiante " + (i + 1) + " ---");
            System.out.print("Cedula: ");
            String ced = sc.next();
            System.out.print("Nombre: ");
            String nom = sc.next();
            System.out.print("Apellido: ");
            String ape = sc.next();

            double n1 = leerNotaValida(sc, "Nota 1 (0-10): ");
            double n2 = leerNotaValida(sc, "Nota 2 (0-10): ");
            double n3 = leerNotaValida(sc, "Nota 3 (0-10): ");

            // Aquí se crea el objeto usando la clase del otro archivo
            Estudiante est = new Estudiante(ced, nom, ape, n1, n2, n3);
            listaEstudiantes.add(est);
        }

        System.out.println("\n--- LISTADO COMPLETO DE ESTUDIANTES ---");
        int aprobados = 0;
        int reprobados = 0;

        for (Estudiante est : listaEstudiantes) {
            est.mostrarInformacion();
            if (est.determinarEstado().equals("Aprobado")) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        System.out.println("\n--- RESUMEN FINAL ---");
        System.out.println("Estudiantes Aprobados: " + aprobados);
        System.out.println("Estudiantes Reprobados: " + reprobados);

        sc.close();
    }
}
