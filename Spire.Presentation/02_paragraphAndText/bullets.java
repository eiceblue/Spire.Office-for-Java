import com.spire.presentation.*;
import com.spire.presentation.NumberedBulletStyle;

public class bullets {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/bulltes.pptx";
        String outputFile = "output/bullets_result.pptx";

        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(1);

        for (Object para : shape.getTextFrame().getParagraphs()) {
            //Add the bullets
            ParagraphEx paragraph = (ParagraphEx) para;
            paragraph.setBulletType(TextBulletType.NUMBERED);
            paragraph.setBulletStyle(NumberedBulletStyle.BULLET_ROMAN_LC_PERIOD);
        }

        //Save the document and launch
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}

