import com.spire.pdf.*;
import com.spire.pdf.graphics.layer.*;

public class invisibleAllPdfLayers {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from a file
        doc.loadFromFile("data/layerSample.pdf");

        // Iterate through each layer in the document
        for (int i = 0; i < doc.getLayers().getCount(); i++) {
            // Set the visibility of the layer to 'Off' to make it invisible
            doc.getLayers().get(i).setVisibility(PdfVisibility.Off);
        }

        // Save the modified document with invisible layers
        String output = "output/invisibleAllPdfLayers.pdf";
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
