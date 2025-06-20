import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;

public class changeNodeText {
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
                //Obtain the reference of a node by using its Index
                // select second root node
                ISmartArtNode node = smartArt.getNodes().get(1);
                // Set the text of the TextFrame
                node.getTextFrame().setText("Second root node");
            }
        }

        String result = "output/changeNodeText.pptx";

        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
