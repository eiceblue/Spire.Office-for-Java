import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;

public class changeSmartArtShapeStyle {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/AddSmartArtNode.pptx");

        for (Object shapeObj : presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt and collect nodes
                ISmartArt smartArt = (ISmartArt)shape;
                //Check SmartArt style
                if (smartArt.getStyle() == SmartArtStyleType.SIMPLE_FILL)
                {
                    //Change SmartArt Style
                    smartArt.setStyle(SmartArtStyleType.CARTOON);
                }
            }
        }

        String result = "output/changeSmartArtShapeStyle.pptx";

        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
