import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class preventOrAllowChangingShape {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String result = "output/preventOrAllowChangingShape.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getSolidFillColor().setColor(Color.white);

        //Add a rectangle shape to the slide
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(50, 100, 400, 150));

        //Set the shape format
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getShapeStyle().getLineColor().setColor(Color.gray);
        shape.getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.JUSTIFY);
        shape.getTextFrame().setText("Demo for locking shapes:\n    Green/Black stands for editable.\n    Grey stands for non-editable.");
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setLatinFont(new TextFont("Arial Rounded MT Bold"));
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.black);

        //The changes of selection and rotation are allowed
        shape.getLocking().setRotationProtection(false);
        shape.getLocking().setSelectionProtection(false);
        //The changes of size, position, shape type, aspect ratio, text editing and ajust handles are not allowed
        shape.getLocking().setResizeProtection(true);
        shape.getLocking().setPositionProtection(true);
        shape.getLocking().setShapeTypeProtection(true);
        shape.getLocking().setAspectRatioProtection(true);
        shape.getLocking().setTextEditingProtection(true);
        shape.getLocking().setAdjustHandlesProtection(true);

        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
