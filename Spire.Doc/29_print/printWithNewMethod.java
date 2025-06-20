import com.spire.doc.*;

import java.awt.print.*;

public class printWithNewMethod {
    public static void main(String[] args) {

        // Create a document
        Document document = new Document();

        // Load a document
        document.loadFromFile("data/print.docx");

        // Create a PrinterJob
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

        // Get the default page format
        PageFormat loPageFormat  = loPrinterJob.defaultPage();

        // Get the paper
        Paper loPaper = loPageFormat.getPaper();

        // Delete the default margin
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
        // Set the copy number
        loPrinterJob.setCopies(1);

        // Set the paper
        loPageFormat.setPaper(loPaper);

        // Enable printable
        loPrinterJob.setPrintable(document,loPageFormat);

        try {
            // Print the document
            loPrinterJob.print();
        } catch (PrinterException e)
        {
            e.printStackTrace();
        }

        // Dispose the document
        document.dispose();
    }
}
