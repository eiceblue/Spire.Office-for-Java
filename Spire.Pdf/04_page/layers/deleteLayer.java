import com.spire.pdf.*;

public class deleteLayer {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteLayer.pdf");
        PdfPageBase page = doc.getPages().get(0);
         //Remove a layer
        doc.getLayers().removeLayer("red line1");
        doc.saveToFile("output/deleteLayer.pdf");
        doc.close();
    }
}
