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
    private String apellido;
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(String apellido, String nombre, LocalDate fechaNacimiento, boolean activo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNacimiento, boolean activo) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaNacimiento;
        this.estado = estado;
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

    public LocalDate getFechaNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaDeNacimiento = fechaNacimiento;
    }

    public boolean isActivo() {
        return estado;
    }

    public void setActivo(boolean activo) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento=" + fechaDeNacimiento + ", activo=" + estado + '}';
    }
    
}
