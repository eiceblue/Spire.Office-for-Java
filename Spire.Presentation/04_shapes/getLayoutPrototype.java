import com.spire.presentation.*;

public class getLayoutPrototype {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk
        presentation.loadFromFile("data/colorMap.pptx");
        IShape Shape=presentation.getSlides().get(0).getShapes().get(0);

        //Get layout prototype
        Shape getLayoutPrototype = Shape.getLayoutPrototype();


    }


}
