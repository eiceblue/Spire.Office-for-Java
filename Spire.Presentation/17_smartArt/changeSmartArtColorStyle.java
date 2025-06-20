import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;

public class changeSmartArtColorStyle {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/AddSmartArtNode.pptx");

        for (Object shapeObj: presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt and collect nodes
                ISmartArt smartArt = (ISmartArt)shape;
                // Check SmartArt color type
                if (smartArt.getColorStyle().equals(SmartArtColorType.COLORED_FILL_ACCENT_1))
                {
                    // Change SmartArt color type
                    smartArt.setColorStyle(SmartArtColorType.COLORFUL_ACCENT_COLORS);
                }
            }
        }
        String result = "output/changeSmartArtColorStyle.pptx";

        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
