import com.spire.doc.*;

public class addLineNumbers {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load a Word document from the specified file
        document.loadFromFile("data/Template_Docx_1.docx");

        // Set the start value of line numbering in the first section to 1
        document.getSections().get(0).getPageSetup().setLineNumberingStartValue(1);

        // Set the step value for line numbering in the first section to 6
        document.getSections().get(0).getPageSetup().setLineNumberingStep(6);

        // Set the distance between line numbers and text in the first section to 40f
        document.getSections().get(0).getPageSetup().setLineNumberingDistanceFromText(40f);

        // Set the line numbering restart mode in the first section to Continuous
        document.getSections().get(0).getPageSetup().setLineNumberingRestartMode(LineNumberingRestartMode.Continuous);

        // Specify the output file path
        String result = "output/result-addLineNumbers.docx";

        // Save the modified document to the specified file in Docx format compatible with Word 2013
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose of the Document object to release resources
        document.dispose();
    }
}
