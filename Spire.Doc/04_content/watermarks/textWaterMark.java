import com.spire.doc.*;
import com.spire.doc.documents.WatermarkLayout;
import java.awt.*;

public class textWaterMark {
    public static void main(String[] args) {

        String inputFile="data/watermarkTemplate.doc";
        String outputFile="output/textWaterMark.docx";

        //open a Word document as template
        Document document = new Document(inputFile);

        //insert text watermark
        insertTextWatermark(document.getSections().get(0));

        //save to file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
    private static void insertTextWatermark(Section section) {
        TextWatermark txtWatermark = new TextWatermark();
        txtWatermark.setText("E-iceblue");
        txtWatermark.setFontSize(95);
        txtWatermark.setColor(Color.red);
        txtWatermark.setLayout(WatermarkLayout.Diagonal);
        section.getDocument().setWatermark(txtWatermark);
    }
}
