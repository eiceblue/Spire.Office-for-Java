import com.spire.doc.*;
public class removeAllParagraphs {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Remove paragraphs from every section in the document
        for ( Object sectionObj: document.getSections()) {
            Section section = (Section)sectionObj;
            section.getParagraphs().clear();
        }

        String result = "output/removeAllParagraphs.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
