package com.tecsup.demo.views;

import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter; // Para formatear la fecha

import com.tecsup.demo.domain.entities.Alumno;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("alumno/verAlumno.xlsx") // Nombre de la vista cambiado
public class AlumnoXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"alumno_view.xlsx\""); // Nombre del archivo Excel
        List<Alumno> alumnos = (List<Alumno>) model.get("alumnos"); // Obtenemos los alumnos desde el modelo
        Sheet sheet = workbook.createSheet("Lista de Alumnos");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Lista de Alumnos");

        row = sheet.createRow(1);
        cell = row.createCell(0);

        // Estilo para la cabecera de la tabla
        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Estilo para las celdas del cuerpo
        CellStyle tbodyStyle = workbook.createCellStyle();
        tbodyStyle.setBorderBottom(BorderStyle.THIN);
        tbodyStyle.setBorderTop(BorderStyle.THIN);
        tbodyStyle.setBorderRight(BorderStyle.THIN);
        tbodyStyle.setBorderLeft(BorderStyle.THIN);

        // Cabecera
        Row header = sheet.createRow(4);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombres");
        header.createCell(2).setCellValue("Apellidos");
        header.createCell(3).setCellValue("Fecha Nacimiento");
        header.createCell(4).setCellValue("Sexo");

        header.getCell(0).setCellStyle(theaderStyle);
        header.getCell(1).setCellStyle(theaderStyle);
        header.getCell(2).setCellStyle(theaderStyle);
        header.getCell(3).setCellStyle(theaderStyle);
        header.getCell(4).setCellStyle(theaderStyle);

        // Formateador para la fecha
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int rownum = 6;

        // Iteración sobre los alumnos y creación de filas
        for (Alumno alumno : alumnos) {
            Row fila = sheet.createRow(rownum++);
            cell = fila.createCell(0);
            cell.setCellValue(alumno.getId());
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(1);
            cell.setCellValue(alumno.getNombres());
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(2);
            cell.setCellValue(alumno.getApellidos());
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(3);
            cell.setCellValue(alumno.getFechanacimiento().format(dateFormatter)); // Formateamos la fecha
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(4);
            cell.setCellValue(alumno.getSexo());
            cell.setCellStyle(tbodyStyle);
        }
    }
}
