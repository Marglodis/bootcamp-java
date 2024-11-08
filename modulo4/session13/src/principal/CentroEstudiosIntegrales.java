package principal;

import almacenamiento.BaseDatos;
import almacenamiento.ExcelLoader;
import models.Alumno;
import models.Curso;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CentroEstudiosIntegrales {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BaseDatos baseDeDatos = new BaseDatos();


    public static void main(String[] args) {
        // Cargar los datos desde los archivos Excel
        ExcelLoader excelLoader = new ExcelLoader(baseDeDatos);
        excelLoader.cargarCursosDesdeExcel("archivos/Cursos.xlsx");
        excelLoader.cargarAlumnosDesdeExcel("archivos/Alumnos.xlsx");

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarCursosDisponibles();
                    break;
                case 2:
                    matricularNuevoAlumno();
                    break;
                case 3:
                    agregarNuevoCurso();
                    break;
                case 4:
                    asignarCursoAAlumno();
                    break;
                case 5:
                    verAlumnosPorCurso();
                    break;
                case 6:
                    mostrarAlumnosCargados();  // Nueva opción
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Aplicación cerrada.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Mostrar cursos disponibles");
        System.out.println("2. Matricular nuevo alumno");
        System.out.println("3. Agregar nuevo curso");
        System.out.println("4. Asignar curso a un alumno");
        System.out.println("5. Ver la lista completa de los cursos y los alumnos que tomaron ese curso");
        System.out.println("6. Mostrar alumnos cargados");  // Nueva opción
        System.out.println("7. Cerrar la aplicación");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarCursosDisponibles() {
        List<Curso> cursos = baseDeDatos.obtenerCursos();
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
        } else {
            cursos.forEach(System.out::println);
        }
    }

    private static void mostrarAlumnosCargados() {
        List<Alumno> alumnos = baseDeDatos.obtenerAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos cargados.");
        } else {
            alumnos.forEach(System.out::println);
        }
    }
    private static void matricularNuevoAlumno() {
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (yyyy-mm-dd): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

        Alumno alumno = new Alumno(nombre, rut, fechaNacimiento);
        baseDeDatos.agregarAlumno(alumno);
        System.out.println("Alumno matriculado exitosamente.");
    }

    private static void agregarNuevoCurso() {
        System.out.print("Ingrese el nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del curso: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese la descripción del curso: ");
        String descripcion = scanner.nextLine();

        Curso curso = new Curso(nombre, codigo, descripcion);
        baseDeDatos.agregarCurso(curso);
        System.out.println("Curso agregado exitosamente.");
    }

    private static void asignarCursoAAlumno() {
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();
        Alumno alumno = baseDeDatos.obtenerAlumnos().stream()
                .filter(a -> a.getRut().equals(rut))
                .findFirst()
                .orElse(null);

        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        System.out.print("Ingrese el código del curso: ");
        String codigo = scanner.nextLine();
        Curso curso = baseDeDatos.obtenerCursos().stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        baseDeDatos.matricularAlumnoEnCurso(alumno, curso);
        System.out.println("Alumno matriculado en el curso con éxito.");
    }

    private static void verAlumnosPorCurso() {
        System.out.print("Ingrese el código del curso: ");
        String codigo = scanner.nextLine();
        Curso curso = baseDeDatos.obtenerCursos().stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        List<Alumno> alumnosCurso = baseDeDatos.obtenerAlumnosPorCurso(curso);
        if (alumnosCurso.isEmpty()) {
            System.out.println("No hay alumnos matriculados en este curso.");
        } else {
            alumnosCurso.forEach(System.out::println);
        }
    }
}
