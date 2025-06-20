import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendBubbleChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Bubble chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a bubble chart shape to the paragraph with specified width and height
        ShapeObject shape = newPara.appendChart(ChartType.Bubble, 500, 300);

        // Get the chart object from the shape
        Chart chart = shape.getChart();

        // Clear any existing series in the chart
        chart.getSeries().clear();

        // Add a new series to the chart with data points for X, Y, and bubble size values
        ChartSeries series = chart.getSeries().add("E-iceblue Test Series",
                new double[] { 2.9, 3.5, 1.1, 4.0, 4.0 },
                new double[] { 1.9, 8.5, 2.1, 6.0, 1.5 },
                new double[] { 9.0, 4.5, 2.5, 8.0, 5.0 });

        // Save the document to a file in Docx format
        document.saveToFile("appendBubbleChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();
    }
}
