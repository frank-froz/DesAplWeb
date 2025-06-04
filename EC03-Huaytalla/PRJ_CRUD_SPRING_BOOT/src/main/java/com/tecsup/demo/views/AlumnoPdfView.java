package com.tecsup.demo.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter; // Para formatear la fecha

import com.tecsup.demo.domain.entities.Alumno;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("alumno/verAlumno") // Nombre de la vista cambiado
public class AlumnoPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Alumno> alumnos = (List<Alumno>) model.get("alumnos");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        // Título de la tabla
        PdfPCell cell = null;
        cell = new PdfPCell(new Phrase("Lista de Alumnos"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        // Tabla de alumnos
        PdfPTable tabla2 = new PdfPTable(5); // 5 columnas (id, nombres, apellidos, fecha de nacimiento, sexo)

        // Encabezado de la tabla
        tabla2.addCell("ID");
        tabla2.addCell("Nombres");
        tabla2.addCell("Apellidos");
        tabla2.addCell("Fecha Nacimiento");
        tabla2.addCell("Sexo");

        // Formateador de fecha
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Llenar la tabla con los datos de los alumnos
        for (Alumno alumno : alumnos) {
            tabla2.addCell(String.valueOf(alumno.getId()));
            tabla2.addCell(alumno.getNombres());
            tabla2.addCell(alumno.getApellidos());
            tabla2.addCell(alumno.getFechanacimiento().format(dateFormatter)); // Formateo de fecha
            tabla2.addCell(alumno.getSexo());
        }

        // Agregar la tabla al documento
        document.add(tabla);
        document.add(tabla2);
    }
}
