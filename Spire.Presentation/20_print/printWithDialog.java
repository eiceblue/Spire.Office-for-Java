import com.spire.presentation.*;
import java.awt.print.PrinterJob;

public class printWithDialog {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation ppt = new Presentation();

        //Load the file from disk.
        ppt.loadFromFile("data/print.pptx");

        //Get printer Job
        PrinterJob printerJob= PrinterJob.getPrinterJob();
        printerJob.setPrintable(ppt);
        printerJob.printDialog();
        
        //Print PPT
        printerJob.print();
        ppt.dispose();
    }
}
