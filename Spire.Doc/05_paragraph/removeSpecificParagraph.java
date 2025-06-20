import com.spire.doc.*;
public class removeSpecificParagraph {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Remove the first paragraph from the first section of the document.
        document.getSections().get(0).getParagraphs().removeAt(0);

        String result = "output/removeSpecificParagraph.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
