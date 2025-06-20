import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.fields.shapes.charts.*;

public class appendBarChart {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append text to it
        section.addParagraph().appendText("Bar chart.");

        // Add a new paragraph to the section
        Paragraph newPara = section.addParagraph();

        // Append a bar chart shape to the paragraph with specified width and height
        ShapeObject chartShape = newPara.appendChart(ChartType.Bar, 400, 300);
        Chart chart = chartShape.getChart();

        // Get the title of the chart
        ChartTitle title = chart.getTitle();

        // Set the text of the chart title
        title.setText("My Chart");

        // Show the chart title
        title.setShow(true);

        // Overlay the chart title on top of the chart
        title.setOverlay(true);

        // Save the document to a file in Docx format
        document.saveToFile("appendBarChart.docx", FileFormat.Docx_2016);

        // Dispose of the document object when finished using it
        document.dispose();
    }
}
