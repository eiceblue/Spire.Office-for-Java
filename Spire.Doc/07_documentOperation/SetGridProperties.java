import com.spire.doc.*;
import com.spire.doc.documents.GridPitchType;

public class SetGridProperties {
    public static void main(String[] args) {
        // Create a new Document object
        Document doc = new Document();

        // Load an existing document from the specified file path
        doc.loadFromFile("data/Sample.docx");

        // Set grid properties for each section in the document
        for (Object sec : doc.getSections()) {
            // Set the grid type to "Lines_Only"
            ((Section)sec).getPageSetup().setGridType(GridPitchType.Lines_Only);

            // Set the number of lines per page to 15
            ((Section)sec).getPageSetup().setLinesPerPage(15);
        }

        // Specify the output file path
        String outputFilePath = "output/output.docx";

        // Save the modified document to the output file path in Docx format
        doc.saveToFile(outputFilePath, FileFormat.Docx);

        // Dispose the doc object to release resources
        doc.dispose();
    }
}
