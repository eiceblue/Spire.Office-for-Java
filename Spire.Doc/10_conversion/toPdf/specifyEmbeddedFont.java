import com.spire.doc.*;
import java.util.*;

public class specifyEmbeddedFont {
    public static void main(String[] args) {
        // Specify the input file path for the Word document to be processed
        String inputFile = "data/convertedTemplate.docx";

        // Specify the output file path for the resulting PDF document
        String outputFile = "output/specifyEmbeddedFont.pdf";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Create an instance of the ToPdfParameterList class to specify parameters for conversion to PDF
        ToPdfParameterList parms = new ToPdfParameterList();

        // Create a list to specify the names of embedded fonts to be used in the resulting PDF document
        List<String> part = new ArrayList();
        part.add("PT Serif Caption");
        parms.setEmbeddedFontNameList(part);

        // Save the document to the specified output file in PDF format, using the specified conversion parameters
        document.saveToFile(outputFile, parms);

        // Dispose of system resources associated with the document
        document.dispose();
    }
}
