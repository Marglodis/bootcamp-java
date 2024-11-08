package almacenamiento;

import models.Alumno;
import models.Curso;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class ExcelLoader {

    private BaseDatos baseDeDatos;

    public ExcelLoader(BaseDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    // Cargar cursos desde un archivo Excel
    public void cargarCursosDesdeExcel(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(new File(rutaArchivo))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);  // Primera hoja (Cursos)
            Iterator<Row> rowIterator = sheet.iterator();

            // Saltamos la primera fila (encabezados)
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Verificar y obtener los valores de cada celda
                String nombre = getStringCellValue(row.getCell(0));
                String codigo = getStringCellValue(row.getCell(1));
                String descripcion = getStringCellValue(row.getCell(2));
                String duracion = getStringCellValue(row.getCell(3));

                // Crear un nuevo curso y agregarlo a la base de datos
                Curso curso = new Curso(nombre, codigo, descripcion + " " + duracion);
                baseDeDatos.agregarCurso(curso);
            }

            workbook.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de cursos: " + e.getMessage());
        }
    }

    // Cargar alumnos desde un archivo Excel
    public void cargarAlumnosDesdeExcel(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(new File(rutaArchivo))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);  // Primera hoja (Alumnos)
            Iterator<Row> rowIterator = sheet.iterator();

            // Saltamos la primera fila (encabezados)
            rowIterator.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Verificar y obtener los valores de cada celda
                String nombre = getStringCellValue(row.getCell(0));
                String rut = getStringCellValue(row.getCell(1));
                LocalDate fechaNacimiento = getFechaCellValue(row.getCell(2), formatter);

                // Crear un nuevo alumno y agregarlo a la base de datos
                Alumno alumno = new Alumno(nombre, rut, fechaNacimiento);
                baseDeDatos.agregarAlumno(alumno);
            }

            workbook.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de alumnos: " + e.getMessage());
        }
    }

    // Método para obtener el valor de una celda como String
    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    // Método para obtener el valor de una celda como LocalDate (para fechas)
    private LocalDate getFechaCellValue(Cell cell, DateTimeFormatter formatter) {
        if (cell == null) {
            return null;
        }

        if (cell.getCellType() == CellType.STRING) {
            // Si la celda contiene una fecha como String, intentar convertirla
            String fechaStr = cell.getStringCellValue();
            return LocalDate.parse(fechaStr, formatter);
        } else if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            // Si la celda es numérica y está formateada como fecha
            return cell.getDateCellValue().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        }
        return null;
    }

    // Guardar los cursos en el archivo Excel
    public void guardarCursosEnExcel(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(new File(rutaArchivo))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre la lista de cursos y agregar nuevas filas
            int lastRowNum = sheet.getLastRowNum();
            for (Curso curso : baseDeDatos.obtenerCursos()) {
                Row row = sheet.createRow(lastRowNum + 1);
                row.createCell(0).setCellValue(curso.getNombre());
                row.createCell(1).setCellValue(curso.getCodigo());
                row.createCell(2).setCellValue(curso.getDescripcion());
                row.createCell(3).setCellValue("");  // Columna de duración vacía o puedes completar con alguna duración.
                lastRowNum++;
            }

            // Escribir los cambios de vuelta al archivo
            try (FileOutputStream fos = new FileOutputStream(new File(rutaArchivo))) {
                workbook.write(fos);
            }

            workbook.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los cursos en el archivo: " + e.getMessage());
        }
    }

    // Guardar los alumnos en el archivo Excel
    public void guardarAlumnosEnExcel(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(new File(rutaArchivo))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre la lista de alumnos y agregar nuevas filas
            int lastRowNum = sheet.getLastRowNum();
            for (Alumno alumno : baseDeDatos.obtenerAlumnos()) {
                Row row = sheet.createRow(lastRowNum + 1);
                row.createCell(0).setCellValue(alumno.getNombre());
                row.createCell(1).setCellValue(alumno.getRut());
                row.createCell(2).setCellValue(alumno.getFechaNacimiento().toString());
                lastRowNum++;
            }

            // Escribir los cambios de vuelta al archivo
            try (FileOutputStream fos = new FileOutputStream(new File(rutaArchivo))) {
                workbook.write(fos);
            }

            workbook.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los alumnos en el archivo: " + e.getMessage());
        }
    }
}
