import com.spire.doc.*;
import com.spire.doc.documents.*;

public class toTiff {
    public static void main(String[] args) {
        // Define the output file path and name for the TIFF document
        String outputFile = "output/wordToTiff.tiff";

        // Define a sample text to be inserted into the Word document
        String sampleText = "\nSpire.Doc for Java is a professional Word API that empowers Java applications to create, convert, " +
                "manipulate and print Word documents without dependency on Microsoft Word.\n\nBy using this multifunctional library," +
                " developers are able to process copious tasks effortlessly, such as inserting image, hyperlink, digital signature," +
                " bookmark and watermark, setting header and footer, creating table, setting background image, and adding footnote" +
                " and endnote.\n\nIn addition, Spire.Doc for Java supports file format conversions from Word to PDF, XPS, Image, EPUB" +
                ", HTML, TXT, ODT, RTF, WordML, WordXML and many more.";

        // Create a new instance of the Document class
        Document doc = new Document();

        // Add a new section to the document and a paragraph inside the section
        Section section = doc.addSection();
        Paragraph paragraph = section.addParagraph();

        // Append the sample text to the paragraph
        paragraph.appendText(sampleText);

        // Save the document to a TIFF file using the specified output file path and name
        doc.saveToTiff(outputFile);

        // Dispose of the document object to free up resources
        doc.dispose();
    }
}
