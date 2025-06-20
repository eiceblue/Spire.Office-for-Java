import com.spire.doc.*;

public class disableHyperlinks {
    public static void main(String[] args) {
        // Specify the path of the input Word document
        String inputFile = "data/Template_Docx_5-BJ.docx";

        // Specify the path of the output PDF file
        String outputFile = "output/Result-DisableHyperlinks.pdf";

        // Create a new Document object
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Create a ToPdfParameterList object to configure the PDF conversion options
        ToPdfParameterList pdf = new ToPdfParameterList();

        // Set the 'disableLink' option to true to remove the hyperlink effect in the resulting PDF page
        // Set it to false to preserve the hyperlink effect
        pdf.setDisableLink(true);

        // Save the document as a PDF file with the specified output file name and PDF conversion options
        document.saveToFile(outputFile, pdf);

        // Dispose of the Document object to release resources
        document.dispose();
    }
}
