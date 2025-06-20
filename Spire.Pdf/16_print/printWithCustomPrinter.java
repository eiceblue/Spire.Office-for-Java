import java.awt.print.PrinterException;
import com.spire.pdf.*;

public class printWithCustomPrinter {

    public static void main(String[] args) throws PrinterException {
        // Create a new PdfDocument object and load the PDF document from the specified file
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/printSample.pdf");

        // Get the print settings
        PrintSettings setting = pdf.getPrintSettings();

        // Set the printer name
        setting.setPrinter("Adobe");

        // Print the document
        pdf.print();

        // Close the document (optional, depending on the library used)
        pdf.close();

        // Dispose of the document (optional, depending on the library used)
        pdf.dispose();
	}
}
