import com.spire.doc.*;
import com.spire.doc.documents.comparison.*;

public class compareDocumentsWithOptions {
    public static void main(String[] args){

        //Create a document
        Document doc1 = new Document();

        //Load the first document
        doc1.loadFromFile("data/DocumentCompareFunction1.docx");

        //Create a document
        Document doc2 = new Document();

        //Load the second document
        doc2.loadFromFile("data/DocumentCompareFunction2.docx");

        //Create a CompareOptions
        CompareOptions compareOptions = new CompareOptions();
        compareOptions.setIgnoreFormatting(true);

        //Compare the two documents
        doc1.compare(doc2, "E-iceblue",compareOptions);

        String result = "output/CompareDocumentsWithOptions_result.docx";
        //Save the comparison document
        doc1.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        doc1.dispose();
        doc2.dispose();
    }
}
