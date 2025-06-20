import com.spire.doc.*;
import java.util.*;

public class embedNoninstalledFonts {
    public static void main(String[] args) {
        // Define the path of the input file
        String inputFile = "data/convertedTemplate.docx";

        // Define the path of the font file
        String fontFile = "data/PT_Serif-Caption-Web-Regular.ttf";

        // Define the path of the output file
        String outputFile = "output/embedNoninstalledFonts.pdf";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(inputFile);

        // Create a ToPdfParameterList object to set parameters for PDF conversion
        ToPdfParameterList parms = new ToPdfParameterList();

        // Create a list to store the paths of private fonts
        List<PrivateFontPath> fonts = new ArrayList<PrivateFontPath>();

        // Add a private font path to the list, specifying the font name and file path
        fonts.add(new PrivateFontPath("PT Serif Caption", fontFile));

        // Set the private font paths in the ToPdfParameterList object
        parms.setPrivateFontPaths(fonts);

        // Save the document as a PDF file with embedded non-installed fonts to the specified output file
        document.saveToFile(outputFile, parms);
    }
}
