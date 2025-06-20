import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class textWaterMark {
    public static void main(String[] args) {
        // Open a Word document as a template
        Document document = new Document("data/sampleB_2.docx");

        // Insert text watermark into the first section of the document
        insertTextWatermark(document.getSections().get(0));

        // Save the document as a docx file
        String output = "output/textWaterMark.docx";
        document.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }

    public static void insertTextWatermark(Section section) {
        // Create a TextWatermark object
        TextWatermark txtWatermark = new TextWatermark();

        // Set the text content of the watermark
        txtWatermark.setText("E-iceblue");

        // Set the font size of the watermark
        txtWatermark.setFontSize(25);

        // Set the color of the watermark
        txtWatermark.setColor(Color.blue);

        // Set the layout of the watermark to Diagonal
        txtWatermark.setLayout(WatermarkLayout.Diagonal);

        // Set the watermark for the document's section
        section.getDocument().setWatermark(txtWatermark);
    }
}
