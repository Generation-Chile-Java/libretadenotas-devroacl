import java.util.*;

public class Main {

    // ACA VA TODA LA LOGICA DEL MENU Y LO PRINCIPAL DEL PROGRAMA
    public static void main(String[] args) {
        Integer op=0;
        Integer opp=0;
         //Interaccion con el usuario.
        Scanner input = new Scanner(System.in);

        LibretaDeNotas libreta = new LibretaDeNotas();


        do {
            //IMPRIMIR OPCIONES DEL MENU y FUNCIONES
            // AGREGA ESTUDIANTES A LA LISTA

            //sOLICITAR Datos de los estudiantes
            libreta.agregarEstudianteDesdeConsola();

            if (libreta.getNotasEstudiantes().isEmpty()){
                System.out.println("La lista está vacía. Llenala con información.");
                libreta.agregarEstudianteDesdeConsola();

            }else {
                // Si la lista no está vacía, continuar con otras opciones del menú
                System.out.println("La lista de estudiantes se ha añadido  exitosamente.");
            }

            Menu(); //Impresion del menu

            while (true){  //CICLO While para que el usuario ingrese cualquier dato hasta que ingrese opcion 0 para Salir.Aun si ingresa otros numeros o letras no se cierre el programa.
                try {
                    System.out.println("Ingresa la opcion del Menu");
                    op = input.nextInt();
                    input.nextLine();

                    //LOGICA DE LAS OPCIONES DEL MENU
                    switch (op) {
                        case 1://Calcula el promedio

                            //HACER UN OPCION PARA ELEGIR VER TODOS LOS PROMEDIOS O POR NOMBRE

                            System.out.println("¿Quieres ver el promedio por Alumno o ver todos los alumnos?");
                            System.out.println("1.Buscar promedio por Nombre de Alumno");
                            System.out.println("2.Lista de todos los Alumnos Registrados");

                            opp = input.nextInt();
                            input.nextLine();
                            switch (opp){
                                case 1:
                                    //MOSTRAR PROMEDIO POR ALUMNO
                                    System.out.println("CALCULO DEL PROMEDIO");
                                    System.out.println("Ingresa el nombre del estudiante para calcular su promedio:");
                                    String nombre= input.next();
                                    libreta.calcularPromedio(nombre);
                                    System.out.println( libreta.calcularPromedio(nombre));
                                    break;


                                case 2:
                                    //MOSTRAR PROMEDIO DE TODOS LOS ALUMNOS REGISTRADOS
                                    System.out.println("CALCULO DEL PROMEDIO");
                                    System.out.println("Mostrar todos los promedios de los estudiantes");
                                    libreta.imprimirPromedios();
                                    break;
                                default:
                                    System.out.println("Opcion no valida");

                            }


                            break;
                        case 2:


                            System.out.println("Ingrese el nombre del estudiante:");
                            String nombreAlumno= input.next();
                            System.out.println("Ingrese la nota a evaluar:");
                            double nota = input.nextDouble();
                            System.out.println(libreta.esAprobatoria(nota) ? "Aprobado  la nota para aprobar es un 40 y el maximo un 70" : "Reprobado");
                            break;
                        case 3:
                            System.out.println("Ingrese el nombre del estudiante:");
                            nombreAlumno = input.next();
                            System.out.println("Ingrese la nota a comparar:");
                            nota = input.nextDouble();
                            System.out.println(libreta.compararConPromedioCurso(nombreAlumno, nota));
                            break;
                        case 0:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opcion "+op+" no existe");
                    }
                }catch (Exception e){
                    System.out.println("Opcion no valida");
                    input.next(); //Siempre poner este para que no sea ciclo infinito cuando ingrese letras o caracteres.
                }
            }

        }while (op!=0);
    }

    //Hacer el menu para imprimir
    public static void Menu(){
        System.out.println("******************  MENU  ********************" +
                "\n 1-Mostrar Promedio de Estudiante " +
                "\n 2-Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante" +
                "\n 3-Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante" +
                "\n 0-Salir");
    }




}