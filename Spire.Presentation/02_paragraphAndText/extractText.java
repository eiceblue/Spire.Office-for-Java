import com.spire.presentation.*;
import java.io.FileWriter;

public class extractText {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/extractText.pptx";
        String outputFile = "output/extractText_result.txt";

        //Create a PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

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
        FileWriter writer = new FileWriter(outputFile);
        writer.write(buffer.toString());
        writer.flush();
        writer.close();
    }
}
