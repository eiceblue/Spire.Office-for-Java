import com.spire.doc.*;

public class toPdfWithCustomFontsFolders {
    public static void main(String[] args) {
        // Set the input file path
        String inputFile = "data/convertedTemplate.docx";

        // Set the output file path
        String outputFile = "output/output.pdf";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(inputFile);

        // When the system does not have the fonts used in a document installed, you can place the required fonts in a custom folder and then use setCustomFontsFolders to specify that the program should retrieve fonts from this path
        document.setCustomFontsFolders("D:\\Fonts");

        // Save the document to the output file as PDF
        document.saveToFile(outputFile, FileFormat.PDF);

        // Clear the custom fonts data
        document.clearCustomFontsFolders();

        // Clear system cached fonts
        Document.clearSystemFontCache();

        // Dispose the document object
        document.dispose();
    }
}
