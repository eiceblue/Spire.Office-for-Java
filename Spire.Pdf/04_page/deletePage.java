import com.spire.pdf.*;

public class deletePage {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument("data/deletePage.pdf");
        //Delete the third page
        doc.getPages().removeAt(2);
        //Save the document
        doc.saveToFile("output/deletePage.pdf");
        doc.close();
    }
}

