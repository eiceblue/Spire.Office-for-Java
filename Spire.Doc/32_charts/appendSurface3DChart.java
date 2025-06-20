import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendSurface3DChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Surface3D chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a Surface3D chart shape to the paragraph with specified width and height
        ShapeObject shape = newPara.appendChart(ChartType.Surface_3_D, 500, 300);

        // Get the chart object from the shape
        Chart chart = shape.getChart();
        // Clear any existing series in the chart
        chart.getSeries().clear();

        // Set the title of the chart
        chart.getTitle().setText("My chart");

        // Add multiple series to the chart with categories (X-axis values) and corresponding data values
        chart.getSeries().add("E-iceblue Test Series 1",
                new String[] { "Word", "PDF", "Excel", "GoogleDocs", "Office" },
                new double[] { 1900000, 850000, 2100000, 600000, 1500000 });

        chart.getSeries().add("E-iceblue Test Series 2",
                new String[] { "Word", "PDF", "Excel", "GoogleDocs", "Office" },
                new double[] { 900000, 50000, 1100000, 400000, 2500000 });

        chart.getSeries().add("E-iceblue Test Series 3",
                new String[] { "Word", "PDF", "Excel", "GoogleDocs", "Office" },
                new double[] { 500000, 820000, 1500000, 400000, 100000 });

        // Save the document to a file in Docx format
        document.saveToFile("appendSurface3DChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();

    }
}
