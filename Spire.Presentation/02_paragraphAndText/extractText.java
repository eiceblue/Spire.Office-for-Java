import com.spire.presentation.*;

import java.io.*;

public class extractText {
    public static void main(String[] args) throws Exception {
        //Create a PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/extractText.pptx");

        StringBuilder buffer = new StringBuilder();

        //Foreach the slide and extract text
        for (Object slide : presentation.getSlides()) {
            for (Object shape : ((ISlide) slide).getShapes()) {
                if (shape instanceof IAutoShape) {
                    for (Object tp : ((IAutoShape) shape).getTextFrame().getParagraphs()) {
                        buffer.append(((ParagraphEx) tp).getText());
                    }
                }
            }
        }
        //Save text
        String output = "output/extractText.txt";
        FileWriter writer = new FileWriter(output);
        writer.write(buffer.toString());
        writer.flush();
        writer.close();
    }
}
