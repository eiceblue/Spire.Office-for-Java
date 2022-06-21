import java.awt.print.*;

import com.spire.xls.*;

public class pageSetupForPrinting {
	public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/createTable.xlsx");

        //Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Specifying the print area
        PageSetup pageSetup = worksheet.getPageSetup();
        pageSetup.setPrintArea("A1:E19");

        //Define column A & E as title columns
        pageSetup.setPrintTitleColumns("$A:$E");

        //Define row numbers 1 as title rows
        pageSetup.setPrintTitleRows("$1:$2");

        //Allow to print with gridlines
        pageSetup.isPrintGridlines(true);

        //Allow to print with row/column headings
        pageSetup.isPrintHeadings(true); 

        //Allow to print worksheet in black & white mode
        pageSetup.setBlackAndWhite(true);

        //Allow to print comments as displayed on worksheet
        pageSetup.setPrintComments(PrintCommentType.InPlace);

        //Set printing quality
        pageSetup.setPrintQuality(150);

        //Set the printing order 
        pageSetup.setOrder(OrderType.OverThenDown);

        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();
        
        //Remove the default printing margins
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
        //Set the number of copies
        loPrinterJob.setCopies(1);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(workbook,loPageFormat);

        try {
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
	}
}
