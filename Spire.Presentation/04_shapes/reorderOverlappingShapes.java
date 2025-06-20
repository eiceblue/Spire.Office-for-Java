import com.spire.presentation.*;

public class reorderOverlappingShapes {
    public static void main(String[] args) throws Exception {
        String input="data/overlappingShapes.pptx";
        String output = "output/reorderOverlappingShapes_result.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Load file
        ppt.loadFromFile(input);

        //Get the first shape of the first slide
        IShape shape = ppt.getSlides().get(0).getShapes().get(0);

        //Change the shape's zorder
        ppt.getSlides().get(0).getShapes().zOrder(1,shape);

        //Save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
