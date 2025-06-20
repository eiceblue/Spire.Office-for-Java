import com.spire.doc.*;

public class keepHiddenText {
    public static void main(String[] args) {
        // Specify the input file path for the Word document to be processed
        String inputFile = "data/Template_Docx_5-BJ.docx";

        // Specify the output file path for the resulting PDF document
        String outputFile = "output/Result-SaveTheHiddenTextToPDF.pdf";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Create an instance of the ToPdfParameterList class to specify parameters for conversion to PDF
        ToPdfParameterList pdf = new ToPdfParameterList();

        // Specify that hidden text should be included in the resulting PDF document
        pdf.isHidden(true);

        // Save the document to the specified output file in PDF format, using the specified conversion parameters
        document.saveToFile(outputFile, pdf);

        // Dispose of system resources associated with the document
        document.dispose();
    }
}
