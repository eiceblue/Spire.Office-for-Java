import com.spire.pdf.*;
import com.spire.pdf.conversion.XlsxLineLayoutOptions;

public class toXlsxOptions {
    public static void main(String[] args) {
        // Specify the input PDF file path
        String input = "data/toXlsxOptions.pdf";

        // Specify the output XLSX file path
        String output = "output/toXlsxOptions_out.xlsx";

        // Create a new PdfDocument object
        PdfDocument document = new PdfDocument();

        // Load the PDF document from the input file
        document.loadFromFile(input);

        // Create a new XlsxLineLayoutOptions object with the specified parameters: convertToMultipleSheet,showRotatedText,splitCell,wrapText
        XlsxLineLayoutOptions options = new XlsxLineLayoutOptions(false, false, false, false);

        // Set the XlsxLineLayoutOptions object as the conversion options for the PdfDocument
        document.getConvertOptions().setPdfToXlsxOptions(options);

        // Save the converted document to the output XLSX file
        document.saveToFile(output, FileFormat.XLSX);

        // Close the original document
        document.close();

        // Dispose of the resources used by the document
        document.dispose();
    }
}
