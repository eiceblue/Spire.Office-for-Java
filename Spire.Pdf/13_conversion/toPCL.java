import com.spire.pdf.*;

public class toPCL {
    public static void main(String[] args) {
        // Specify the path of the input and output PDF file
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toPCL_out.pcl";

        // Load the pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        // Convert Pdf to pcl file
        doc.saveToFile(output, FileFormat.PCL);

        // Close the document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
}
