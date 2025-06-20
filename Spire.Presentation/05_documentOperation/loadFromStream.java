import com.spire.presentation.*;
import java.io.*;

public class loadFromStream {
    public static void main(String[] args) throws Exception {
        String input = "data/inputTemplate.pptx";
        String output = "output/loadFromStream.pptx";

        //create an instance of presentation document
        Presentation ppt = new Presentation();

        //load PowerPoint file from stream
        File file = new File(input);
        FileInputStream in = new FileInputStream(file);
        ppt.loadFromStream(in, FileFormat.PPTX_2013);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
        in.close();
    }
}
