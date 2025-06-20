import com.spire.doc.*;
import com.spire.doc.documents.comparison.*;

public class CompareDocumentWithWordLevel {
    public static void main(String[] args){
        // Create a new Document object for the first document.
        Document doc1 = new Document();

        // Load the first document from file "SupportDocumentCompare1.docx".
        doc1.loadFromFile("data/SupportDocumentCompare1.docx");

        // Create a new Document object for the second document.
        Document doc2 = new Document();

        // Load the second document from file "SupportDocumentCompare2.docx".
        doc2.loadFromFile("data/SupportDocumentCompare2.docx");

        // Create a new CompareOptions object for specifying comparison options.
        CompareOptions compareOptions = new CompareOptions();

        // Set the comparison level to Word.
        compareOptions.setTextCompareLevel(TextDiffMode.Word);

        // Compare the contents of doc1 with doc2 using the specified comparison options.
        doc1.compare(doc2, "E-iceblue", compareOptions);

        // Specify the file path and name for the comparison result.
        String result = "output/CompareDocumentsWithOptions_result.docx";

        // Save the comparison result to the specified file in the Docx format compatible with Word 2013.
        doc1.saveToFile(result, FileFormat.Docx_2013);

        // Dispose the doc1 object to release resources
        doc1.dispose();

        // Dispose the doc2 object to release resources
        doc2.dispose();
    }
}
