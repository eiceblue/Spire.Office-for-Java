import com.spire.pdf.*;

public class svgToPDF {
    public static void main(String[] args) {
        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Load the svg
        pdf.loadFromSvg("data/charthtml.svg");

        //Save the document
        pdf.saveToFile("output/svgToPDF.pdf", FileFormat.PDF);

        // Close the document
        pdf.close();

        // Dispose of the resources used by the document
        pdf.dispose();
    }

}
