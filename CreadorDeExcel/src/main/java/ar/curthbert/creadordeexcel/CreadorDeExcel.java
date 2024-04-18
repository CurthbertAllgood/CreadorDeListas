package ar.curthbert.creadordeexcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreadorDeExcel {
    public static void main(String[] args) {
        // Especifica la ruta del directorio
        Path directoryPath = Paths.get("C:\\Users\\ferna\\Downloads");

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream("nombres_archivos.xlsx")) {

            // Crea una nueva hoja en el libro de trabajo
            Sheet sheet = workbook.createSheet("Nombres de archivos");

            int rowNum = 0;

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
                // Itera sobre todos los archivos en el directorio
                for (Path filePath : stream) {
                    // Crea una nueva fila en la hoja
                    Row row = sheet.createRow(rowNum++);
                    // Crea una celda y escribe el nombre del archivo en ella
                    Cell cell = row.createCell(0);
                    cell.setCellValue(filePath.getFileName().toString());
                }
            }

            // Escribe el libro de trabajo en un archivo Excel
            workbook.write(fileOut);
            System.out.println("Archivo Excel generado correctamente.");

        } catch (IOException e) {
            // Manejo de excepciones si ocurre un error al acceder al directorio o al escribir en el archivo Excel
            e.printStackTrace();
        }
    }
}
