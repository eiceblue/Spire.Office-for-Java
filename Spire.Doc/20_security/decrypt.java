import com.spire.doc.*;

public class decrypt {
    public static void main(String[] args) {
        String inputFile="data/decrypt.docx";
        String outputFile="output/decrypt_out.docx";

		// Create a new document object
		Document document = new Document();

		// Load the document from the specified input file with the specified format and password
		document.loadFromFile(inputFile, FileFormat.Docx, "E-iceblue");

		// Save the document to the specified output file in DOCX format
		document.saveToFile(outputFile, FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}
