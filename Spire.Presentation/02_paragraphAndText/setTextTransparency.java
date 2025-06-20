import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setTextTransparency {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        String imageFile = "data/bg.png";
        Rectangle rect = new Rectangle(0, 0, (int) ppt.getSlideSize().getSize().getWidth(),
                (int) ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.WHITE);

        //Add a shape
        IAutoShape textboxShape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(100, 100, 300, 120));
        textboxShape.getShapeStyle().getLineColor().setColor(Color.white);
        textboxShape.getFill().setFillType(FillFormatType.NONE);

        //Remove default blank paragraphs
        textboxShape.getTextFrame().getParagraphs().clear();

        //Add three paragraphs, apply color with different alpha values to text
        float alpha = 0.25f;
        for (int i = 0; i < 3; i++) {
            textboxShape.getTextFrame().getParagraphs().append(new ParagraphEx());
            textboxShape.getTextFrame().getParagraphs().get(i).getTextRanges().append(new PortionEx("Text Transparency"));
            textboxShape.getTextFrame().getParagraphs().get(i).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
            Color color = new Color(1.0F, 0.75F, 0.0F, alpha);
            textboxShape.getTextFrame().getParagraphs().get(i).getTextRanges().get(0).getFill().getSolidColor().
                    setColor(color);
            alpha += 0.2;
        }

        //Save the document
        String result = "output/setTextTransparency.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
