import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;
import com.spire.presentation.drawing.FillFormatType;

public class addSmartArtNode {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/addSmartArtNode.pptx";
        String outputFile="output/addSmartArtNode_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Get the SmartArt
        ISmartArt sa = (ISmartArt) ((ppt.getSlides().get(0).getShapes().get(0) instanceof ISmartArt) ? ppt.getSlides().get(0).getShapes().get(0) : null);
        //Add a node
        ISmartArtNode node = sa.getNodes().addNode();
        //Add text and set the text style
        node.getTextFrame().setText("AddText");
        node.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        node.getTextFrame().getTextRange().getFill().getSolidColor().setKnownColor(KnownColors.HOT_PINK);

        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
