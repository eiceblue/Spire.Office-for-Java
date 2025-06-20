import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendColumnChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Column chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a column chart shape to the paragraph with specified width and height
        ShapeObject shape = newPara.appendChart(ChartType.Column, 500, 300);

        // Get the chart object from the shape
        Chart chart = shape.getChart();

        // Clear any existing series in the chart
        chart.getSeries().clear();

        // Add a new series to the chart with data points for X values (categories) and Y values
        chart.getSeries().add("E-iceblue Test Series",
                new String[] { "Word", "PDF", "Excel", "GoogleDocs", "Office" },
                new double[] { 1900000, 850000, 2100000, 600000, 1500000 });

        // Set the number format for the Y-axis labels
        chart.getAxisY().getNumberFormat().setFormatCode("#,##0");

        // Save the document to a file in Docx format
        document.saveToFile("appendColumnChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();
    }
}
