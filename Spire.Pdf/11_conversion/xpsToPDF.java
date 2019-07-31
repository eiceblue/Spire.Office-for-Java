import com.spire.pdf.PdfDocument;

public class xPSToPDF {
    public static void main(String[] args) {
        String inputFile = "data/XPStoPDF.xps";
        String outputFile = "output/XPStoPDF_result.pdf";

        //Open xps document
        PdfDocument doc = new PdfDocument();
        doc.loadFromXPS(inputFile);

        //Convert to pdf file
        doc.saveToFile(outputFile);
        doc.close();
    }
}
