import com.spire.pdf.PdfDocument;

public class deleteAnnotation {
    public static void main(String[] args) {
        // Create a new instance of the PdfDocument class
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the file "data/annotations.pdf"
        doc.loadFromFile("data/annotations.pdf");

        // Access the first page of the document using getPages().get(0)
        doc.getPages().get(0).getAnnotationsWidget().removeAt(0);

        // Save the modified document to a new file called "output/deleteAnnotation.pdf"
        doc.saveToFile("output/deleteAnnotation.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
