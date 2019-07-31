import com.spire.pdf.*;


public class imageWaterMark {
    public static void main(String[] args) {
        //Create a pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/waterMark.pdf");
        PdfPageBase page =  doc.getPages().get(0);
        page.setBackgroundImage("data/Background.png");
        //Save pdf file.
        doc.saveToFile("output/imageWaterMark.pdf");
        doc.close();
    }
}
