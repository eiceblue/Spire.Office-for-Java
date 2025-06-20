import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.formatting.revisions.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class modifyRevisionTime {
    public static void main(String[] args) throws Exception {

		// Create a new Document object
		Document document = new Document();
		// Load the Word document file from the specified path
		document.loadFromFile("data/ModifyRevisionTime.docx");

		// Initialize index variables for tracking insert and delete revisions
		int index_insertRevision = 0;
		int index_deleteRevision = 0;

		// Set the desired date and time for revision changes
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = "2023/3/1 00:00:00";
		Date date = formatter.parse(dateString);

		// Iterate through the sections of the document
		for (Section sec : (Iterable<Section>) document.getSections()) {

			// Iterate through the child objects in the section's body
			for (DocumentObject docItem : (Iterable<DocumentObject>) sec.getBody().getChildObjects()) {
				if (docItem instanceof Paragraph) {
					Paragraph para = (Paragraph) docItem;

					// Check if the paragraph has an insert revision
					if (para.isInsertRevision()) {
						index_insertRevision++;

						// Get the insert revision object and set the revision date
						EditRevision insRevison = para.getInsertRevision();
						insRevison.setDateTime(date);
					}
					// Check if the paragraph has a delete revision
					else if (para.isDeleteRevision()) {
						index_deleteRevision++;

						// Get the delete revision object and set the revision date
						EditRevision delRevison = para.getDeleteRevision();
						delRevison.setDateTime(date);
					}

					// Iterate through the child objects in the paragraph
					for (DocumentObject obj : (Iterable<DocumentObject>) para.getChildObjects()) {
						if (obj instanceof TextRange) {
							TextRange textRange = (TextRange) obj;

							// Check if the text range has an insert revision
							if (textRange.isInsertRevision()) {
								index_insertRevision++;

								// Get the insert revision object and set the revision date
								EditRevision insRevison = textRange.getInsertRevision();
								insRevison.setDateTime(date);
							}
							// Check if the text range has a delete revision
							else if (textRange.isDeleteRevision()) {
								index_deleteRevision++;

								// Get the delete revision object and set the revision date
								EditRevision delRevison = textRange.getDeleteRevision();
								delRevison.setDateTime(date);
							}
						}
					}
				}
			}
		}

		// Save the modified document to a new file
		String result = "ChangeRevisionTime_out.docx";
		document.saveToFile(result, com.spire.doc.FileFormat.Docx);

		// Dispose the Document object to free resources
		document.dispose();
    }
}