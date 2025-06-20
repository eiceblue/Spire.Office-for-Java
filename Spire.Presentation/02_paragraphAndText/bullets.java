import com.spire.presentation.*;

public class bullets {
    public static void main(String[] args) throws Exception {
        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/bulltes.pptx");

        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(1);

        for (Object para : shape.getTextFrame().getParagraphs()) {
            //Add the bullets
            ParagraphEx paragraph = (ParagraphEx) para;
            paragraph.setBulletType(TextBulletType.NUMBERED);
            paragraph.setBulletStyle(NumberedBulletStyle.BULLET_ROMAN_LC_PERIOD);
        }

        //Save the document
        String output = "output/bullets.pptx";
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
