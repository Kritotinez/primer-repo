package codoacodo;
import javax.swing.*;
public class Interfaz {
    public static String mensajeMenu(String mensaje, String titulo) {
        ImageIcon icono = new ImageIcon("Imagenes/cacsolo.png");
        icono = new ImageIcon(icono.getImage().getScaledInstance(90, 50, java.awt.Image.SCALE_SMOOTH));
        return (String) JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, icono, null, null);
    }
    public static String agregarAlumno(String mensaje, String titulo) {
        ImageIcon icono = new ImageIcon("Imagenes/agregarAlumno.png");
        icono = new ImageIcon(icono.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        return (String) JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, icono, null, null);
    }
    public static String modificarAlumno(String mensaje, String titulo) {
        ImageIcon icono = new ImageIcon("Imagenes/modificarAlumno.png");
        icono = new ImageIcon(icono.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        return (String) JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, icono, null, null);
    }
    public static String buscarAlumno(String mensaje, String titulo) {
        ImageIcon icono = new ImageIcon("Imagenes/buscarAlumno.png");
        icono = new ImageIcon(icono.getImage().getScaledInstance(85, 60, java.awt.Image.SCALE_SMOOTH));
        return (String) JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, icono, null, null);
    }
    public static void mostrarLista(String cadena, String titulo) {
        ImageIcon icono = new ImageIcon("Imagenes/listarAlumnos.png");
        icono = new ImageIcon(icono.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null, cadena, titulo, JOptionPane.INFORMATION_MESSAGE, icono);
    }
}