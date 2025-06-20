import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.lists.*;

public class drawUnorderedList {
    public static void main(String[] args) throws Exception {
        // Generates a PDF document with an unordered list using no markers.
        PdfMarker_None();

        // Generates a PDF document with an unordered list using a custom image marker.
        PdfMarker_CustomImage();

        // Generates a PDF document with an unordered list using a custom template marker.
        PdfMarker_CustomTemplate();

        // Generates a PDF document with an unordered list using a custom string marker.
        PdfMarker_CustomString();
    }

     // This method generates a PDF document with an unordered list using no markers.
    public static void PdfMarker_None() {
        // Specify the output file path for the PDF document
        String outputFile = "output/PdfMarker_None.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfNewPage page = (PdfNewPage) doc.getPages().add();

        // Create a marker object with no specific style
        PdfMarker marker = new PdfMarker(PdfUnorderedMarkerStyle.None);

        // Define the content of the unordered list
        String listContent = "Data Structure\n"
                + "Algorithm\n"
                + "Computer Networks\n"
                + "Operating System\n"
                + "C Programming\n"
                + "Computer Organization and Architecture";

        // Create an unordered list with the provided content
        PdfUnorderedList list = new PdfUnorderedList(listContent);

        // Set the indentation of the list
        list.setIndent(2);

        // Set the text indentation of the list
        list.setTextIndent(4);

        // Set the marker for the list
        list.setMarker(marker);

        // Draw the unordered list on the page at coordinates (100, 100)
        list.draw(page, 100, 100);

        // Save the document to the specified output file
        doc.saveToFile(outputFile, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

    // This method generates a PDF document with an unordered list using a custom image marker.
    public static void PdfMarker_CustomImage() throws Exception {
        // Specify the output file path for the PDF document
        String outputFile = "output/PdfMarker_CustomImage.pdf";

        // Specify the input file path for the custom image marker
        String inputFile_Img = "data/sample.png";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfNewPage page = (PdfNewPage) doc.getPages().add();

        // Create a marker object with a custom image style
        PdfMarker marker = new PdfMarker(PdfUnorderedMarkerStyle.Custom_Image);

        // Set the custom image for the marker
        marker.setImage(PdfImage.fromFile(inputFile_Img));

        // Define the content of the unordered list
        String listContent = "Data Structure\n"
                + "Algorithm\n"
                + "Computer Networks\n"
                + "Operating System\n"
                + "C Programming\n"
                + "Computer Organization and Architecture";

        // Create an unordered list with the provided content
        PdfUnorderedList list = new PdfUnorderedList(listContent);

        // Set the indentation of the list
        list.setIndent(2);

        // Set the text indentation of the list
        list.setTextIndent(4);

        // Set the marker for the list
        list.setMarker(marker);

        // Draw the unordered list on the page at coordinates (100, 100)
        list.draw(page, 100, 100);

        // Save the document to the specified output file
        doc.saveToFile(outputFile, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose the document resources
        doc.dispose();
    }


    // This method generates a PDF document with an unordered list using a custom template marker.
    public static void PdfMarker_CustomTemplate() throws Exception {
        // Specify the output file path for the PDF document
        String outputFile = "output/PdfMarker_CustomTemplate.pdf";

        // Specify the input file path for the custom template marker
        String inputFile_Img = "data/sample.png";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfNewPage page = (PdfNewPage) doc.getPages().add();

        // Create a marker object with a custom template style
        PdfMarker marker = new PdfMarker(PdfUnorderedMarkerStyle.Custom_Template);

        // Create a template object for the marker
        PdfTemplate template = new PdfTemplate(210, 210);

        // Set the custom template for the marker
        marker.setTemplate(template);

        // Draw the custom image on the template
        template.getGraphics().drawImage(PdfImage.fromFile(inputFile_Img), 0, 0);

        // Define the content of the unordered list
        String listContent = "Data Structure\n"
                + "Algorithm\n"
                + "Computer Networks\n"
                + "Operating System\n"
                + "C Programming\n"
                + "Computer Organization and Architecture";

        // Create an unordered list with the provided content
        PdfUnorderedList list = new PdfUnorderedList(listContent);

        // Set the indentation of the list
        list.setIndent(2);

        // Set the text indentation of the list
        list.setTextIndent(4);

        // Set the marker for the list
        list.setMarker(marker);

        // Draw the unordered list on the page at coordinates (100, 100)
        list.draw(page, 100, 100);

        // Save the document to the specified output file
        doc.saveToFile(outputFile, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose the document resources
        doc.dispose();
    }


    // This method generates a PDF document with an unordered list using a custom string marker.
    public static void PdfMarker_CustomString() throws Exception {
        // Specify the output file path for the PDF document
        String outputFile = "output/PdfMarker_CustomString.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfNewPage page = (PdfNewPage) doc.getPages().add();

        // Create a marker object with a custom string style
        PdfMarker marker = new PdfMarker(PdfUnorderedMarkerStyle.Custom_String);

        // Set the custom string for the marker
        marker.setText("AAA");

        // Define the content of the unordered list
        String listContent = "Data Structure\n"
                + "Algorithm\n"
                + "Computer Networks\n"
                + "Operating System\n"
                + "C Programming\n"
                + "Computer Organization and Architecture";

        // Create an unordered list with the provided content
        PdfUnorderedList list = new PdfUnorderedList(listContent);

        // Set the indentation of the list
        list.setIndent(2);

        // Set the text indentation of the list
        list.setTextIndent(4);

        // Set the marker for the list
        list.setMarker(marker);

        // Draw the unordered list on the page at coordinates (100, 100)
        list.draw(page, 100, 100);

        // Save the document to the specified output file
        doc.saveToFile(outputFile, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose the document resources
        doc.dispose();
    }
}
