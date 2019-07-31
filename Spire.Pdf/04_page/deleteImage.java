import com.spire.pdf.*;

public class deleteImage {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteImage.pdf");
        PdfPageBase page = doc.getPages().get(0);
        page.deleteImage(0);
        doc.saveToFile("output/deleteImage.pdf");
        doc.close();
    }
}
