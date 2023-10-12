/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniverdadAccesoDatos;

import Universidad.Entidades.Inscripcion;
import Universidad.Entidades.Materia;
import Universidad.Entidades.Alumno;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Emanuel Sosa
 */
public class InscripcionData {

    private Connection con;
    private AlumnoData aluData;
    private MateriaData matData;

    public InscripcionData() {
    }

    public void gaurdarInscripcion(Inscripcion insc) {
    }

    List<Inscripcion> obtenerInscripciones() {
        return null;
    }

    List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        return null;
    }

    List<Materia> obtenerMaterias(int id) {
        return null;
    }

    List<Materia> obtenerMateriasNOcursadas(int id) {
        return null;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumnom, int idMateria) {
    }

    public void actualizarNota(int idAlumnom, int idMateria, double nota) {

    }

    List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        return null;
    }
}
