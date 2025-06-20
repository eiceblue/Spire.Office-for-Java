import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.io.*;

public class getLinkAnnotation {
    public static void main(String[] args) throws Exception {
        // Define input and output file paths
        String input = "data/linkAnnotation.pdf";
        String output = "output/getLinkAnnotation.txt";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Get the collection of annotations on the page
        PdfAnnotationCollection annotations = page.getAnnotationsWidget();

        // Verify whether the annotation collection is not null and contains annotations
        String result = null;
        if (annotations.getCount() > 0) {
            // Iterate through each annotation in the collection
            for (int i = 0; i < annotations.getCount(); i++) {
                PdfAnnotation pdfAnnotation = annotations.get(i);
                // Check if the annotation is a text web link annotation
                if (pdfAnnotation instanceof PdfTextWebLinkAnnotationWidget) {
                    // Cast the annotation to a text web link annotation
                    PdfTextWebLinkAnnotationWidget webLinkAnnotation = (PdfTextWebLinkAnnotationWidget) pdfAnnotation;
                    // Extract the URL and text from the web link annotation
                    String url = webLinkAnnotation.getUrl();
                    result = String.format("The URL of the link annotation is " + url +
                            "\r\nThe text of the link annotation is " + webLinkAnnotation.getText());
                }
            }
        }

        // Write the extracted results to the output file
        writeStringToTxt(result, output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
	
	
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        // Create a FileWriter object with the given text file name and enable append mode
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            // Write the content to the file
            fWriter.write(content);
        } catch (IOException ex) {
            // Print the stack trace if an I/O error occurs
            ex.printStackTrace();
        } finally {
            try {
                // Flush the writer and close the file
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                // Print the stack trace if an I/O error occurs while flushing or closing the file
                ex.printStackTrace();
            }
        }
    }
}
