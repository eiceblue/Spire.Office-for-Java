import com.spire.ms.Printing.StandardPrintController;
import com.spire.presentation.*;

public class silentlyPrintPPTByDefaultPrinter {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_6.pptx");

        //Print the PowerPoint document to default printer.
        PresentationPrintDocument document = new PresentationPrintDocument(presentation);
        document.setPrintController(new StandardPrintController());

        presentation.print(document);
    }
}
