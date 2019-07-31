import com.spire.pdf.PdfDocument;

public class deleteAnnotation {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteAnnotation.pdf");
        doc.getPages().get(0).getAnnotationsWidget().removeAt(0);
        doc.saveToFile("output/deleteAnnotation.pdf");
        doc.close();
    }
}
