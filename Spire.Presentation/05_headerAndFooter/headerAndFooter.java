import com.spire.presentation.*;

public class headerAndFooter {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/headerAndFooter.pptx";
        String outputFile = "output/headerAndFooter_result.pptx";

        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Add footer
        presentation.setFooterText("Demo of Spire.Presentation");
        //Set the footer visible
        presentation.setFooterVisible(true);
        //Set the page number visible
        presentation.setSlideNumberVisible(true);
        //Set the date visible
        presentation.setDateTimeVisible(true);
        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
