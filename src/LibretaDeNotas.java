import java.util.*;

public class LibretaDeNotas {
    //Aqui va la logica de libreta de notas y esas cosas.

    Map<String, List<Double>> NotasEstudiantes;

    //Constructor
    public LibretaDeNotas(){
        this.NotasEstudiantes = new HashMap<>();
    }

    //Metodos para agregar un estudiante con sus notas

    public void agregarEstudianteDesdeConsola(){
        Scanner sc = new Scanner(System.in);
        System.out.println("La lista en este caso está vacía. Por favor, agregue la información solicitada.");

        int cantidadAlumnos;
        do {
            System.out.print("Ingrese la cantidad de alumnos (1-40): ");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada inválida
            }
            cantidadAlumnos = sc.nextInt();
        } while (cantidadAlumnos < 1 || cantidadAlumnos > 40);

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Ingrese el nombre del alumno: ");
            String nombreAlumno = sc.next();

            int cantidadNotas;
            do {
                System.out.print("Ingrese la cantidad de notas para " + nombreAlumno +"(1-20)"+ ": ");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.next();
                }
                cantidadNotas = sc.nextInt();
            } while (cantidadNotas < 1 || cantidadNotas>20);

            List<Double> notas = new ArrayList<>();
            for (int j = 0; j < cantidadNotas; j++) {
                double nota;
                do {
                    System.out.print("Ingrese la nota " + (j + 1));
                    while (!sc.hasNextDouble()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        sc.next();
                    }
                    nota = sc.nextDouble();
                } while (nota < 1 || nota > 7);
                notas.add(nota);
            }
            NotasEstudiantes.put(nombreAlumno, notas);
        }
    }


    //Metodo para

    public double calcularPromedio(String nombre) {
        List<Double> notas = NotasEstudiantes.get(nombre);
        if (notas == null || notas.isEmpty()) {
            return 0.0; // Si no hay notas, el promedio es 0
        }
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    // Método para obtener la nota máxima de un estudiante
    public double obtenerNotaMaxima(String nombre) {
        List<Double> notas = NotasEstudiantes.get(nombre);
        return (notas == null || notas.isEmpty()) ? 0.0 : Collections.max(notas);
    }

    // Método para obtener la nota mínima de un estudiante
    public double obtenerNotaMinima(String nombre) {
        List<Double> notas = NotasEstudiantes.get(nombre);
        return (notas == null || notas.isEmpty()) ? 0.0 : Collections.min(notas);
    }

    // Método para verificar si una nota es aprobatoria
    public boolean esAprobatoria(double nota) {
        return nota >= 40.0; // Puedes cambiar este valor según el criterio de aprobación
    }

    // Método para calcular el promedio general del curso
    public double calcularPromedioCurso() {
        if (NotasEstudiantes.isEmpty()) {
            return 0.0;
        }
        double sumaTotal = 0;
        int cantidadNotas = 0;
        for (List<Double> notas : NotasEstudiantes.values()){
            for (double nota : notas) {
                sumaTotal += nota;
                cantidadNotas++;
            }
        }
        return (cantidadNotas == 0) ? 0.0 : sumaTotal / cantidadNotas;
    }

    // Método para comparar una nota con el promedio del curso
    public String compararConPromedioCurso(String nombre, double nota) {
        double promedioCurso = calcularPromedioCurso();
        if (nota > promedioCurso) {
            return "Sobre el promedio del curso";
        } else if (nota < promedioCurso) {
            return "Debajo del promedio del curso";
        } else {
            return "Igual al promedio del curso";
        }
    }

    public Map<String, List<Double>> getNotasEstudiantes() {
        return NotasEstudiantes;
    }



    /// Para imprimir todos los promedios en la consola.
    public void imprimirPromedios(){
        NotasEstudiantes.forEach((nombre, notas) -> {
            double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println("ALUMNO: "+ nombre+"  ,PROMEDIO: "+String.format("%.2f",promedio));
        });
    }


    @Override
    public String toString() {
        return "LibretaDeNotas{" +
                "NotasEstudiantes=" + NotasEstudiantes +
                '}';
    }
}
