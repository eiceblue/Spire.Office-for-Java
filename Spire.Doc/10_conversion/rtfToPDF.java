import com.spire.doc.*;

public class rtfToPDF {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an RTF file into the document, specifying the file format as RTF
        document.loadFromFile("data/Template_RtfFile.rtf", FileFormat.Rtf);

        // Specify the output file path and name for the generated PDF
        String result = "output/result-rtfToPdf.pdf";

        // Save the document to the specified file in PDF format
        document.saveToFile(result, FileFormat.PDF);

        // Dispose of the document resources
        document.dispose();
    }
}
