import com.spire.presentation.*;

import java.io.FileWriter;

public class setAndGetAlternativeText {
    public static void main(String[] args) throws Exception {
        String inputFile="data/shapeTemplate.pptx";
        String pptxFile = "output/setAlternativeText.pptx";
        String txtFile = "output/getAlternativeText.txt";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile(inputFile);

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Set the alternative text (title and description)
        slide.getShapes().get(0).setAlternativeTitle("Rectangle");
        slide.getShapes().get(0).setAlternativeText("This is a Rectangle");

        //Get the alternative text (title and description)
        String alternativeText = null;
        String title = slide.getShapes().get(0).getAlternativeTitle();
        alternativeText += "Title: " + title + "\r\n";
        String description = slide.getShapes().get(0).getAlternativeText();
        alternativeText += "Description: " + description;

        //Save the document
        ppt.saveToFile(pptxFile, FileFormat.PPTX_2013);

        //Save the alternative text to Text file
        FileWriter writer = new FileWriter(txtFile);
        writer.write(alternativeText);
        writer.flush();
        writer.close();
        ppt.dispose();
    }
}
