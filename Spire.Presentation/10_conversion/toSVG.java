import com.spire.presentation.Presentation;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class toSVG {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/toSVG.pptx";
        String outputFile="output/";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        ArrayList<byte[]> svgBytes =(ArrayList<byte[]>) ppt.saveToSVG();
        int count = svgBytes.size();
        int len = svgBytes.size();
        for (int i = 0; i < len; i++)
        {
            byte[] bytes = svgBytes.get(i);
            FileOutputStream stream = new FileOutputStream(String.format(outputFile + "ToSVG-%d.svg", i));
            stream.write(bytes);
        }
        ppt.dispose();
    }
}