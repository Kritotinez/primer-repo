package codoacodo;
import javax.swing.*;
/**
 * Proyecto Final
 * CAC Inicial 2023
 * @autor Grupo 3
 * @version FINAL
 */

//Entrega 7/07/2023

/*
 * Temas:
 * Diseña y desarrolla un programa en Java que implemente un CRUD (Create, Read, Update, Delete)
 * para gestionar los datos de alumnos de Codo a Codo.
 * El programa debe utilizar la biblioteca Swing para la interfaz gráfica
 * y almacenar los datos en un archivo de texto.
 */
public class Main {
    static GestionAlumno gestionAlumno = new GestionAlumno();
    public static void main(String[] args) {
        int salir, opcion = 0;
        while (opcion != 100){
            opcion = menu();
           switch (opcion){
                case 1: gestionAlumno.altaAlumno(); break;
                case 2: gestionAlumno.modificarAlumno(); break;
                case 3: gestionAlumno.borrarAlumno(); break;
                case 4: mostrarAltas(); break;
                case 5: gestionAlumno.buscarAlumno();break;
                case 6:salir = Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea salir del Gestor de Alumnos?",
                        "PROYECTO FINAL - CAC Inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                        new String[]{"Salir", "Volver al Menú"}, "Volver al Menú")));
                    if (salir == 0){
                        opcion = 100;
                    } else if (salir == 1) {
                        opcion = 2;
                    } break;
                default: JOptionPane.showMessageDialog(null, "OPCIÓN INVÁLIDA", "PROYECTO FINAL - CAC Inicial", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
    public static int menu() {
        String input = Interfaz.mensajeMenu("GESTIÓN DE ALUMNOS" +" \n" +
                        "1.- Crear Alta." + "\n" +
                        "2.- Modificar dato de un alumno." + "\n" +
                        "3.- Dar de baja alumno." + "\n" +
                        "4.- Listar alumnos dados de alta. " + "\n" +
                        "5.- Buscar un alumno. " + "\n" +
                        "6.- Salir." + "\n" +
                        "" + "\n" +
                        "Ingrese su opción aquí:",
                "PROYECTO FINAL - CAC Inical");
        return Integer.parseInt(input);
    }
    public static void mostrarAltas() {
        if (gestionAlumno.listarAlumnos().length() == 0) {
            JOptionPane.showMessageDialog(null, "No hay alumnos inscriptos.", "Alumnos Inscriptos - CAC Inicial", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Interfaz.mostrarLista(gestionAlumno.listarAlumnos(), "Alumnos Inscriptos - PROYECTO FINAL");
    }
}