import com.spire.presentation.*;

public class alignment {
    public static void main(String[] args) throws Exception {
        //Create a PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/alignment.pptx");

        //Get the related shape and set the text alignment
        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(1);
        shape.getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.LEFT);
        shape.getTextFrame().getParagraphs().get(1).setAlignment(TextAlignmentType.CENTER);
        shape.getTextFrame().getParagraphs().get(2).setAlignment(TextAlignmentType.RIGHT);
        shape.getTextFrame().getParagraphs().get(3).setAlignment(TextAlignmentType.JUSTIFY);
        shape.getTextFrame().getParagraphs().get(4).setAlignment(TextAlignmentType.NONE);

        //Save the document
        String output = "output/alignment.pptx";
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
