import com.spire.pdf.*;
import java.awt.*;
import com.spire.pdf.general.find.PdfTextFind;

public class findAndHighlightText {
    public static void main(String[] args) throws Exception {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/findAndHighlightText.pdf");
        PdfTextFind[] result = null;
        for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
            result = page.findText("science").getFinds();
            for (PdfTextFind find : result) {
                find.applyHighLight(Color.yellow);
            }
        }
        pdf.saveToFile("output/findAndHighlightText.pdf");
        pdf.close();
    }
}
