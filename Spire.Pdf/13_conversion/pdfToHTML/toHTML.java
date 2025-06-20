import com.spire.pdf.*;

public class toHTML {
    public static void main(String[] args) {
        // Specify the file paths for the input PDF file and the resulting HTML file.
        String inputFile = "data/JavaPDFSample_1.pdf";
        String outputFile = "output/toHTML_result.html";

        // Create a new instance of the PdfDocument class.
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the input file path.
        pdf.loadFromFile(inputFile);

        // Convert the PDF document to HTML format.
        pdf.saveToFile(outputFile, FileFormat.HTML);

        // Close the PDF document to release resources.
        pdf.close();

        // Dispose of the PDF document to free up system resources.
        pdf.dispose();
    }
}
