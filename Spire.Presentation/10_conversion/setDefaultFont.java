import com.spire.presentation.*;


public class setDefaultFont {
    public static void main(String[] args) throws Exception {
        //Set the default font
        Presentation.setDefaultFontName("Bell MT");
        //Load PPT document from disk
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/SetDefaultFont.pptx");
        //Save the PPT document
        ppt.saveToFile("output/SetDefaultFont_out.pdf", FileFormat.PDF);
        //Reset the default font
        Presentation.resetDefaultFontName();
    }
}
