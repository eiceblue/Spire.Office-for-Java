import com.spire.pdf.*;
import com.spire.pdf.actions.*;

public class setExpiryDate {
    public static void main(String[] args) {
        // Create a PdfDocument object to load the original document
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the file "data/pdfTemplate-Az.pdf"
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        // Define JavaScript code to be executed when the document is opened
        String javaScript = "var rightNow = new Date();"
                + "var endDate = new Date('October 20, 2015 23:59:59');"
                + "if (rightNow.getTime() > endDate)"
                + "    app.alert('This document has expired, please contact us for a new one.', 1);"
                + "this.closeDoc();";

        // Create a PdfJavaScriptAction object with the defined JavaScript code
        PdfJavaScriptAction js = new PdfJavaScriptAction(javaScript);

        // Set the PdfJavaScriptAction as the action to be performed after the document is opened
        doc.setAfterOpenAction(js);

        // Specify the output file path for the modified PDF document
        String output = "output/setExpiryDate.pdf";

        // Save the modified document to a new PDF file
        doc.saveToFile(output);

        // Close and dispose of system resources associated with the document
        doc.close();
        doc.dispose();
    }
}
