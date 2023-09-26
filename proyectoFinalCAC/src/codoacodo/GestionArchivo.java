package codoacodo;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GestionArchivo {
    public static final String FILE_PATH = "altasAlumnos.txt";
    public void altaAlumno(Alumno alumno){
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(FILE_PATH, true))){
            buffer.write(alumno.getNombre() + ", " + alumno.getApellido() + ", " + alumno.getMail() + ", " + alumno.getDni() + ", " + alumno.getComision());
            buffer.newLine();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo " + e.getMessage(), "PROYECTO FINAL - Aula Virtual", JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<Alumno> leerAltas(){
        List<Alumno> alumnosAlta = new ArrayList<>();
        try (BufferedReader leer = new BufferedReader(new FileReader(FILE_PATH))){
            String linea;
            while ((linea = leer.readLine()) != null){
                String [] datos = linea.split(", ");
                Alumno alumno = new Alumno(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                alumnosAlta.add(alumno);
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo " + e.getMessage(), "Aula Virtual CAC Inicial", 0);
        }
        return alumnosAlta;
    }
    public static  int actualizarArchivoTxt(List<Alumno> listaAlumnos){
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Alumno alumno : listaAlumnos){
                buffer.write(alumno.getNombre() + ", " + alumno.getApellido() + ", " + alumno.getMail() + ", " + alumno.getDni() + ", " + alumno.getComision());
                buffer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo: " + e.getMessage(), "Eliminando Alumno...", JOptionPane.ERROR_MESSAGE, null);
        }
        return 1;
    }
}

