import com.spire.presentation.*;

import java.io.*;

public class detectUsedThemes {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/themes.pptx");

        StringBuilder sb = new StringBuilder();
        String themeName = null;
        sb.append("This is the name list of the used theme below.\r\t");
        //Get the theme name of each slide in the document
        for (Object obj : ppt.getSlides()) {
            ISlide slide = (ISlide) obj;
            themeName = slide.getTheme().getName();
            sb.append(themeName + "\r\t");
        }

        //Save to the text document
        String output = "output/detectUsedThemes.txt";
        FileWriter writer = new FileWriter(output);
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }
}
