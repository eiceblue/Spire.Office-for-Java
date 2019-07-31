import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;
import com.spire.presentation.drawing.FillFormatType;

public class createSmartArtShape {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/createSmartArtShape.pptx";
        String outputFile = "output/createSmartArtShape_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        ISmartArt sa = ppt.getSlides().get(0).getShapes().appendSmartArt(200, 60, 300, 300, SmartArtLayoutType.GEAR);

        //Set type and color of smartArt
        sa.setStyle(SmartArtStyleType.SUBTLE_EFFECT);
        sa.setColorStyle(SmartArtColorType.GRADIENT_LOOP_ACCENT_3);

        //Remove all shapes
        for (Object a : sa.getNodes()) {
            sa.getNodes().removeNode(0);
        }

        //Add two custom shapes with text
        ISmartArtNode node = sa.getNodes().addNode();
        sa.getNodes().get(0).getTextFrame().setText("aa");
        node = sa.getNodes().addNode();
        node.getTextFrame().setText("bb");
        node.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        node.getTextFrame().getTextRange().getFill().getSolidColor().setKnownColor(KnownColors.BLACK);

        //Save and launch the file
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
        ppt.dispose();
    }
}
