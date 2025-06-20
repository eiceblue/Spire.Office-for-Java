import com.spire.presentation.*;

public class toHTML {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Load file
        ppt.loadFromFile("data/Conversion.pptx");

        //Save the document to HTML format
        String result = "output/ToHTML.html";
        ppt.saveToFile(result, FileFormat.HTML);
    }
}
