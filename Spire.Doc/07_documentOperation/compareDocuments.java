import com.spire.doc.*;

public class compareDocuments {
    public static void main(String[] args) {

        //Create a document
        Document doc1 = new Document();

        //Load the first document
        doc1.loadFromFile("data/DocumentCompareFunction1.docx");

        //Create a document
        Document doc2 = new Document();

        //Load the second document
        doc2.loadFromFile("data/DocumentCompareFunction2.docx");

        //Compare two documents
        doc1.compare(doc2, "E-iceblue");

        //Save the document
        String output = "output/CompareDocuments_result.docx";
        doc1.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        doc1.dispose();
        doc2.dispose();
    }
}
