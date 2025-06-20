import com.spire.doc.*;

public class embedAllFontsInPDF {
    public static void main(String[] args) {
        // Specify the path of the input Word document
        String inputFile = "data/convertedTemplate.docx";

        // Specify the path of the output PDF file
        String outputFile = "output/embedAllFontsInPDF.pdf";

        // Create a new Document object
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Create a ToPdfParameterList object to configure the PDF conversion options
        ToPdfParameterList ppl = new ToPdfParameterList();

        // Enable embedding of all fonts in the resulting PDF
        ppl.isEmbeddedAllFonts(true);

        // Save the document as a PDF file with the specified output file name and PDF conversion options
        document.saveToFile(outputFile, ppl);

        // Dispose of the Document object to release resources
        document.dispose();
    }
}
