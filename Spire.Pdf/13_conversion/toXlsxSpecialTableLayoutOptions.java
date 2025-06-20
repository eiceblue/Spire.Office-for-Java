import com.spire.pdf.*;
import com.spire.pdf.conversion.XlsxSpecialTableLayoutOptions;

public class toXlsxSpecialTableLayoutOptions {
    public static void main(String[] args) {
        // Create a new PdfDocument object to work with PDF files
        PdfDocument document = new PdfDocument();

        // Load the PDF file from the specified path
        document.loadFromFile("data\\toXlsxOptions.pdf");

        // Create a new XlsxSpecialTableLayoutOptions object with specified layout options
        XlsxSpecialTableLayoutOptions options = new XlsxSpecialTableLayoutOptions(true, false, false);

        // Set the XlsxSpecialTableLayoutOptions as the conversion options for PDF to XLSX conversion
        document.getConvertOptions().setPdfToXlsxOptions(options);

        // Save the converted document as an XLSX file with the name "output.xlsx"
        document.saveToFile("output.xlsx", FileFormat.XLSX);

        // Dispose of system resources associated with the PdfDocument object
        document.dispose();
    }
}
