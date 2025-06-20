import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class set3DEffectForShape {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        String ImageFile ="data/bg.png";
        Rectangle2D rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Add shape1 and fill it with color
        IAutoShape shape1 = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.ROUND_CORNER_RECTANGLE, new Rectangle2D.Double(150, 150, 150, 150));
        shape1.getFill().setFillType(FillFormatType.SOLID);
        shape1.getFill().getSolidColor().setKnownColor(KnownColors.SKY_BLUE);
        //Initialize a new instance of the 3-D class for shape1 and set its properties
        ShapeThreeD effect1 = shape1.getThreeD().getShapeThreeD();
        effect1.setPresetMaterial(PresetMaterialType.POWDER);
        effect1.getTopBevel().setPresetType(BevelPresetType.ART_DECO);
        effect1.getTopBevel().setHeight(4);
        effect1.getTopBevel().setWidth(12);
        effect1.setBevelColorMode(BevelColorType.CONTOUR);
        effect1.getContourColor().setKnownColor(KnownColors.LIGHT_GRAY);;
        effect1.setContourWidth(3.5);

        //Add shape2 and fill it with color
        IAutoShape shape2 = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.PENTAGON, new Rectangle2D.Double(400, 150, 150, 150));
        shape2.getFill().setFillType(FillFormatType.SOLID);
        shape2.getFill().getSolidColor().setKnownColor(KnownColors.LIGHT_GREEN);
        //Initialize a new instance of the 3-D class for shape2 and set its properties
        ShapeThreeD effect2 = shape2.getThreeD().getShapeThreeD();
        effect2.setPresetMaterial(PresetMaterialType.SOFT_EDGE);
        effect2.getTopBevel().setPresetType(BevelPresetType.SOFT_ROUND);
        effect2.getTopBevel().setHeight(12);
        effect2.getTopBevel().setWidth(12);
        effect2.setBevelColorMode(BevelColorType.CONTOUR);
        effect2.getContourColor().setKnownColor(KnownColors.LIGHT_GREEN);
        effect2.setContourWidth(5);

        //Save the document
        String result = "output/set3DEffectForShape.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
