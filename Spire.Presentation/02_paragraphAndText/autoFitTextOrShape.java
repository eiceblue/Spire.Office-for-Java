import com.spire.presentation.*;

import java.awt.*;

public class autoFitTextOrShape {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        String ImageFile = "data/bg.png";
        Rectangle rect = new Rectangle(0, 0, (int)ppt.getSlideSize().getSize().getWidth(), (int)ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Set the AutofitType property to Shape
        IAutoShape textShape2 = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(150, 100, 150, 80));
        textShape2.getTextFrame().setText("Resize shape to fit text.");
        textShape2.getTextFrame().setAutofitType(TextAutofitType.SHAPE);

        //Set the AutofitType property to Normal
        IAutoShape textShape1 = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(400, 100, 150, 80));
        textShape1.getTextFrame().setText("Shrink text to fit shape. Shrink text to fit shape. Shrink text to fit shape. Shrink text to fit shape.");
        textShape1.getTextFrame().setAutofitType(TextAutofitType.NORMAL);

        //Save the document
        String result = "output/autoFitTextOrShape.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
