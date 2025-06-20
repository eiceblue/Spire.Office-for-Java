import com.spire.pdf.*;
import java.util.*;

public class documentAndPagePieceDictionaries {
    public static void main(String[] args) throws Exception {
        // Input file path
        String input = "data/documentAndPagePieceDictionaries.pdf";

        // Create a new PdfDocument instance
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the input file
        pdf.loadFromFile(input);

        // Check if document piece info is null and set it if necessary
        if (pdf.getDocumentPieceInfo() == null) {
            pdf.setDocumentPieceInfo(new PdfPieceInfo());
        }

        // Add application data to document piece info
        pdf.getDocumentPieceInfo().addApplicationData("ice", "E-iceblue-ice");
        pdf.getDocumentPieceInfo().addApplicationData("blue", "E-iceblue-blue");
        pdf.getDocumentPieceInfo().addApplicationData("Blue", "E-iceblue-Blue");
        pdf.getDocumentPieceInfo().addApplicationData("Ice", "E-iceblue-Ice");

        // Remove application data from document piece info
        pdf.getDocumentPieceInfo().removeApplicationData("blue");

        // Check if page piece info is null and set it if necessary
        if (pdf.getPages().get(0).getPagePieceInfo() == null) {
            pdf.getPages().get(0).setPagePieceInfo(new PdfPieceInfo());
        }

        // Add application data to page piece info of the first page
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("ice", "E-iceblue-ice");
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("blue", "E-iceblue-blue");
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("Blue", "E-iceblue-Blue");
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("Ice", "E-iceblue-Ice");

        // Remove application data from page piece info of the first page
        pdf.getPages().get(0).getPagePieceInfo().removeApplicationData("Ice");

        // Get application data from document piece info and print the content
        HashMap<String, PdfApplicationData> fromDoc = pdf.getDocumentPieceInfo().getApplicationDatas();
        for (Map.Entry<String, PdfApplicationData> item : fromDoc.entrySet()) {
            PdfApplicationData data = item.getValue();
            String content = data.getPrivate().toString();
            System.out.println("Piece dictionaries from document: " + content);
        }

        // Get application data from page piece info of the first page and print the content
        HashMap<String, PdfApplicationData> fromPage = pdf.getPages().get(0).getPagePieceInfo().getApplicationDatas();
        for (Map.Entry<String, PdfApplicationData> item : fromPage.entrySet()) {
            PdfApplicationData data = item.getValue();
            String content = data.getPrivate().toString();
            System.out.println("Piece dictionaries from PDF page: " + content);
        }

        // Close the document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
