import com.spire.pdf.PdfDocument;

public class flattenFormField {
    public static void main(String[] args) {
        // Specify the input PDF file path and output PDF file path
        String inputFile = "data/flattenFormField.pdf";
        String outputFile = "output/flattenFormField.pdf";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        // Flatten the form fields in the document
        doc.getForm().isFlatten(true);

        // Save the flattened document to the output file
        doc.saveToFile(outputFile);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
