import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;

public class assistantNode {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/AddSmartArtNode.pptx");
        ISmartArtNode node;
        for (Object shapeObj : presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt and collect nodes
                ISmartArt smartArt = (ISmartArt)shape;
                ISmartArtNodeCollection nodes = smartArt.getNodes();

                //Traverse through all nodes inside SmartArt
                for (int i = 0; i < nodes.getCount(); i++)
                {
                    //Access SmartArt node at index i
                    node = nodes.get(i);
                    // Check if node is assitant node
                    if (!node.isAssistant())
                    {
                        //Set node as assitant node
                        node.isAssistant(true);
                    }
                }
            }
        }
        String result = "output/assistantNode.pptx";

        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
