import java.awt.print.*;

import com.spire.xls.*;

public class printExcel {
    public static void main(String[] args) {
        // Specify the path and name of the input Excel file
        String inputFile = "data/worksheetSample1.xlsx";

        // Create a new Workbook object
        Workbook loDoc = new Workbook();

        // Load the Excel file into the Workbook
        loDoc.loadFromFile(inputFile);

        // Get the default PrinterJob
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

        // Get the default PageFormat
        PageFormat loPageFormat = loPrinterJob.defaultPage();

        // Get the Paper object from the PageFormat
        Paper loPaper = loPageFormat.getPaper();

        // Set the imageable area of the paper to cover the entire page
        loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());

        // Set the number of copies to 1
        loPrinterJob.setCopies(1);

        // Set the paper of the PageFormat to the modified Paper object
        loPageFormat.setPaper(loPaper);

        // Set the printable object to the Workbook and PageFormat to the modified PageFormat
        loPrinterJob.setPrintable(loDoc, loPageFormat);

        try {
            // Print the Workbook using the PrinterJob
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
        // Clean up resources and release memory
        loDoc.dispose();
    }
}
