import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setShadowEffectForText {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        String imageFile = "data/bg.png";
        Rectangle rect = new Rectangle(0, 0, (int) ppt.getSlideSize().getSize().getWidth(),
                (int) ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.WHITE);
        ppt.getSlides().get(0).getSlideBackground().getFill().getPictureFill().getPicture().setUrl(imageFile);

        //Get reference of the slide
        ISlide slide = ppt.getSlides().get(0);

        //Add a new rectangle shape to the first slide
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(120, 100, 450, 200));
        shape.getFill().setFillType(FillFormatType.NONE);

        //Add the text to the shape and set the font for the text
        shape.appendTextFrame("Text shading on slides");
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setLatinFont(new TextFont("Arial Black"));
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setFontHeight(21);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.BLACK);

        ////Add inner shadow and set all necessary parameters
        //InnerShadowEffect Shadow = new InnerShadowEffect();

        //Add outer shadow and set all necessary parameters
        OuterShadowEffect Shadow = new OuterShadowEffect();

        Shadow.setBlurRadius(0);
        Shadow.setDirection(50);
        Shadow.setDistance(10);
        Shadow.getColorFormat().setColor(new Color(0xAD,0xD8,0xE6));

        //shape.TextFrame.TextRange.EffectDag.InnerShadowEffect = Shadow;
        shape.getTextFrame().getTextRange().getEffectDag().setOuterShadowEffect(Shadow);

        //Save the document
        String result = "output/setShadowEffect.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
