import com.spire.ms.Printing.PrinterSettings;
import com.spire.presentation.Presentation;

public class specificPrinterToPrint {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT document from disk.
        presentation.loadFromFile("data/ChangeSlidePosition.pptx");

        //New PrintSeetings
        PrinterSettings printerSettings = new PrinterSettings();

        //Set landscape for page
        printerSettings.getDefaultPageSettings().setLandscape(true);

        //Specific the printer
        printerSettings.setPrinterName("Microsoft XPS Document Writer");

        //Print
        presentation.print(printerSettings);
    }
}
