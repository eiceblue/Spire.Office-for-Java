import com.spire.doc.*;
import com.spire.doc.documents.*;

public class addHorizonalLine {

    public static void main(String[] args) throws Exception {
			// Create a new Document object
			Document doc = new Document();
			
			// Add a new Section to the Document
			Section sec = doc.addSection();
			
			// Add a new Paragraph to the Section
			Paragraph para = sec.addParagraph();
			
			// Append a horizontal line to the Paragraph
			para.appendHorizonalLine();
			
			// Save the Document to a file named "addHorizonalLine.docx"
			doc.saveToFile("addHorizonalLine.docx");
			
			// Dispose the Document resources
			doc.dispose();
    }
}
