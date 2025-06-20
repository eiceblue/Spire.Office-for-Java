import com.spire.presentation.*;

public class convertPdfWithDefaultFont {
    public static void main(String[] args) throws Exception {
        //Create a ppt document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ConvertPdfWithDefaultFont.pptx");

        //The font is preferred to convert to pdf or pictures, when the font used in the document is not installed in the system
        Presentation.setDefaultFontName("Arial");

        //Save to file
        ppt.saveToFile("ConvertPdfWithDefaultFont.pdf", FileFormat.PDF);
    }
}
