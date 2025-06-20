import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class set3DEffectForText {
    public static void main(String[] args) throws Exception {
        //Create a new presentation object
        Presentation ppt = new Presentation();

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Append a new shape to slide and set the line color and fill type
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(30, 40, 650, 200));
        shape.getShapeStyle().getLineColor().setColor(Color.WHITE);
        shape.getFill().setFillType(FillFormatType.NONE);

        //Add text to the shape
        shape.appendTextFrame("This demo shows how to add 3D effect text to Presentation slide");

        //Set the color of text in shape
        PortionEx textRange = shape.getTextFrame().getTextRange();
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.BLUE);

        //Set the Font of text in shape
        textRange.setFontHeight(40);
        textRange.setLatinFont(new TextFont("Arial"));

        //Set 3D effect for text
        shape.getTextFrame().getTextThreeD().getShapeThreeD().setPresetMaterial(PresetMaterialType.MATTE);
        shape.getTextFrame().getTextThreeD().getLightRig().setPresetType(PresetLightRigType.SUNRISE);
        shape.getTextFrame().getTextThreeD().getShapeThreeD().getTopBevel().setPresetType(BevelPresetType.CIRCLE);
        shape.getTextFrame().getTextThreeD().getShapeThreeD().getContourColor().setColor(Color.BLUE);
        shape.getTextFrame().getTextThreeD().getShapeThreeD().setContourWidth(3);

        //Save the document
        String result = "output/set3DEffectForText.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
