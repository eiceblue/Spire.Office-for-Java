import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class createSlideMasterAndApply {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        ppt.getSlideSize().setType(SlideSizeType.SCREEN_16_X_9);

        //Add slides
        for (int i = 0; i < 4; i++) {
            ppt.getSlides().append();
        }

        //Get the first default slide master
        IMasterSlide first_master = ppt.getMasters().get(0);

        //Append another slide master
        ppt.getMasters().appendSlide(first_master);
        IMasterSlide second_master = ppt.getMasters().get(1);

        //Set different background image for the two slide masters
        String pic1 = "data/bg.png";
        String pic2 = "data/setbackground.png";
        //The first slide master
        Rectangle rect = new Rectangle(0, 0, (int) ppt.getSlideSize().getSize().getWidth(), (int) ppt.getSlideSize().getSize().getHeight());
        first_master.getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        first_master.getShapes().appendEmbedImage(ShapeType.RECTANGLE, pic1, rect);
        first_master.getSlideBackground().getFill().getPictureFill().getPicture().setUrl(pic1);
        //The second slide master
        second_master.getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        second_master.getShapes().appendEmbedImage(ShapeType.RECTANGLE, pic2, rect);
        second_master.getSlideBackground().getFill().getPictureFill().getPicture().setUrl(pic2);

        //Apply the first master with layout to the first slide
        ppt.getSlides().get(0).setLayout(first_master.getLayouts().get(1));

        //Apply the second master with layout to other slides
        for (int i = 1; i < ppt.getSlides().getCount(); i++) {
            ppt.getSlides().get(i).setLayout(second_master.getLayouts().get(8));
        }

        //Save the document
        String result = "output/createSlideMasterAndApply.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
