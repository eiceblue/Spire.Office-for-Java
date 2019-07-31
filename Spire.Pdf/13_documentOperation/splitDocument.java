import com.spire.pdf.PdfDocument;

public class splitDocument {
    public static void main(String[] args) {
        String inputFile = "data/splitDocument.pdf";
        String outputFile = "output/splitDocument-{0}.pdf";

        int count = 0;
        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);
        count = doc.getPages().getCount();

        //Split document
        doc.split(outputFile, 0);
        doc.close();
    }
}
