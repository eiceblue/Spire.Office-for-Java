import com.spire.presentation.*;

import java.io.*;

public class convertToOneSvg {
    public static void main(String[] args) throws Exception {
        //load PPT file from disk
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/Images.pptx");

        //startSlide:Start slide index, endSlide:End slide index
        byte[] bytes = ppt.saveToOneSVG(0,1);

        //Write SVG bytes to file
        FileOutputStream fos = new FileOutputStream(new File("convertToOneSvg.svg"));
        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
