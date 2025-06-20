import com.spire.presentation.*;

public class slideTitle {
    public static void main(String[] args) throws Exception {
        String inputFile="data/inputTemplate.pptx";
        String outputFile = "output/slideTitle_result.pptx";

        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Get the title of the first slide
        String slideTitle = slide.getTitle();
        System.out.println("The title of slide1 is: "+slideTitle);

        //Set the title of the second slide
        presentation.getSlides().get(1).setTitle("Second Slide");

        //Save to file.
        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
