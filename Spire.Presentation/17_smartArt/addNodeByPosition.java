import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;
import com.spire.presentation.drawing.*;

public class addNodeByPosition {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/AddSmartArtNode2.pptx");

        for (Object shapeObj : presentation.getSlides().get(0).getShapes()){
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt){
                //Get the SmartArt and collect nodes
                ISmartArt smartArt = (ISmartArt)shape;
                int position = 0;
                //Add a new node at specific position
                ISmartArtNode node = smartArt.getNodes().addNodeByPosition(position);
                //Add text and set the text style
                node.getTextFrame().setText("New Node");
                node.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
                node.getTextFrame().getTextRange().getFill().getSolidColor().setKnownColor(KnownColors.RED);

                //Get a node
                node  =  smartArt.getNodes().get(1);
                position = 1;
                //Add a new child node at specific position
                ISmartArtNode childNode = node.getChildNodes().addNodeByPosition(position);
                //Add text and set the text style
                childNode.getTextFrame().setText ("New child node");
                childNode.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
                childNode.getTextFrame().getTextRange().getFill().getSolidColor().setKnownColor(KnownColors.BLUE);
            }
        }
        String result = "output/addNodeByPosition_result.pptx";
        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
