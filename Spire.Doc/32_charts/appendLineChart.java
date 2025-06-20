import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendLineChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Line chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a line chart shape to the paragraph with specified width and height
        ShapeObject shape = newPara.appendChart(ChartType.Line, 500, 300);

        // Get the chart object from the shape
        Chart chart = shape.getChart();

        // Get the title of the chart
        ChartTitle title = chart.getTitle();

        // Set the text of the chart title
        title.setText("My Chart");

        // Clear any existing series in the chart
        ChartSeriesCollection seriesColl = chart.getSeries();
        seriesColl.clear();

        // Define categories (X-axis values)
        String[] categories = { "C1", "C2", "C3", "C4", "C5", "C6" };

        // Add two series to the chart with specified categories and Y-axis values
        seriesColl.add("AW Series 1", categories, new double[] { 1, 2, 2.5, 4, 5, 6 });
        seriesColl.add("AW Series 2", categories, new double[] { 2, 3, 3.5, 6, 6.5, 7 });

        // Save the document to a file in Docx format
        document.saveToFile("AppendLineChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();
    }
}
