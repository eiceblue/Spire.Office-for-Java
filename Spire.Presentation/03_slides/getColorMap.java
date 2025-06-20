import com.spire.presentation.*;
import com.spire.presentation.drawing.SchemeColor;

import java.io.*;

public class getColorMap {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/colorMap.pptx");
        StringBuilder sb = new StringBuilder();
        IMasterSlide masterSlide = presentation.getMasters().get(0);
        for (SchemeColor schemeColor : masterSlide.getColorMap().keySet()) {
            masterSlide.getColorMap().get(schemeColor);
            String content = "key : " +schemeColor +"\tvalue : "+
                    masterSlide.getColorMap().get(schemeColor) + "\r\n";
            sb.append(content);
        }

        writeStringToTxt(sb.toString(),"output/getColorMap.txt");
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
