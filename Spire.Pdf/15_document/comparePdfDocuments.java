import com.spire.pdf.PdfDocument;
import com.spire.pdf.comparison.PdfComparer;

public class comparePdfDocuments {
    public static void main(String[] args) {
        // Create a new PdfDocument object 'pdf1' to work with the first PDF file
        PdfDocument pdf1 = new PdfDocument();

        // Load the first PDF file from the specified path
        pdf1.loadFromFile("data\\ComparePdfDocument_1.pdf");

        // Create a new PdfDocument object 'pdf2' to work with the second PDF file
        PdfDocument pdf2 = new PdfDocument();

        // Load the second PDF file from the specified path
        pdf2.loadFromFile("data\\ComparePdfDocument_2.pdf");

        // Create a PdfComparer object 'compare' with 'pdf1' and 'pdf2' as parameters for comparison
        PdfComparer compare = new PdfComparer(pdf1, pdf2);

        // Set the page ranges to be compared using the options of the comparer
        compare.getOptions().setPageRanges(0, pdf1.getPages().getCount() - 1, 0, pdf2.getPages().getCount() - 1);

        // Compare the PDF documents and save the result as "result.pdf"
        compare.compare("result.pdf");

        // Dispose of system resources associated with 'pdf1'
        pdf1.dispose();

        // Dispose of system resources associated with 'pdf2'
        pdf2.dispose();
    }
}
