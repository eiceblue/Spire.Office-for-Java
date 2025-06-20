import com.spire.pdf.*;
import com.spire.pdf.graphics.layer.*;

public class invisibleParticularPdfLayers {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from a file
        doc.loadFromFile("data/layerSample.pdf");

        // Set the visibility of the first layer to 'Off' to make it invisible
        doc.getLayers().get(0).setVisibility(PdfVisibility.Off);

        // Iterate through each layer in the document
        for (int i = 0; i < doc.getLayers().getCount(); i++) {
            // Check if the layer name is "blue line1"
            if ("blue line1".equals(doc.getLayers().get(i).getName())) {
                // Set the visibility of the layer to 'Off' to make it invisible
                doc.getLayers().get(i).setVisibility(PdfVisibility.Off);
            }
        }

        // Save the modified document with certain layers made invisible
        String output = "output/invisibleParticularPdfLayers.pdf";
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
