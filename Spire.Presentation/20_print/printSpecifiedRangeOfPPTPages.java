import com.spire.ms.Printing.PrintRange;
import com.spire.presentation.*;

public class printSpecifiedRangeOfPPTPages {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_6.pptx");

        PresentationPrintDocument document = new PresentationPrintDocument(presentation);

        //Set the document name to display while printing the document.
        document.setDocumentName("Template_Ppt_6.pptx");

        //Choose to print some pages from the PowerPoint document.
        document.getPrinterSettings().setPrintRange( PrintRange.SomePages);
        document.getPrinterSettings().setFromPage(2);
        document.getPrinterSettings().setToPage(3);

        short copyies=2;
        //Set the number of copies of the document to print.
        document.getPrinterSettings().setCopies(copyies);

        presentation.print(document);
    }
}
