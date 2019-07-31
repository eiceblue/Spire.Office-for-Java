import com.spire.presentation.*;

public class rotateShape {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/rotateShape.pptx";
        String outputFile = "output/rotateShape_result.pptx";

        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the shapes
        IAutoShape shape = (IAutoShape) ppt.getSlides().get(0).getShapes().get(0);

        //Set the rotation
        shape.setRotation(60);

        ((IAutoShape) ppt.getSlides().get(0).getShapes().get(1)).setRotation(120);
        ((IAutoShape) ppt.getSlides().get(0).getShapes().get(2)).setRotation(180);
        ((IAutoShape) ppt.getSlides().get(0).getShapes().get(3)).setRotation(240);

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
