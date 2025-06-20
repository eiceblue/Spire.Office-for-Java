import com.spire.presentation.*;

public class specifyFontDirectory {
    public static void main(String[] args) throws Exception {
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ToPDF.pptx");
        //Specify font directory
        ppt.setCustomFontsFolder("data/Fonts/");
         //Save the PPT to PDF file format
        ppt.saveToFile("output/result.pdf", FileFormat.PDF);
    }
}
