import com.spire.doc.*;
import com.spire.doc.documents.BackgroundType;
import java.io.*;

public class setImageBackground {
    public static void main(String[] args) throws IOException {

        String inputFile="data/setImageBackground.docx";
        String backgroundImg="data/background.png";
        String outputFile="output/setImageBackground.docx";

        //load a word document
        Document document=new Document(inputFile);

        //set the background type as picture
        document.getBackground().setType(BackgroundType.Picture);

        //set the background picture
        document.getBackground().setPicture(backgroundImg);

        //save the file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
