import com.spire.presentation.*;

import java.io.*;

public class getTextFrameEffectiveData {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az1.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        //Get a shape 
        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(0);

        ITextFrameProperties textFrameFormat = shape.getTextFrame();
        StringBuilder str = new StringBuilder();
        str.append("Anchoring type: " + textFrameFormat.getAnchoringType() + "\r\n");
        str.append("Autofit type: " + textFrameFormat.getAutofitType() + "\r\n");
        str.append("Text vertical type: " + textFrameFormat.getVerticalTextType() + "\r\n");
        str.append("Margins" + "\r\n");
        str.append("   Left: " + textFrameFormat.getMarginLeft() + "\r\n");
        str.append("   Top: " + textFrameFormat.getMarginTop() + "\r\n");
        str.append("   Right: " + textFrameFormat.getMarginRight() + "\r\n");
        str.append("   Bottom: " + textFrameFormat.getMarginBottom());

        //Save to text file
        String output = "output/getTextFrameEffectiveData.txt";
        FileWriter writer = new FileWriter(output);
        writer.write(str.toString());
        writer.flush();
        writer.close();
    }
}
