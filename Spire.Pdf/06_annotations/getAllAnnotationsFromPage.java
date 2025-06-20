import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class getAllAnnotationsFromPage {
    public static void main(String[] args) {
       // Create a new PDF document.
        PdfDocument pdf = new PdfDocument();

        // Load the file from disk.
        pdf.loadFromFile("data/annotations.pdf");

        // Get all annotations from the first page.
        PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

        // StringBuilder to store the extracted annotation information
        StringBuilder content = new StringBuilder();

        for (int i = 0; i < annotations.getCount(); i++) {
            //A text annotation will attach a popup annotation since they are father-son relationship.
            //The annotation information exists in the text annotation, so here we mask the blank popup annotation.
            if (annotations.get(i) instanceof PdfPopupAnnotationWidget)
                continue;
            content.append("Annotation information: "+"\n");
            content.append("Text: " + annotations.get(i).getText()+"\n");
            String modifiedDate = annotations.get(i).getModifiedDate().toString();
            content.append("ModifiedDate: " + modifiedDate+"\n");
        }

        // Print the extracted annotation information
        System.out.println(content.toString());

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
