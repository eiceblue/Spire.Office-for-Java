import com.spire.presentation.*;

public class customBulletsNumber {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/bulltes2.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Access the first placeholder in the slide and typecasting it as AutoShape
        ITextFrameProperties tf1 = ((IAutoShape) slide.getShapes().get(1)).getTextFrame();

        //Access the first Paragraph and set bullet style
        ParagraphEx para = tf1.getParagraphs().get(0);
        para.setDepth((short) 0);
        para.setBulletType(TextBulletType.NUMBERED);
        para.setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);
        para.setBulletNumber((short) 2);

        //Access the second Paragraph and set bullet style
        para = tf1.getParagraphs().get(1);
        para.setDepth((short) 0);
        para.setBulletType(TextBulletType.NUMBERED);
        para.setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);
        para.setBulletNumber((short) 4);

        //Access the third Paragraph and set bullet style
        para = tf1.getParagraphs().get(2);
        para.setDepth((short) 0);
        para.setBulletType(TextBulletType.NUMBERED);
        para.setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);
        para.setBulletNumber((short) 6);

        //Access the fourth Paragraph and set bullet style
        para = tf1.getParagraphs().get(3);
        para.setDepth((short) 0);
        para.setBulletType(TextBulletType.NUMBERED);
        para.setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);
        para.setBulletNumber((short) 7);

        String result = "output/customBulletsNumber.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
