import com.spire.doc.*;
import com.spire.doc.collections.StyleCollection;

public class copyDocumentStyles {
    public static void main(String[] args) {
        // Set the input file path
        String inputFile1 = "data/Template_Toc.docx";
        String inputFile2 = "data/Template_Docx_1.docx";

        // Set the output file path
        String outputFile = "output/copyDocumentStyles.docx";

        // Create a new Document object for the source document and load from inputFile1
        Document srcDoc = new Document();
        srcDoc.loadFromFile(inputFile1);

        // Create a new Document object for the destination document and load from inputFile2
        Document destDoc = new Document();
        destDoc.loadFromFile(inputFile2);

        // Get the StyleCollection from the source document
        StyleCollection styles = srcDoc.getStyles();

        // Copy each style from the source document to the destination document
        for (int i = 0; i < styles.getCount(); i++) {
            destDoc.getStyles().add(styles.get(i));
        }

        // Save the destination document to the output file in Docx format
        destDoc.saveToFile(outputFile, FileFormat.Docx);

        // Dispose of the source and destination documents to release resources
        srcDoc.dispose();
        destDoc.dispose();
    }
}
