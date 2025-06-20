import com.spire.ms.Printing.PrintRange;
import com.spire.presentation.*;

public class printMultipleSlidesIntoOnePage {
    public static void main(String[] args) throws Exception{
        //Create a PPT document
        Presentation ppt = new Presentation();

        //Load the document from disk
        ppt.loadFromFile("data/PrintMultipleSlidesIntoOnePage.pptx");
        PresentationPrintDocument document = new PresentationPrintDocument(ppt);

        //Set print task name
        document.setDocumentName("print task 1");
        document.setPrintOrder(Order.Horizontal);
        document.setSlideFrameForPrint(true);

        //Set Gray level when printing
        document.setGrayLevelForPrint(true);
        //Set four slides on one page
        document.setSlideCountPerPageForPrint(PageSlideCount.Four);

        //Set continuous print area
        document.getPrinterSettings().setPrintRange(PrintRange.SomePages);
        document.getPrinterSettings().setFromPage(1);
        document.getPrinterSettings().setToPage(ppt.getSlides().getCount()-1);

        //Set discontinuous print area
        //document.selectSlidesForPrint("1", "2-4");

        ppt.print(document);
        ppt.dispose();
    }
}
