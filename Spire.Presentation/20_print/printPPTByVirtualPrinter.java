import com.spire.presentation.*;

public class printPPTByVirtualPrinter {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_6.pptx");

        //Print PowerPoint document to virtual printer (Microsoft XPS Document Writer).
        PresentationPrintDocument document = new PresentationPrintDocument(presentation);
        document.getPrinterSettings().setPrinterName("Microsoft XPS Document Writer");

        presentation.print(document);
    }
}
