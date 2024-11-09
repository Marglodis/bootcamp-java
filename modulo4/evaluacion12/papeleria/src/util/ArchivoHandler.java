package util;

import modelos.Producto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArchivoHandler {
    public static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        String rutaArchivo = "papeleria/archivos/productos.xlsx";
        try (FileInputStream fis = new FileInputStream(new File(rutaArchivo));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if(row != null)
                {
                    String nombre = "";
                    Cell nombreCell = row.getCell(0);
                    if(nombreCell !=null && nombreCell.getCellType() == CellType.STRING){
                        nombre = nombreCell.getStringCellValue();
                    }

                    double precio = 0.0;
                    Cell precioCell = row.getCell(1);
                    if (precioCell != null) {
                        if (precioCell.getCellType() == CellType.NUMERIC) {
                            // Si la celda es numérica, leer el valor numérico
                            precio = precioCell.getNumericCellValue();
                        } else if (precioCell.getCellType() == CellType.STRING) {
                            // Si la celda es texto, intentar convertirlo a numérico
                            String precioStr = precioCell.getStringCellValue().trim();
                            try {
                                precio = Double.parseDouble(precioStr);
                            } catch (NumberFormatException e) {
                                // Si no se puede convertir, asignar 0.0 o manejar el error
                                System.out.println("Error al convertir precio: " + precioStr);
                            }
                        }
                    }

                    String codigo = "";
                    Cell codigoCell = row.getCell(2);
                    if (codigoCell != null && codigoCell.getCellType() == CellType.STRING) {
                        codigo = codigoCell.getStringCellValue();
                    }
                    productos.add(new Producto(nombre, precio, codigo));
                }
            }
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error al cargar productos desde el Excel." + e);
        }
        return productos;
    }
}
