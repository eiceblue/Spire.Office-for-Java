import com.spire.doc.*;
import com.spire.doc.fields.*;

public class addBarcodeImage {
    public static void main(String[] args) {
        String input1 = "data/sample.docx";
        String input2 = "data/barcode.png";
        String output = "output/addBarcodeImage.docx";

		// Create a new Document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(input1);

		// Add a paragraph to the first section of the document and append a picture to it
		DocPicture picture = document.getSections().get(0).addParagraph().appendPicture(input2);

		// Save the modified document to the specified output file in Docx format
		document.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		document.dispose();
    }
}
