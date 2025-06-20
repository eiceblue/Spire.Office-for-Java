import com.spire.doc.*;

public class fromParagraphToTable {
    public static void main(String[] args) {
        //Create the first document
        Document sourceDocument = new Document();

        // Load the source document from disk.
        sourceDocument.loadFromFile("data/IncludingTable.docx");

        //Create a destination document
        Document destinationDoc = new Document();

        //Add a section
        Section destinationSection = destinationDoc.addSection();

        // Extract the content from the first paragraph to the first table
        ExtractByTable(sourceDocument, destinationDoc, 1, 1);

        // Save the document.
        destinationDoc.saveToFile("output/fromParagraphToTable.docx", FileFormat.Docx);

        //Dispose the document
        sourceDocument.dispose();
        destinationDoc.dispose();
    }

    private static void ExtractByTable(Document sourceDocument, Document destinationDocument, int startPara, int tableNo) {
        // Get the table from the source document
        Table table = sourceDocument.getSections().get(0).getTables().get((tableNo - 1));

        // Get the table index
        int index = sourceDocument.getSections().get(0).getBody().getChildObjects().indexOf(table);

        for (int i = (startPara - 1); (i <= index); i++) {
            // Clone the ChildObjects of source document
            DocumentObject doobj = sourceDocument.getSections().get(0).getBody().getChildObjects().get(i).deepClone();

            // Add to destination document
            destinationDocument.getSections().get(0).getBody().getChildObjects().add(doobj);
        }
    }
}
