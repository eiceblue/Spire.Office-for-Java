import com.spire.doc.*;

public class copyContentToAnotherDoc {
    public static void main(String[] args) {
        //Create a document
        Document sourceDoc = new Document();

        //Load the source document.
        sourceDoc.loadFromFile("data/Template_Docx_1.docx");

        //create another document
        Document destinationDoc = new Document();

        //Load a document
        destinationDoc.loadFromFile("data/Target.docx");

        //Copy content from source file and insert them to the target file.
        for (Object sectionObj : sourceDoc.getSections()) {
            Section sec=(Section)sectionObj;
            for (Object docObj : sec.getBody().getChildObjects()) {
                DocumentObject obj=(DocumentObject)docObj;
                destinationDoc.getSections().get(0).getBody().getChildObjects().add(obj.deepClone());
            }
        }

        String result = "output/copyContentToAnotherWord.docx";

        //Save to file.
        destinationDoc.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the documents
        sourceDoc.dispose();
        destinationDoc.dispose();
    }
}
