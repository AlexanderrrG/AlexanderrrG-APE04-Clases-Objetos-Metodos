

import java.util.Scanner;
import java.util.ArrayList;

// public class Estudiante
class Estudiante {
    // Atributos privados
    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1, nota2, nota3;

    // Constructor
    public Estudiante(String cedula, String nombre, String apellido, double nota1, double nota2, double nota3) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Métodos get y set
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public void setNotas(double n1, double n2, double n3) {
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    // Método para calcular el promedio
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Método para determinar si aprueba o reprueba
    public String determinarEstado() {
        if (calcularPromedio() >= 7.00) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    // Método para mostrar la información del estudiante
    public void mostrarInformacion() {
        System.out.println("\nCedula: " + cedula + " | Nombre: " + nombre + " " + apellido);
        System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
        System.out.printf("Promedio: %.2f - Estado: %s\n", calcularPromedio(), determinarEstado());
    }
}

// Clase Principal
public class Main {
    
    // Validar que las notas estén entre 0 y 10
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