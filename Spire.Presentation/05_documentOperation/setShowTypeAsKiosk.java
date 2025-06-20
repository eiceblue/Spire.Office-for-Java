import com.spire.presentation.*;

public class setShowTypeAsKiosk {
    public static void main(String[] args) throws Exception {
        String input = "data/inputTemplate.pptx";
        String output = "output/setShowTypeAsKiosk.pptx";

        //create an instance of presentation document
        Presentation ppt = new Presentation();

        //load file
        ppt.loadFromFile(input);

        //specify the presentation show type as kiosk
        ppt.setShowType( SlideShowType.Kiosk);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
