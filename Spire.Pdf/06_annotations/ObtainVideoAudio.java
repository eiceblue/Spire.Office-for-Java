import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.io.FileOutputStream;

public class ObtainVideoAudio {
    public static void main(String[] args) throws Exception{

        // Create a PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF file from disk
        pdf.loadFromFile("data\\ObtainVideoAudio.pdf");

        // Loop through each page in the PDF document
        for (int i = 0; i < pdf.getPages().getCount(); i++)
        {
            // Get the current page
            PdfPageBase page = pdf.getPages().get(i);

            // Get all annotations on the current page
            PdfAnnotationCollection annotations = page.getAnnotations();

            // Loop through each annotation on the page
            for (int j = 0; j < annotations.getCount(); j++) {

                // Cast the annotation to a rich media annotation widget
                PdfRichMediaAnnotationWidget MediaWidget = (PdfRichMediaAnnotationWidget)annotations.get(j);
                // Get the embedded media data (e.g., video, audio)
                byte[] data = MediaWidget.getRichMediaData();
                // Get the original file name of the embedded media
                String embedFileName = MediaWidget.getRichMediaName();

                // Save the embedded media data to a file
                FileOutputStream outputFileStream = new FileOutputStream(String.format(embedFileName));
                outputFileStream.write(data);
            }
        }
    }
}
