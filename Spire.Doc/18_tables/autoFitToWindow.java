import com.spire.doc.*;

public class autoFitToWindow {
    public static void main(String[] args) {
        String inputFile = "data/tableSample.docx";
        String outputFile = "output/autoFitToWindow.docx";

        // Create a new Document instance
        Document document = new Document();

        // Load the document from the inputFile
        document.loadFromFile(inputFile);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Auto-fit the table to fit the window
        table.autoFit(AutoFitBehaviorType.Auto_Fit_To_Window);

        // Save the modified document to the outputFile in Docx format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
