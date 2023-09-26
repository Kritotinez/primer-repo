package codoacodo;

public class Alumno {
    private String nombre;
    private String apellido;
    private String mail;
    private int dni;
    private int comision;
    public Alumno(String nombre, String apellido, String mail, int dni, int comision) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.dni = dni;
        this.comision = comision;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getComision() {
        return comision;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return nombre + ", " + apellido + " - " + mail + " - DNI N°" + dni + "; Comision " + comision;
    }
}
