import com.spire.pdf.*;
import java.awt.print.*;

public class print {
    public static void main(String[] args) {
        String inputFile = "data/print.pdf";
        PdfDocument loDoc = new PdfDocument(inputFile);
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();
        //remove the default printing margins
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
        //set the number of copies
        loPrinterJob.setCopies(1);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(loDoc,loPageFormat);

        try {
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
