import com.spire.doc.*;

public class simpleInsertFile {
    public static void main(String[] args) {

        //Create a document
        Document doc = new Document();

        //Load the Word document
        doc.loadFromFile("data/Template_N5.docx");

        //Insert document from file
        doc.insertTextFromFile( "data/Template_N3.docx", FileFormat.Auto);

        //Save the document
        String output = "output/simpleInsertFile_out.docx";
        doc.saveToFile(output, FileFormat.Docx_2010);

        //Dispose the document
        doc.dispose();
    }
}