import java.awt.print.*;

import com.spire.xls.*;

public class printExcel {
    public static void main(String[] args) {
        //Load workbook
        String inputFile = "data/worksheetSample1.xlsx";
        Workbook loDoc = new Workbook();
        loDoc.loadFromFile(inputFile);
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();

        //Remove the default printing margins
        loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());

        //Set the number of copies
        loPrinterJob.setCopies(1);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(loDoc, loPageFormat);

        try {
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
