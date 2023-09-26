package codoacodo;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;
public class GestionAlumno {
    List<Alumno> listaAlumnos;
    static GestionArchivo gestionArchivo = new GestionArchivo();
    public GestionAlumno() {
        this.listaAlumnos = gestionArchivo.leerAltas();
    }
    public List<Alumno> leerArchivo(){
        listaAlumnos = gestionArchivo.leerAltas();
        return listaAlumnos;
    }
    public Alumno altaAlumno() {
        int  comision = 3, validacion = 3, agregar = 3, dni;
        String nombre, apellido, mail;
        do {
            nombre = Interfaz.agregarAlumno("Ingrese el Nombre:", "Alta Alumno - PROYECTO FINAL");
            validacion = validarNombre(nombre);
        } while (validacion == 0);
        do {
            apellido = Interfaz.agregarAlumno("Ingrese el Apellido:", "Alta Alumno - PROYECTO FINAL");
            validacion = validarApellido(apellido);
        } while (validacion == 0);
        do {
            mail = Interfaz.agregarAlumno("Ingrese un correo electrónico:", "Alta Alumno - PROYECTO FINAL");
            validacion = validarMail(mail);
        } while (validacion == 0);
        do {
            dni = Integer.parseInt((Interfaz.agregarAlumno("Ingrese un DNI:", "Alta Alumno - PROYECTO FINAL")));
            validacion = validarDni(dni);
        } while (validacion == 0);
        comision = Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "Seleccione una Comisión",
                "Alta Alumno - PROYECTO FINAL", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"23428", "23429", "23440"}, "")));
        if (comision == 0) {
            comision = 23428;
        } else if (comision == 1) {
            comision = 23429;
        } else if (comision == 2) {
            comision = 23440;
        }
        Alumno alumno = new Alumno(nombre, apellido, mail, dni, comision);
        agregar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea agregar al Alumno?" + "\n" + alumno,
                "Alta Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                new String[]{"Agregar", "Cancelar"}, "")));
        if (agregar == 0) {
            agregar = 1;
        } else if (agregar == 1) {
            agregar = 2;
        }
        if (agregar == 1) {
            listaAlumnos.add(alumno);
            gestionArchivo.altaAlumno(alumno);
            JOptionPane.showMessageDialog(null,"Se ha agregado al alumno con éxito: \n\n".concat(listarAlumnos())+"\n","Alta Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Se ha cancelado el alta del alumno con éxito.",
                    "Alta Alumno - PROYECTO FINAL", 2);
        }
        return alumno;
    }
    public void modificarAlumno(){
        int dni = 0, validacion, comision = 0, datoModificar, confirmar, indiceModificar;
        String nombre = null, apellido = null, mail = null;
        indiceModificar = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice de Alumno a modificar:\n\n".concat(listarAlumnos()) + "\n",
                "Modificar Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE));
        List<Alumno> alumnoEncontrado = new ArrayList<Alumno>();
        List<Alumno> alumnoTxt = new ArrayList<Alumno>();
        for (Alumno alumno : listaAlumnos) {
            if (listaAlumnos.indexOf(alumno) == (indiceModificar-1)){
                alumnoEncontrado.add(alumno);
                alumnoTxt.add(alumno);
            }
        }
        datoModificar = Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog( null,"Seleccione el dato que desea modificar del Alumno:" + "\n" + alumnoEncontrado + "\n",
                "Modificar Alumno - PROYECTO FINAL",JOptionPane.YES_NO_CANCEL_OPTION, -1,null,
                new Object[] { "Nombre", "Apellido", "Correo Elctrónico", "DNI", "Comision"},"Comision")));
        if (datoModificar == 0){
            datoModificar = 1;
        } else if (datoModificar == 1) {
            datoModificar = 2;
        } else if (datoModificar == 2) {
            datoModificar = 3;
        } else if (datoModificar == 3) {
            datoModificar = 4;
        } else if (datoModificar == 4) {
            datoModificar = 5;
        }
        List<Alumno> alumnoModificado = new ArrayList<Alumno>();
        //Modificar Nombre
        if (datoModificar == 1){
            do {
                nombre = Interfaz.modificarAlumno("Ingrese el nuevo nombre:", "Modificar Alumno - PROYECTO FINAL");
                validacion = validarNombre(nombre);
            }while (validacion == 0);
            for (Alumno alumno : alumnoEncontrado) {
                if (alumnoEncontrado.indexOf(alumno) == 0){
                    alumno.setNombre(nombre);
                    alumnoModificado.add(alumno);
                }
            }
            confirmar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea confirmar estos cambios?" + "\n" + alumnoModificado,
                    "Modificar Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                    new String[]{"Confirmar","Cancelar"}, "")));
            if (confirmar == 0){
                for (Alumno a : listaAlumnos) {
                    if (listaAlumnos.indexOf(a) == (indiceModificar-1)){
                        a.setNombre(nombre);
                        Alumno alumnoModif= new Alumno(a.getNombre(),a.getApellido(),a.getMail(), a.getDni(), a.getComision());
                       listaAlumnos.set((indiceModificar-1),alumnoModif);
                        gestionArchivo.actualizarArchivoTxt(listaAlumnos);
                        JOptionPane.showMessageDialog(null,"Se ha modificado al alumno con éxito: \n\n".concat(listarAlumnos())+"\n","Modificar Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado la modificación del alumno con éxito.",
                        "Modificar Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Modificar Apellido
        if (datoModificar == 2){
            do {
                apellido = Interfaz.modificarAlumno("Ingrese el nuevo apellido:", "Modificar Alumno - PROYECTO FINAL");
                validacion = validarApellido(apellido);
            }while (validacion == 0);
            for (Alumno alumno : alumnoEncontrado) {
                if (alumnoEncontrado.indexOf(alumno) == 0){
                    alumno.setApellido(apellido);
                    alumnoModificado.add(alumno);
                }
            }
            confirmar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea confirmar estos cambios?" + "\n" + alumnoModificado,
                    "Modificar Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                    new String[]{"Confirmar","Cancelar"}, "")));
            if (confirmar == 0){
                for (Alumno a : listaAlumnos) {
                    if (listaAlumnos.indexOf(a) == (indiceModificar-1)){
                        a.setApellido(apellido);
                        Alumno alumnoModif= new Alumno(a.getNombre(),a.getApellido(),a.getMail(), a.getDni(), a.getComision());
                        listaAlumnos.set((indiceModificar-1),alumnoModif);
                        gestionArchivo.actualizarArchivoTxt(listaAlumnos);
                        JOptionPane.showMessageDialog(null,"Se ha modificado al alumno con éxito: \n\n".concat(listarAlumnos())+"\n","Modificar Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado la modificación del alumno con éxito.",
                        "Modificar Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Modificar email
        if (datoModificar == 3){
            do {
                mail = Interfaz.modificarAlumno("Ingrese el nuevo correo electrónico:", "Modificar Alumno - PROYECTO FINAL");
                validacion = validarMail(mail);
            }while (validacion == 0);
            for (Alumno alumno : alumnoEncontrado) {
                if (alumnoEncontrado.indexOf(alumno) == 0){
                    alumno.setMail(mail);
                    alumnoModificado.add(alumno);
                }
            }
            confirmar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea confirmar estos cambios?" + "\n" + alumnoModificado,
                    "Modificar Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                    new String[]{"Confirmar","Cancelar"}, "")));
            if (confirmar == 0){
                for (Alumno a : listaAlumnos) {
                    if (listaAlumnos.indexOf(a) == (indiceModificar-1)){
                        a.setMail(mail);
                        Alumno alumnoModif= new Alumno(a.getNombre(),a.getApellido(),a.getMail(), a.getDni(), a.getComision());
                        listaAlumnos.set((indiceModificar-1),alumnoModif);
                        gestionArchivo.actualizarArchivoTxt(listaAlumnos);
                        JOptionPane.showMessageDialog(null,"Se ha modificado al alumno con éxito: \n\n".concat(listarAlumnos())+"\n","Modificar Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado la modificación del alumno con éxito.",
                        "Modificar Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Modificar DNI
        if (datoModificar == 4){
            do {
                dni = Integer.parseInt(Interfaz.modificarAlumno("Ingrese el nuevo DNI:", "Modificar Alumno - PROYECTO FINAL"));
                validacion = validarDni(dni);
            }while (validacion == 0);
            for (Alumno alumno : alumnoEncontrado) {
                if (alumnoEncontrado.indexOf(alumno) == 0){
                    alumno.setDni(dni);
                    alumnoModificado.add(alumno);
                }
            }
            confirmar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea confirmar estos cambios?" + "\n" + alumnoModificado,
                    "Modificar Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                    new String[]{"Confirmar","Cancelar"}, "")));
            if (confirmar == 0){
                for (Alumno a : listaAlumnos) {
                    if (listaAlumnos.indexOf(a) == (indiceModificar-1)){
                        a.setDni(dni);
                        Alumno alumnoModif= new Alumno(a.getNombre(),a.getApellido(),a.getMail(), a.getDni(), a.getComision());
                        listaAlumnos.set((indiceModificar-1),alumnoModif);
                        gestionArchivo.actualizarArchivoTxt(listaAlumnos);
                        JOptionPane.showMessageDialog(null,"Se ha modificado al alumno con éxito: \n\n".concat(listarAlumnos())+"\n","Modificar Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado la modificación del alumno con éxito.",
                        "Modificar Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Modificar Comision
        if (datoModificar == 5){
            comision = Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog( null,"Seleccione una nueva Comisión",
                    "Modificar Alumno - PROYECTO FINAL",JOptionPane.YES_NO_CANCEL_OPTION, -1,null,
                    new Object[] { "23428", "23429", "23440"},"")));
            if (comision == 0){
                comision = 23428;
            } else if (comision == 1) {
                comision = 23429;
            } else if (comision == 2) {
                comision = 23440;
            }
            for (Alumno alumno : alumnoEncontrado) {
                if (alumnoEncontrado.indexOf(alumno) == 0){
                    alumno.setComision(comision);
                    alumnoModificado.add(alumno);
                }
            }
            confirmar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Desea confirmar estos cambios?" + "\n" + alumnoModificado,
                    "Modificar Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                    new String[]{"Confirmar","Cancelar"}, "")));
            if (confirmar == 0){
                for (Alumno a : listaAlumnos) {
                    if (listaAlumnos.indexOf(a) == (indiceModificar-1)){
                        a.setDni(dni);
                        Alumno alumnoModif= new Alumno(a.getNombre(),a.getApellido(),a.getMail(), a.getDni(), a.getComision());
                        listaAlumnos.set((indiceModificar-1),alumnoModif);
                        gestionArchivo.actualizarArchivoTxt(listaAlumnos);
                        JOptionPane.showMessageDialog(null,"Se ha modificado al alumno con éxito: \n\n".concat(listarAlumnos())+"\n","Modificar Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado la modificación del alumno con éxito.",
                        "Modificar Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public String listarAlumnos(){
        String salida = "";
        int i;
        for (i = 0; i < listaAlumnos.size(); i++){
            salida = salida + (i+1) + ") " + listaAlumnos.get(i) + "\n";
        }
        return salida;
    }
    public void borrarAlumno(){
        int indiceDelete, confirmar;
        String  indiceBorrar;
        indiceBorrar = JOptionPane.showInputDialog(null,"Ingrese el indice de Alumno a borrar:\n\n".concat(listarAlumnos()) + "\n",
                "Baja de Alumno - PROYECTO FINAL",JOptionPane.PLAIN_MESSAGE);
        indiceDelete = Integer.parseInt(indiceBorrar);
        List<Alumno> alumnoEncontrado = new ArrayList<Alumno>();
        for (Alumno a : listaAlumnos) {
            if (listaAlumnos.indexOf(a) == (indiceDelete-1)){
                alumnoEncontrado.add(a);
            }
        }
        confirmar = parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "¿Está seguro que desea dar de baja este alumno?" + "\n" + alumnoEncontrado + "\n",
                "Baja de Alumno - PROYECTO FINAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,
                new String[]{"Confirmar","Cancelar"}, "")));
        if (confirmar == 0){
            for (Alumno a : listaAlumnos) {
                if (listaAlumnos.indexOf(a) == (indiceDelete-1)){
                    listaAlumnos.remove(indiceDelete-1);
                    gestionArchivo.actualizarArchivoTxt(listaAlumnos);
                    JOptionPane.showMessageDialog(null, "Se ha dado de baja al alumno con éxito.", "Baja de Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (confirmar == 1) {
            JOptionPane.showMessageDialog(null, "Se ha cancelado la baja del alumno con éxito.",
                    "Baja de Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void buscarAlumno(){
        int dni = 0, validacion;
        do {
            dni = Integer.parseInt((Interfaz.buscarAlumno("Ingrese un DNI para buscar:", "Buscar Alumno - PROYECTO FINAL")));
            validacion = validarDni(dni);
        }while (validacion == 0);
        List<Alumno> alumnoEncontrado = new ArrayList<Alumno>();
        for (Alumno a : listaAlumnos) {
            if (a.getDni() == dni){
                alumnoEncontrado.add(a);
            }
        }
        JOptionPane.showMessageDialog(null, "El alumno encontrado es:" + '\n' + alumnoEncontrado, "Buscar Alumno - PROYECTO FINAL", JOptionPane.WARNING_MESSAGE);
    }
    private static int validarNombre(String nombre){
        if ((nombre.length() > 1) && (nombre.length() < 40)){
            return 1;
        }else {
            JOptionPane.showMessageDialog(null,"Dato ingresado inválido. Vuelva a ingresarlo.",
                    "Alta Alumno - Aula Virtual", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    private static int validarApellido(String apellido){
        if (apellido.length() > 1 && apellido.length() < 100){
            return 1;
        }else {
            JOptionPane.showMessageDialog(null,"Dato ingresado inválido. Vuelva a ingresarlo.",
                    "Alta Alumno - Aula Virtual", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    private static int validarMail(String mail){
        if (mail.contains("@")){
            return 1;
        }else {
            JOptionPane.showMessageDialog(null,"Dato ingresado inválido. Debe contener @.",
                    "Alta Alumno - Aula Virtual", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    private static int validarDni(int dni){
        int numDni = dni;
        String dniCadena= String.valueOf(numDni);
        if (dniCadena.length() !=8 ){
            JOptionPane.showMessageDialog(null,"Dato ingresado inválido. Vuelva a ingresarlo.",
                    "Alta Alumno - Aula Virtual", JOptionPane.ERROR_MESSAGE);
            return 0;
        }else {
            return 1;
        }
    }
}