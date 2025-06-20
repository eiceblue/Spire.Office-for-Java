import java.awt.print.*;
import com.spire.xls.*;

public class pageSetupForPrinting {
        public static void main(String[] args) {
                // Create a new Workbook object
                Workbook workbook = new Workbook();

                // Load an existing Excel file into the Workbook
                workbook.loadFromFile("data/createTable.xlsx");

                // Get the first worksheet from the Workbook
                Worksheet worksheet = workbook.getWorksheets().get(0);

                // Get the PageSetup for the worksheet
                PageSetup pageSetup = worksheet.getPageSetup();

                // Set the print area for the worksheet to cells A1:E19
                pageSetup.setPrintArea("A1:E19");

                // Set the columns A:E as titles to repeat on each printed page
                pageSetup.setPrintTitleColumns("$A:$E");

                // Set the rows 1:2 as titles to repeat on each printed page
                pageSetup.setPrintTitleRows("$1:$2");

                // Enable printing of gridlines
                pageSetup.isPrintGridlines(true);

                // Enable printing of headings
                pageSetup.isPrintHeadings(true);

                // Set the worksheet to be printed in black and white
                pageSetup.setBlackAndWhite(true);

                // Set the option to print comments in place
                pageSetup.setPrintComments(PrintCommentType.InPlace);

                // Set the print quality to 150 dpi
                pageSetup.setPrintQuality(150);

                // Set the order of printing to over then down
                pageSetup.setOrder(OrderType.OverThenDown);

                // Get the default PrinterJob
                PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

                // Get the default PageFormat
                PageFormat loPageFormat = loPrinterJob.defaultPage();

                // Get the Paper object from the PageFormat
                Paper loPaper = loPageFormat.getPaper();

                // Set the imageable area of the Paper to cover the entire page
                loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());

                // Set the number of copies to 1
                loPrinterJob.setCopies(1);

                // Set the paper of the PageFormat to the modified Paper object
                loPageFormat.setPaper(loPaper);

                // Set the printable object to the workbook and PageFormat to the modified PageFormat
                loPrinterJob.setPrintable(workbook, loPageFormat);

                try {
                        // Print the workbook using the PrinterJob
                        loPrinterJob.print();
                } catch (PrinterException e) {
                        e.printStackTrace();
                }
                // Clean up resources and release memory
                workbook.dispose();
        }
}
