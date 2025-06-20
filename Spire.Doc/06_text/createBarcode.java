import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class createBarcode {
    public static void main(String[] args) {
        //Create a document
        Document doc = new Document();

        //Add a paragraph
        Paragraph p = doc.addSection().addParagraph();

        //Add barcode and set its format
        TextRange txtRang = p.appendText("H63TWX11072");
        //Set barcode font name, note you need to install the barcode font on your system at first
        txtRang.getCharacterFormat().setFontName("C39HrP60DlTt");

        //Set the font size
        txtRang.getCharacterFormat().setFontSize(80);

        //Set the text color
        txtRang.getCharacterFormat().setTextColor(Color.blue);

        //Save the document
        String output = "output/createBarcode.docx";
        doc.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        doc.dispose();
    }
}
