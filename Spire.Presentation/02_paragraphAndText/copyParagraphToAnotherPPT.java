import com.spire.presentation.*;

public class copyParagraphToAnotherPPT {
    public static void main(String[] args) throws Exception {
        //Load the source file
        Presentation ppt1 = new Presentation();
        ppt1.loadFromFile("data/textTemplate.pptx");

        //Get the text from the first shape on the first slide
        IShape sourceshp = ppt1.getSlides().get(0).getShapes().get(0);
        String text1 = ((IAutoShape) sourceshp).getTextFrame().getText();

        //Load the target file
        Presentation ppt2 = new Presentation();
        ppt2.loadFromFile("data/copyParagraph.pptx");

        //Get the first shape on the first slide from the target file
        IShape destshp = ppt2.getSlides().get(0).getShapes().get(0);

        //Add the text to the target file
        String text2 = ((IAutoShape) destshp).getTextFrame().getText();
        ((IAutoShape) destshp).getTextFrame().setText(text2 + "\n\n" + text1);

        //Save the document
        String result = "output/copyParagraphToAnotherPPT.pptx";
        ppt2.saveToFile(result, FileFormat.PPTX_2013);
    }
}
