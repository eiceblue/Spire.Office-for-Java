import com.spire.presentation.*;

public class copyShapesBetweenSlides {
    public static void main(String[] args) throws Exception {
        String input="data/copyShapesBetweenSlides.pptx";
        String output= "output/copyShapesBetweenSlides_result.pptx";

        //Load the sample document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //Define the source slide and target slide
        ISlide sourceSlide = ppt.getSlides().get(0);
        ISlide targetSlide = ppt.getSlides().get(1);

        //Copy the first shape from the source slide to the target slide
        targetSlide.getShapes().addShape((Shape)sourceSlide.getShapes().get(0));

        //Save the document to file
        ppt.saveToFile(output, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
