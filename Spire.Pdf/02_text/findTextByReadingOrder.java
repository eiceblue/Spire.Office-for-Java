import com.spire.pdf.*;
import com.spire.pdf.texts.*;

import java.io.*;
import java.util.List;

public class findTextByReadingOrder {
    public static void main(String[] args) throws IOException {
        // Create a new PdfDocument object to work with PDF files
        PdfDocument pdfDocument = new PdfDocument();

        // Load the PDF file from the specified path
        pdfDocument.loadFromFile("data\\ColumnarText.pdf");

        // Specify the result file name
        String result = "FindTextByReadingOrderResult.txt";

        // Create a new File object with the given result file name
        File file=new File(result);

        // Check if the file exists, and if so, delete it
        if(!file.exists()){
            file.delete();
        }

        // Create a new empty file
        file.createNewFile();

        // Create a FileWriter object 'fw' to write to the file in append mode
        FileWriter fw = new FileWriter(file, true);

        // Create a BufferedWriter object 'bw' to write text to the FileWriter
        BufferedWriter bw = new BufferedWriter(fw);

        // Get the first page of the loaded PDF document
        PdfPageBase pageBase = pdfDocument.getPages().get(0);

        // Create a PdfTextFinder object 'finder' with the first page for searching text
        PdfTextFinder finder = new PdfTextFinder(pageBase);

        // Set the search strategy as Simple
        finder.getOptions().setStrategy(PdfTextStrategy.Simple);

        // Find all occurrences of the text "knowledge" on the page
        List<PdfTextFragment> fragmentList = finder.find("knowledge");

        // Iterate over each found text fragment
        for (int i = 0; i < fragmentList.size(); i++) {
            PdfTextFragment fragment = fragmentList.get(i);

            // Write separator line to the text file
            bw.write("==================================================================================\r\n");

            // Write the found text to the text file
            bw.write(" Text: " + fragment.getText() + "\r\n");

            // Write the sizes of the text to the text file
            for (int j = 0; j < fragment.getSizes().length; j++) {
                bw.write(" Size: " + fragment.getSizes()[j] + "\r\n");
            }

            // Write the positions of the text to the text file
            for (int j = 0; j < fragment.getPositions().length; j++) {
                bw.write(" Position: " + fragment.getPositions()[j] + "\r\n");
            }

            // Write the line that contains the searched text to the text file
            bw.write(" The line that contains the searched text : " + fragment.getLineText() + "\r\n");

            // Write a new line to separate each fragment
            bw.write("\r\n");
        }

        // Flush and close the BufferedWriter and FileWriter
        bw.flush();
        bw.close();
        fw.close();

        // Dispose of system resources associated with the PdfDocument object
        pdfDocument.dispose();
    }
}
