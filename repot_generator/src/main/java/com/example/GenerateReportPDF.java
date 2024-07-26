package com.example;

import java.io.FileOutputStream;
import java.sql.*;
import java.awt.Desktop;
import java.io.File;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

public class GenerateReportPDF {

    GenerateReportPDF(String reg_no) {
        Database db = new Database();
        ResultSet rs = db.RetrieveRecord(reg_no, 0);

        try {
            String name = rs.getString("Name");
            String dept = rs.getString("Department");
            String fathers_name = rs.getString("Fathers_name");
            String roll_no = rs.getString("Roll_no");
            String section = rs.getString("section");
            String address = rs.getString("Address");
            String mobile = rs.getString("mobile");

            // Create PDF document
            String filePath = "repot_generator/PDFs/" + reg_no + ".pdf";
            PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Set up fonts
            PdfFont fontname_Helvetica = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont fontNormal = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            // Header
            Paragraph header = new Paragraph("Lovely Professional University")
                    .setFont(fontname_Helvetica)
                    .setFontSize(26)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(header);
            document.add(new Paragraph("\n\n"));

            // Add student information
            Table table0 = new Table(UnitValue.createPercentArray(new float[] { 1, 2, 2 })).useAllAvailableWidth();

            // Add image to the table with rowspan and specific size
            Image img = new Image(
                    ImageDataFactory.create("D:/Report Generator/images/image.png"))
                    .scaleToFit(100, 100);
            Cell imageCell = new Cell(8, 1).add(img).setBorder(null);
            table0.addCell(imageCell);

            // Add student details cells
            table0.addCell(new Cell().add(new Paragraph("Name: " + name).setFont(fontNormal)).setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Department: " + dept).setFont(fontNormal)).setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Father's Name: " + fathers_name).setFont(fontNormal))
                    .setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Reg No: " + reg_no).setFont(fontNormal)).setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Roll No: " + roll_no).setFont(fontNormal)).setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Section: " + section).setFont(fontNormal)).setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Mobile: " + mobile).setFont(fontNormal)).setBorder(null));
            table0.addCell(new Cell().add(new Paragraph("Address: " + address).setFont(fontNormal)).setBorder(null));

            document.add(table0);

            // Add a space before the next table
            document.add(new Paragraph("\n"));

            // Add table with student grades
            float[] columnWidths = { 3, 5, 1, 1, 1, 1, 1, 1 };
            Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();

            // Add table headers
            table.addHeaderCell(new Paragraph("Course Code").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("Course Title").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("CA1").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("CA2").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("CA3").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("MTE").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("ETE").setFont(fontNormal));
            table.addHeaderCell(new Paragraph("Grade").setFont(fontNormal));

            rs = db.RetrieveRecord(reg_no, 1);
            GenerateGrade generateGrade = new GenerateGrade();

            while (rs.next()) {
                String course_code = rs.getString("course_code");
                String course_name = rs.getString("course");
                int CA1 = rs.getInt("CA1");
                int CA2 = rs.getInt("CA2");
                int CA3 = rs.getInt("CA3");
                int MTE = rs.getInt("MTE");
                int ETE = rs.getInt("ETE");
                String grade = generateGrade.grade(CA1, CA2, CA3, MTE, ETE);

                table.addCell(new Paragraph(course_code).setFont(fontNormal));
                table.addCell(new Paragraph(course_name).setFont(fontNormal));
                table.addCell(new Paragraph(Integer.toString(CA1)).setFont(fontNormal));
                table.addCell(new Paragraph(Integer.toString(CA2)).setFont(fontNormal));
                table.addCell(new Paragraph(Integer.toString(CA3)).setFont(fontNormal));
                table.addCell(new Paragraph(Integer.toString(MTE)).setFont(fontNormal));
                table.addCell(new Paragraph(Integer.toString(ETE)).setFont(fontNormal));
                table.addCell(new Paragraph(grade).setFont(fontNormal));
            }

            // Add the table to the document
            document.add(table);

            // Close the document
            document.close();
            System.out.println("PDF generated successfully.");

            // Open the PDF file
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(new File(filePath));
                }
            }
        } catch (SQLException e) {
            System.out.println("Sql Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenerateReportPDF("CS202113");
    }
}
