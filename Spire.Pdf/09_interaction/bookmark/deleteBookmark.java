import com.spire.pdf.PdfDocument;

public class deleteBookmark {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteBookmark.pdf");

        doc.getBookmarks().removeAt(0);

        doc.saveToFile("output/deleteBookmark.pdf");
        doc.close();
    }
}
