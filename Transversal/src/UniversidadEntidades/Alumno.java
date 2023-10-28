/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEntidades;

import java.time.LocalDate;

/**
 *
 * @author Marcos
 */
public class Alumno {
    private int idAlumno;
    private int Dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(int idAlumno, int Dni, String apellido, String nombre, LocalDate fechaDeNacimiento, boolean estado) {
        this.idAlumno = idAlumno;
        this.Dni = Dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public Alumno(int Dni, String apellido, String nombre, LocalDate fechaDeNacimiento, boolean estado) {
        this.Dni = Dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public Alumno(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public boolean isActivo() {
        return estado;
    }

    public void setActivo(boolean activo) {
        this.estado = estado;
    }

    @Override
    public String toString() {
return idAlumno +" " +nombre+" " +apellido;
    }
}
