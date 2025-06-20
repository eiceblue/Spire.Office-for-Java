import com.spire.doc.*;

public class toPdfWithAuthorNameInCommentLabel {
    public static void main(String[] args) {
        String inputFile="data/CommentLabelWithAuthor.docx";
        String outputFile="output/toPDF.pdf";

		// Create a new Document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(inputFile);

		// Create a ToPdfParameterList object to set parameters for PDF conversion
		ToPdfParameterList parms = new ToPdfParameterList();

		// Set the option to use the author name to display comment labels to true
		parms.useAuthorNameToDisplayCommentLabel(true);

		// Save the document to the specified output file as a PDF, using the specified parameters
		document.saveToFile(outputFile, parms);

		// Dispose of the document object to free up resources
		document.dispose();
    }
}
