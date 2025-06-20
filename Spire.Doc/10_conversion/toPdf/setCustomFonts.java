import com.spire.doc.*;
import java.io.*;

public class setCustomFonts {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Document instance
        Document document = new Document();

        // Load the document from a file
        document.loadFromFile("data/convertedTemplate.docx");

        // Create an InputStream for the custom font file
        InputStream inputStream1 = new FileInputStream("data/PT Serif Caption.ttf");

        // Create an array of InputStreams containing the custom font InputStream
        InputStream[] inputStreams = new InputStream[] {inputStream1};

        // Set the custom fonts for the document
        document.setCustomFonts(inputStreams);

        // Optionally set global custom fonts (commented out)
        // Document.setGlobalCustomFonts(inputStreams);

        // Save the document as a PDF file
        document.saveToFile("output/CustomFonts.pdf", FileFormat.PDF);

        // Clear the custom fonts from the document
        document.clearCustomFonts();

        // Optionally clear global custom fonts (commented out)
        // Document.clearGlobalCustomFonts();

        // Dispose of the document to release resources
        document.dispose();
    }
}
