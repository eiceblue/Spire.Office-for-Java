import com.spire.doc.*;

public class integrateFontTable {
    public static void main(String[] args) {

        //Create a document
        Document destDoc = new Document();
        //Load the document from disk
        destDoc.loadFromFile("data/Template_N2.docx");

        //Create another document
        Document srcDoc = new Document();

        //Load the document from disk
        srcDoc.loadFromFile("data/Template_N3.docx");

        // Copy the Fonttable data from the source document to the target document
        srcDoc.integrateFontTableTo(destDoc);
        //Copy the sections of source document to destination document
        for (Object sectionObj : srcDoc.getSections()) {
            Section section=(Section)sectionObj;
            destDoc.getSections().add(section.deepClone());
        }

        //Save the Word document
        String output="output/integrateFontTable.docx";
        destDoc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the documents
        srcDoc.dispose();
        destDoc.dispose();
    }
}
