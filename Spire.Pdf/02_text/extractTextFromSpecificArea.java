import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.awt.geom.Rectangle2D;
import java.io.*;


public class extractTextFromSpecificArea {
    public static void main(String[] args) throws Exception {
        // Specify the input path
        String input = "data/ExtractTextFromSpecificArea.pdf";

        // Create a Pdf file
        PdfDocument pdf = new PdfDocument();

        //Load the PDF file
        pdf.loadFromFile(input);

        // Specify the result path
        String result = "output/extractTextFromSpecificArea.txt";

        // Create a file
        File file=new File(result);

        // Determine if the file exists
        if(file.exists()){
            // If the file exists, delete it
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Define the FileWriter
        FileWriter fw=new FileWriter(file,true);

        // Define the BufferedWriter
        BufferedWriter bw=new BufferedWriter(fw);

        // Get the first page
        PdfPageBase page = pdf.getPages().get(0);

        // Define the options of extraction
        PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();

        // Set the area of extraction
        extractOptions.setExtractArea(new Rectangle2D.Float(80, 180, 500, 200));

        // Define the extractor based on page
        PdfTextExtractor textExtractor = new PdfTextExtractor(page);

        // Extract the text
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
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
