import com.spire.doc.*;
import com.spire.doc.documents.*;

public class betweenParagraphStyles {
    public static void main(String[] args) {
        //Create the first document
        Document sourceDocument = new Document();

        // Load the source document from disk.
        sourceDocument.loadFromFile("data/BetweenParagraphStyle.docx");

        //Create a destination document
        Document destinationDoc = new Document();

        //Add a section
        Section section = destinationDoc.addSection();

        // Extract content between the first paragraph to the third paragraph
        ExtractBetweenParagraphStyles(sourceDocument, destinationDoc, "1", "2");

        // Save the document.
        destinationDoc.saveToFile("output/betweenParagraphStyles.docx", FileFormat.Docx_2013);

        //Dispose the documents
        sourceDocument.dispose();
        destinationDoc.dispose();
    }

    private static void ExtractBetweenParagraphStyles(Document sourceDocument, Document destinationDocument, String stylename1, String stylename2) {
        int startindex = 0;
        int endindex = 0;
        // travel the sections of source document
        for (Object sectionObj  : sourceDocument.getSections()) {
            Section section=(Section)sectionObj;

            // travel the paragraphs
            for (Object paragraphObj : section.getParagraphs()) {
                Paragraph paragraph=(Paragraph)paragraphObj;

                // Judge paragraph style1
                if (paragraph.getStyleName().equals(stylename1)) {
                    // Get the paragraph index
                    startindex = section.getBody().getParagraphs().indexOf(paragraph);
                }

                // Judge paragraph style2
                if (paragraph.getStyleName().equals(stylename2)) {
                    // Get the paragraph index
                    endindex = section.getBody().getParagraphs().indexOf(paragraph);
                }
            }

            // Extract the content
            for (int i = (startindex + 1); i < endindex; i++) {
                // Clone the ChildObjects of source document
                DocumentObject doobj = sourceDocument.getSections().get(0).getBody().getChildObjects().get(i).deepClone();
                // Add to destination document
                destinationDocument.getSections().get(0).getBody().getChildObjects().add(doobj);
            }
        }
    }
}
