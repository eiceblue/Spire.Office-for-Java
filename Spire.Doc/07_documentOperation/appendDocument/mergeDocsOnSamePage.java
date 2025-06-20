import com.spire.doc.*;

public class mergeDocsOnSamePage {
    public static void main(String[] args) {
        //Create a document
        Document document = new Document();

        //Load the source document from disk.
        document.loadFromFile("data/Insert.docx");

        //Create a destination  document
        Document destinationDocument = new Document();

        //Load the destination document from disk.
        destinationDocument.loadFromFile("data/TableOfContent.docx");

        //Traverse sections
        for (Object sectionObj : document.getSections()) {
            Section section=(Section)sectionObj;
            // Traverse body ChildObjects
            for (Object docObj : section.getBody().getChildObjects()) {
                DocumentObject obj=(DocumentObject)docObj;
                // Clone to destination document at the same page
                destinationDocument.getSections().get(0).getBody().getChildObjects().add(obj.deepClone());
            }
        }
        //Save the document.
        destinationDocument.saveToFile("output/mergeDocsOnSamePage.docx", FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
        destinationDocument.dispose();
    }
}
