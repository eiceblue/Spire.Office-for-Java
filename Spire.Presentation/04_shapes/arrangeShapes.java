import com.spire.presentation.*;

public class arrangeShapes {
    public static void main(String[] args) throws Exception {
        String input="data/arrangeShape.pptx";
        String output = "output/arrangeShapes_result.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Load file
        ppt.loadFromFile(input);

        //Get the specified shape
        IShape shape = ppt.getSlides().get(0).getShapes().get(0);

        //Bring the shape forward through SetShapeArrange method
        shape.setShapeArrange(ShapeAlignmentEnum.ShapeArrange.BringForward);

        //Save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
