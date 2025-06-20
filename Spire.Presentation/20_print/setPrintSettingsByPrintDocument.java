import com.spire.presentation.*;

public class setPrintSettingsByPrintDocument {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_6.pptx");

        //Use PrintDocument object to print presentation slides.
        PresentationPrintDocument document = new PresentationPrintDocument(presentation);

        //Print document to virtual printer.
        document.getPrinterSettings().setPrinterName("Microsoft XPS Document Writer");

        //Print the slide with frame.
        presentation.setSlideFrameForPrint(true);

        //Print 4 slides horizontal.
        presentation.setSlideCountPerPageForPrint(PageSlideCount.Four);
        presentation.setOrderForPrint(Order.Horizontal);

        //Print the slide with Grayscale.
        presentation.setGrayLevelForPrint(true);

        //Set the print document name.
        document.setDocumentName("Template_Ppt_6.pptx");

        document.getPrinterSettings().setPrintToFile(true);

        String result = "output/setPrintSettingsByPrintDocument.xps";
        document.getPrinterSettings().setPrintFileName(result);

        //Print the file
        presentation.print(document);
    }
}
