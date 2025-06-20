import com.spire.doc.*;
public class cloneWordDocument {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Clone the Word document.
        Document newDoc = document.deepClone();

        String result = "output/cloneWordDocument.docx";

        //Save the file.
        newDoc.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the documents
        document.dispose();
        newDoc.dispose();
    }
}
