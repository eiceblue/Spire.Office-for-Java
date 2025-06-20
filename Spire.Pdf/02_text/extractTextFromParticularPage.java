import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.awt.geom.Rectangle2D;
import java.io.*;

public class extractTextFromParticularPage {
    public static void main(String[] args) throws Exception{
        //Create a Pdf file
        PdfDocument doc = new PdfDocument();

        //Load the file from disk
        doc.loadFromFile("data/PDFTemplate-Az.pdf");

        //Create a new txt file to save the extracted text
        String result = "output/extractTextFromParticularPage.txt";

        // Create a file
        File file=new File(result);

        // Determine if the file exists
        if(!file.exists()){
            // Delete the file
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Define the FileWriter
        FileWriter fw=new FileWriter(file,true);

        // Define the BufferedWriter
        BufferedWriter bw=new BufferedWriter(fw);

        // Get the first page
        PdfPageBase page = doc.getPages().get(0);

        // Define the options of extraction
        PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();

        // Extract text from page keeping white space
        extractOptions.setSimpleExtraction(false);

        // Define the extractor based on page
        PdfTextExtractor textExtractor = new PdfTextExtractor(page);

        // Extract text from page without keeping white space
        String text = textExtractor.extract(extractOptions);

        // Write content by BufferedWriter
        bw.write(text);


        // Flush the BufferedWriter
        bw.flush();

        // Close the BufferedWriter
        bw.close();

        // Close the FileWriter
        fw.close();

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
