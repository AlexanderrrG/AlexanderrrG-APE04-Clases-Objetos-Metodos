

public class Estudiante {
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
