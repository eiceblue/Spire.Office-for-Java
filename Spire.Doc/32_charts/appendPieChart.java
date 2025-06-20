import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendPieChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Pie chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a pie chart shape to the paragraph with specified width and height
        ShapeObject shape = newPara.appendChart(ChartType.Pie, 500, 300);
        Chart chart = shape.getChart();

        // Add a series to the chart with categories (labels) and corresponding data values
        ChartSeries series = chart.getSeries().add("E-iceblue Test Series",
                new String[] { "Word", "PDF", "Excel" },
                new double[] { 2.7, 3.2, 0.8 });

        // Save the document to a file in Docx format
        document.saveToFile("AppendPieChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();
    }
}
