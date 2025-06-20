import com.spire.doc.*;
import com.spire.doc.fields.*;
import java.io.InputStream;

public class handleAskField {
    public static void main(String[] args) {
        String input="data/handleAskField.docx";
        String output="output/handleAskField_out.docx";

		// Create a new document object
		Document doc = new Document();

		// Load the document from the specified input file
		doc.loadFromFile(input);

		// Set the custom UpdateFieldsHandler for handling AskFieldEventArgs during field update
		doc.UpdateFields = new HandleAskFieldex();

		// Enable field updating during document saving
		doc.isUpdateFields(true);

		// Save the updated document to the specified output file in DOCX format
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose the document resources
		doc.dispose();
    }

	// Create a custom UpdateFieldsHandler to handle AskFieldEventArgs during field update
	static class HandleAskFieldex extends UpdateFieldsHandler {
		public void invoke(Object sender, IFieldsEventArgs args) {
			// Check if the event arguments are of type AskFieldEventArgs
			if (args instanceof AskFieldEventArgs) {
				AskFieldEventArgs askArgs = (AskFieldEventArgs) args;

				// Handle specific bookmark names and set appropriate response texts
				if (askArgs.getBookmarkName().equals("1")) {
					askArgs.setResponseText("Thank you. This is my first time to come to a Chinese restaurant. Could you " +
							"tell me the different features of Chinese food?");
				}

				if (askArgs.getBookmarkName().equals("2")) {
					askArgs.setResponseText("No more, thank you. I'm quite full.");
				}
			}
		}
	}
}
