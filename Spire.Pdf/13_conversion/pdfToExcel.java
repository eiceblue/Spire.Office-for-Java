import com.spire.pdf.*;

public class pdfToExcel {
    public static void main(String[] args) {
        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the specified file path
        pdf.loadFromFile("data/toExcel.pdf");

        // Save the loaded document as an Excel file with the .xlsx extension
        pdf.saveToFile("output/pdfToExcel.xlsx", FileFormat.XLSX);

        // Close the document
        pdf.close();

        // Dispose of the resources used by the document
        pdf.dispose();
    }
}
