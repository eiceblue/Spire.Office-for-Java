import com.spire.presentation.Presentation;
import java.io.FileOutputStream;
import java.util.List;

public class pptToSvgRetainNotes {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_5.pptx");

        //Retain the notes while converting PowerPoint file to svg file.
        presentation.setNoteRetained(true);

        //Convert presentation slides to svg file.
        List<byte[]> bytes = presentation.saveToSVG();

        int length = bytes.size();
        for (int i = 0; i < length; i++)
        {
            String result = String.format("output/pptToSvgRetainNotes_{0}.svg", i);
            FileOutputStream outputStream=new FileOutputStream(result);

            byte[] outputBytes = bytes.get(i);
            outputStream.write(outputBytes, 0, outputBytes.length);
        }
        presentation.dispose();
    }
}
