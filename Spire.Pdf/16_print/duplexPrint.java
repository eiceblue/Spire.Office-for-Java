import com.spire.pdf.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.awt.print.*;

public class duplexPrint {
    public static void main(String[] args) {
        // Specify the path of the input PDF file
        String inputFile = "data/printSample.pdf";

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

        // Set the printable content and page format for the printer job
        loPrinterJob.setPrintable(loDoc, loPageFormat);

        // Create a set of print request attributes to specify printing options
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        // Set the print option to two-sided printing with short-edge binding
        aset.add(Sides.TWO_SIDED_SHORT_EDGE);

        // Alternatively, you can use the following line for two-sided printing with long-edge binding
        // aset.add(Sides.TWO_SIDED_LONG_EDGE);

        try {
            // Print the document using the specified print settings and attributes
            loPrinterJob.print(aset);
        } catch (PrinterException e) {
            e.printStackTrace();
        }

        // Close the document (optional, depending on the library used)
        loDoc.close();

        // Dispose of the document (optional, depending on the library used)
        loDoc.dispose();
    }
}
