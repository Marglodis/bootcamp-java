package almacenamiento;

import models.Alumno;
import models.Curso;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    private List<Curso> cursos = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();  // Lista para llevar registro de las matriculas

    // Agregar un nuevo curso a la base de datos
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    // Agregar un nuevo alumno a la base de datos
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    // Obtener todos los cursos
    public List<Curso> obtenerCursos() {
        return cursos;
    }

    // Obtener todos los alumnos
    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    // Matricular un alumno en un curso
    public void matricularAlumnoEnCurso(Alumno alumno, Curso curso) {
        // Verificamos si el alumno ya está matriculado en el curso
        if (!isAlumnoMatriculado(alumno, curso)) {
            Matricula matricula = new Matricula(alumno, curso);
            matriculas.add(matricula);
        }
    }

    // Obtener la lista de alumnos matriculados en un curso
    public List<Alumno> obtenerAlumnosPorCurso(Curso curso) {
        List<Alumno> alumnosEnCurso = new ArrayList<>();
        for (Matricula matricula : matriculas) {
            if (matricula.getCurso().equals(curso)) {
                alumnosEnCurso.add(matricula.getAlumno());
            }
        }
        return alumnosEnCurso;
    }

    // Verificar si un alumno ya está matriculado en un curso
    private boolean isAlumnoMatriculado(Alumno alumno, Curso curso) {
        for (Matricula matricula : matriculas) {
            if (matricula.getAlumno().equals(alumno) && matricula.getCurso().equals(curso)) {
                return true;
            }
        }
        return false;
    }

    // Clase interna para registrar la matricula de un alumno en un curso
    public static class Matricula {
        private Alumno alumno;
        private Curso curso;

        public Matricula(Alumno alumno, Curso curso) {
            this.alumno = alumno;
            this.curso = curso;
        }

        public Alumno getAlumno() {
            return alumno;
        }

        public Curso getCurso() {
            return curso;
        }
    }
}
