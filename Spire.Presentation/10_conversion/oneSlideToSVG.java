import com.spire.presentation.*;
import java.io.*;

public class oneSlideToSVG {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/OneSlideToSVG.pptx");

        //Convert the second slide to SVG
        byte[] svgByte = presentation.getSlides().get(1).SaveToSVG();

        File file = new File("output/oneSlideToSVG_result.svg");
        OutputStream output = new FileOutputStream(file);
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
        bufferedOutput.write(svgByte);
    }
}
