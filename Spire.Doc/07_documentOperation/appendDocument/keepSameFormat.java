import com.spire.doc.*;

public class keepSameFormat {
    public static void main(String[] args) {

        //Create a document
        Document srcDoc = new Document();
        //Load the source document from disk
        srcDoc.loadFromFile("data/Template_N2.docx");

        //Create another document
        Document destDoc = new Document();

        //Load the document from disk
        destDoc.loadFromFile("data/Template_N3.docx");

        //Keep same format of source document
        srcDoc.setKeepSameFormat(true);

        //Copy the sections of source document to destination document
        for (Object sectionObj : srcDoc.getSections()) {
            Section section=(Section)sectionObj;
            destDoc.getSections().add(section.deepClone());
        }

        //Save the Word document
        String output="output/keepSameFormat.docx";
        destDoc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the documents
        srcDoc.dispose();
        destDoc.dispose();
    }
}
