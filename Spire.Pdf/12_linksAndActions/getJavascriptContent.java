import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.actions.PdfJavaScriptAction;
import com.spire.pdf.annotations.*;
import java.io.*;
import java.util.List;

public class getJavascriptContent {

    public static void main(String[] args) throws IOException {
        // Create a new PDF document object
        PdfDocument pdf = new PdfDocument();

        // Load the PDF file containing JavaScript
        pdf.loadFromFile("data/DocumentJavaScript.pdf");

        // Access the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Initialize a StringBuilder to accumulate JavaScript code snippets
        StringBuilder sb = new StringBuilder();

        // Retrieve the list of JavaScript actions associated with the document
        List<PdfJavaScriptAction> javascriptActions = pdf.getNames().getJavaScripts();

        // Append the first JavaScript action's script to the StringBuilder and add a newline
        sb.append(javascriptActions.get(0).getScript()).append("\r\n");

        // Modify the second JavaScript action's script
        javascriptActions.get(0).setScript("new javaScript code");

        // Get the collection of annotations on the first page
        PdfAnnotationCollection annotationCollection = page.getAnnotations();

        // Iterate through each annotation
        for (int i = 0; i < annotationCollection.getCount(); i++) {
            // Get the current annotation
            PdfAnnotation pdfAnnotation = annotationCollection.get(i);

            // Check if the annotation is a link annotation widget (which might have a JavaScript action)
            if (pdfAnnotation instanceof PdfLinkAnnotationWidget) {
                // Cast the annotation to PdfLinkAnnotationWidget for more specific operations
                PdfLinkAnnotationWidget annotation = (PdfLinkAnnotationWidget) pdfAnnotation;

                // Append a label for the method name and a newline
                sb.append("Method name:" + "\r\n");

                // If the annotation has an action and it is a JavaScript action, append its script to the StringBuilder
                if (annotation.getAction() instanceof PdfJavaScriptAction) {
                    String script = ((PdfJavaScriptAction) annotation.getAction()).getScript();
                    sb.append(script).append("\r\n");
                }
            }
        }

        // Save the accumulated JavaScript content to a text file
        FileWriter fileWriter = new FileWriter("output/ExtractJavascriptContent.txt");
        // Write the StringBuilder content to the file
        fileWriter.write(sb.toString());
        // Flush the stream to ensure all data is written out
        fileWriter.flush();
        // Close the FileWriter to release system resources
        fileWriter.close();
        pdf.dispose();

    }
}
