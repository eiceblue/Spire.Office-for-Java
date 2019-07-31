import com.spire.pdf.*;

public class booklet {
    public static void main(String[] args) {
        String srcPdf = "data/booklet.pdf";
        String outputFile = "output/booklet_result.pdf";

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create booklet
        float width = (float) PdfPageSize.A4.getWidth() * 2;
        float height = (float) PdfPageSize.A4.getHeight();
        doc.createBooklet(srcPdf, width, height, true);

        //Save the file
        doc.saveToFile(outputFile);
        doc.close();
    }
}
