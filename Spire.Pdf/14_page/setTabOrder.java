import com.spire.pdf.*;

public class setTabOrder {
    public static void main(String[] args) {
        // Specify the input file path
        String inputFile = "data/setTabOrder.pdf";

        // Specify the output file path
        String outputFile = "output/setTabOrder_out.pdf";

        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the specified input file
        pdf.loadFromFile(inputFile);

        // Disable incremental updates for the PDF document to ensure the tab order is properly set
        pdf.getFileInfo().setIncrementalUpdate(false);

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Set the tab order of the page to structure-based
        page.setTabOrder(TabOrder.Structure);

        // Save the modified PDF document to the specified output file location
        pdf.saveToFile(outputFile);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
