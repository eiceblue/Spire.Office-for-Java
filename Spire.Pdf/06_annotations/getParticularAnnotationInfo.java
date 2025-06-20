import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class getParticularAnnotationInfo {
    public static void main(String[] args) {
   // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the specified file path
        pdf.loadFromFile("data/annotations.pdf");

        // Get the collection of annotations from the first page of the PDF document
        PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

        // Create a StringBuilder to store the annotation information
        StringBuilder content = new StringBuilder();

        // Check if the first annotation is a text annotation
        if (annotations.get(0) instanceof  PdfTextAnnotationWidget)
        {
            // Cast the annotation to a PdfTextAnnotationWidget
            PdfTextAnnotationWidget textAnnotation = (PdfTextAnnotationWidget)annotations.get(0);

            // Append the text content of the annotation to the StringBuilder
            content.append("Annotation text: " + textAnnotation.getText()+"\n");

            // Append the modified date of the annotation to the StringBuilder
            content.append("Annotation ModifiedDate: " + textAnnotation.getModifiedDate().toString()+"\n");

            // Append the author of the annotation to the StringBuilder
            content.append("Annotation author: " + textAnnotation.getAuthor()+"\n");

            // Append the name of the annotation to the StringBuilder
            content.append("Annotation Name: " + textAnnotation.getName()+"\n");
        }

        // Print the annotation information
        System.out.println(content.toString());

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
