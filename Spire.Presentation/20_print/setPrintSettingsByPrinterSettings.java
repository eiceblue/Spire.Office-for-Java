import com.spire.ms.Printing.*;
import com.spire.presentation.*;

public class setPrintSettingsByPrinterSettings {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_6.pptx");

        //Use PrinterSettings object to print presentation slides.
        PrinterSettings ps = new PrinterSettings();
        ps.setPrintRange(PrintRange.AllPages);
        ps.setPrintToFile(true);
        String result = "output/setPrintSettingsByPrinterSettings.xps";
        ps.setPrintFileName(result);

        //Print the slide with frame.
        presentation.setSlideFrameForPrint(true);

        //Print the slide with Grayscale.
        presentation.setGrayLevelForPrint(true);

        //Print 4 slides horizontal.
        presentation.setSlideCountPerPageForPrint(PageSlideCount.Four);
        presentation.setOrderForPrint(Order.Horizontal);

        //Only select some slides to print.
        presentation.SelectSlidesForPrint("1", "3");

        //Print the document.
        presentation.print(ps);
    }
}
