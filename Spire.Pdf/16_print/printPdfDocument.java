import com.spire.pdf.*;
import java.awt.print.*;

public class printPdfDocument {
    public static void main(String[] args) {
        // Specify the path of the input PDF file
        String inputFile = "data/print.pdf";

        // Create a new PdfDocument object and load the PDF document from the specified file
        PdfDocument loDoc = new PdfDocument(inputFile);

        // Get the default printer job
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

        // Get the default page format from the printer job
        PageFormat loPageFormat = loPrinterJob.defaultPage();

        // Retrieve the paper from the page format and set the imageable area to match the page size
        Paper loPaper = loPageFormat.getPaper();
        loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());
        loPageFormat.setPaper(loPaper);

        // Set the number of copies to print
        loPrinterJob.setCopies(1);

        // Set the printable content and page format for the printer job
        loPrinterJob.setPrintable(loDoc, loPageFormat);

        try {
            // Print the document using the specified print settings
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }

        // Close the document (optional, depending on the library used)
        loDoc.close();

        // Dispose of the document (optional, depending on the library used)
        loDoc.dispose();

    }
}
