import com.spire.doc.*;

public class betweenParagraphs {
    public static void main(String[] args) {
        //Create word document.
        Document sourceDocument = new Document();

        // Load the source document from disk.
        sourceDocument.loadFromFile("data/Sample.docx");

        //Create word document.
        Document destinationDoc = new Document();

        // Load the document from disk.
        Section section = destinationDoc.addSection();

        // Extract content between the first paragraph to the third paragraph.
        ExtractBetweenParagraphs(sourceDocument, destinationDoc, 1, 3);

        // Save the document.
        destinationDoc.saveToFile("output/betweenParagraphs.docx", FileFormat.Docx);

        //Dispose the documents
        sourceDocument.dispose();
        destinationDoc.dispose();

    }

    private static void ExtractBetweenParagraphs(Document sourceDocument, Document destinationDocument, int startPara, int endPara) {
        // Extract the content.
        for (int i = (startPara - 1); (i < endPara); i++) {
            // Clone the ChildObjects of source document.
            DocumentObject doobj = sourceDocument.getSections().get(0).getBody().getChildObjects().get(i).deepClone();

            // Add to destination document.
            destinationDocument.getSections().get(0).getBody().getChildObjects().add(doobj);
        }
    }
}
