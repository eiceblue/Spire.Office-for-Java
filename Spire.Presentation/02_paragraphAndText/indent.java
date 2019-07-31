import com.spire.presentation.*;

public class indent {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/indent.pptx";
        String outputFile = "output/indent_result.pptx";

        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(0);
        Object paras = shape.getTextFrame().getParagraphs();

        //Set the paragraph style for first paragraph
        shape.getTextFrame().getParagraphs().get(0).setIndent(20);
        shape.getTextFrame().getParagraphs().get(0).setLeftMargin(10);
        shape.getTextFrame().getParagraphs().get(0).setSpaceAfter(10);

        //Set the paragraph style of the third paragraph
        shape.getTextFrame().getParagraphs().get(2).setIndent(-100);
        shape.getTextFrame().getParagraphs().get(2).setLeftMargin(40);
        shape.getTextFrame().getParagraphs().get(2).setSpaceBefore(0);
        shape.getTextFrame().getParagraphs().get(2).setSpaceAfter(0);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
