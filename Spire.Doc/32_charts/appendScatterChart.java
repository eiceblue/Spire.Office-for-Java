import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendScatterChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Scatter chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a scatter chart shape to the paragraph with specified width and height
        ShapeObject shape = newPara.appendChart(ChartType.Scatter, 450, 300);
        Chart chart = shape.getChart();
        // Clear any existing series in the chart
        chart.getSeries().clear();

        // Add a new series to the chart with data points for X and Y values
        chart.getSeries().add("Series 1",
                new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 },
                new double[] { 1.0, 20.0, 40.0, 80.0, 160.0 });

        // Save the document to a file in Docx format
        document.saveToFile("appendScatterChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();
    }
}
