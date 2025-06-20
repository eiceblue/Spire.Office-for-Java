import com.spire.pdf.*;
import java.io.*;

public class toHTMLStream {
    public static void main(String[] args) throws IOException {
        // Specify the file paths for the input PDF file and the resulting HTML file.
        String inputFile = "data/JavaPDFSample_1.pdf";
        String outputFile = "output/toHTML_out.html";

        // Create a new instance of the PdfDocument class.
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the input file path.
        pdf.loadFromFile(inputFile);

        // Create a File object for the output file.
        File outFile = new File(outputFile);

        // Create an OutputStream object for writing the HTML content.
        OutputStream outputStream = new FileOutputStream(outFile);

        // Convert the PDF document to HTML format and save it to the output stream.
        pdf.saveToStream(outputStream, FileFormat.HTML);

        // Close the output stream.
        outputStream.close();

        // Close the PDF document to release resources.
        pdf.close();

        // Dispose of the PDF document to free up system resources.
        pdf.dispose();
    }
}
