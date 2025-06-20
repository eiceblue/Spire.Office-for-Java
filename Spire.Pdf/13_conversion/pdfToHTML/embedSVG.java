import com.spire.pdf.*;

public class embedSVG {
    public static void main(String[] args) {
        // Specify the file paths for the input PDF file and the resulting HTML file.
        String file = "data/JavaPDFSample_1.pdf";
        String result = "output/ToHTMLWithEmbedingSVG_out.html";

        // Create a new instance of the PdfDocument class.
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file path.
        doc.loadFromFile(file);

        // Enable the option to embed SVG images when converting to HTML.
        doc.getConvertOptions().setPdfToHtmlOptions(true);

        // Convert the PDF document to HTML format with embedded SVG images,
        doc.saveToFile(result, FileFormat.HTML);

        // Close the PDF document to release resources.
        doc.close();

        // Dispose of the PDF document to free up system resources.
        doc.dispose();
    }
}
