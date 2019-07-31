import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class insertOLE {
    public static void main(String[] args) throws IOException {
        String inputImage = "data/excel.png";
        String inputOle="data/example.xlsx";
        String output = "output/insertOLE.docx";
        //create a document
        Document doc = new Document();

        //add a section
        Section sec = doc.addSection();

        //add a paragraph
        Paragraph par = sec.addParagraph();

        //load the image
        DocPicture picture = new DocPicture(doc);

        picture.loadImage(inputImage);

        //insert the OLE
        par.appendOleObject(inputOle, picture, OleObjectType.Excel_Worksheet);
        doc.saveToFile(output, FileFormat.Docx_2013);
    }
}
