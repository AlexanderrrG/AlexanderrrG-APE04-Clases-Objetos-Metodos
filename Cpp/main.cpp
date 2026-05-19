#include <iostream>
#include <string>
#include <vector>

using namespace std;

// 
class Estudiante {
private:
    string cedula;
    string nombre;
    string apellido;
    float nota1, nota2, nota3;

public:
    
    Estudiante(string c, string n, string a, float n1, float n2, float n3) {
        cedula = c;
        nombre = n;
        apellido = a;
        nota1 = n1;
        nota2 = n2;
        nota3 = n3;
    }

    
    void setCedula(string c) { cedula = c; }
    string getCedula() { return cedula; }
    
    void setNombre(string n) { nombre = n; }
    string getNombre() { return nombre; }
    
    void setApellido(string a) { apellido = a; }
    string getApellido() { return apellido; }

    void setNotas(float n1, float n2, float n3) {
        nota1 = n1; nota2 = n2; nota3 = n3;
    }

    // 
    float calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // 
    string determinarEstado() {
        if (calcularPromedio() >= 7.00) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    // 
    void mostrarInformacion() {
        cout << "\nCedula: " << cedula << " | Nombre: " << nombre << " " << apellido;
        cout << "\nNotas: " << nota1 << ", " << nota2 << ", " << nota3;
        cout << "\nPromedio: " << calcularPromedio() << " - Estado: " << determinarEstado() << "\n";
    }
};

// 
float leerNotaValida(string mensaje) {
    float nota;
    do {
        cout << mensaje;
        cin >> nota;
        if (nota < 0 || nota > 10) {
            cout << "Error: La nota debe estar entre 0 y 10. Intente de nuevo.\n";
        }
    } while (nota < 0 || nota > 10);
    return nota;
}

int main() {
    vector<Estudiante> listaEstudiantes;
    int cantidad = 5; 

    cout << "--- SISTEMA DE CONTROL DE ESTUDIANTES Y CALIFICACIONES ---\n";

    // 
    for (int i = 0; i < cantidad; i++) {
        string ced, nom, ape;
        float n1, n2, n3;

        cout << "\n--- Ingreso de datos Estudiante " << i + 1 << " ---\n";
        cout << "Cedula: "; cin >> ced;
        cout << "Nombre: "; cin >> nom;
        cout << "Apellido: "; cin >> ape;

        n1 = leerNotaValida("Nota 1 (0-10): ");
        n2 = leerNotaValida("Nota 2 (0-10): ");
        n3 = leerNotaValida("Nota 3 (0-10): ");

        Estudiante nuevoEstudiante(ced, nom, ape, n1, n2, n3);
        listaEstudiantes.push_back(nuevoEstudiante);
    }

    // 
    cout << "\n--- LISTADO COMPLETO DE ESTUDIANTES ---\n";
    int aprobados = 0, reprobados = 0;

    for (int i = 0; i < listaEstudiantes.size(); i++) {
        listaEstudiantes[i].mostrarInformacion();
        if (listaEstudiantes[i].determinarEstado() == "Aprobado") {
            aprobados++;
        } else {
            reprobados++;
        }
    }

    cout << "\n--- RESUMEN FINAL ---\n";
    cout << "Estudiantes Aprobados: " << aprobados << "\n";
    cout << "Estudiantes Reprobados: " << reprobados << "\n";

    return 0;
}
