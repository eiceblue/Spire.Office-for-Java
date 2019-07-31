import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfMargins;

import java.awt.geom.Dimension2D;

public class toPDFA {
    public static void main(String[] args) {
        String inputFile = "data/toPDFA.pdf";
        String outputFile = "output/toPDFA_result.pdf";

        //Open pdf document
        PdfDocument document = new PdfDocument();
        document.loadFromFile(inputFile);
        //Convert to Pdf_A_1_B
        PdfNewDocument newDoc = new PdfNewDocument();
        newDoc.setConformance(PdfConformanceLevel.Pdf_A_1_B);
        for (PdfPageBase page : (Iterable<PdfPageBase>) document.getPages()) {
            Dimension2D size = page.getSize();
            PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));
            page.createTemplate().draw(p, 0, 0);
        }
        //Save the file
        newDoc.save(outputFile);
        newDoc.close();
    }
}
