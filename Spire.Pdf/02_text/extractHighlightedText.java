import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.texts.*;
import java.io.*;


public class extractHighlightedText {
    public static void main(String[] args) throws IOException {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Load a pdf file
        doc.loadFromFile("data/ExtractHighlightedText.pdf");

        // Create a new TXT File to save extracted text
        String result = "output/extractHighlightedText_out.txt";

        // Create a file
        File file = new File(result);

        // Determine if the file exists
        if (file.exists()) {
            // Delete the file
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Define the FileWriter
        FileWriter fw = new FileWriter(file, true);

        // Define the BufferedWriter
        BufferedWriter bw = new BufferedWriter(fw);

        // Write the text
        bw.write("Extracted highlighted text:");

        // Get the first page
        PdfPageBase page = doc.getPages().get(0);

        // Iterate the annotations on page
        for (int i = 0; i < page.getAnnotationsWidget().getCount(); i++) {

            // Determine if the type of annotation
            if (page.getAnnotationsWidget().get(i) instanceof PdfTextMarkupAnnotationWidget) {
                // Get the annotation via index
                PdfTextMarkupAnnotationWidget textMarkupAnnotation = (PdfTextMarkupAnnotationWidget) page.getAnnotationsWidget().get(i);

                // Define the options of extraction
                PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();

                // Set the area of extraction
                extractOptions.setExtractArea(textMarkupAnnotation.getBounds());

                // Define the extractor based on page
                PdfTextExtractor textExtractor = new PdfTextExtractor(page);

                // Write content by BufferedWriter
                bw.write(textExtractor.extract(extractOptions));

                // Get the highlighted color
                PdfRGBColor color = textMarkupAnnotation.getColor();

                // Write content by BufferedWriter
                bw.write("Color=" + (color.getR() & 0XFF) + "," + (color.getG() & 0XFF) + "," + (color.getB() & 0XFF) + "\n");
            }
        }
        // Flush the BufferedWriter
        bw.flush();

        // Close the BufferedWriter
        bw.close();

        // Close the FileWriter
        fw.close();

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
