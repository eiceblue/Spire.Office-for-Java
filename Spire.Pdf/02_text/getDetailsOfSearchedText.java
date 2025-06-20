import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import com.spire.pdf.texts.TextFindParameter;
import java.io.*;
import java.util.EnumSet;
import java.util.List;

public class getDetailsOfSearchedText {
    public static void main(String[] args) throws Exception{
        // Input file path
        String input = "data/SearchReplaceTemplate.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Read a PDF file
        doc.loadFromFile(input);

        // Output file path to save the extracted text
        String result = "output/getDetailsOfSearchedText.txt";

        // Create a new file object
        File file = new File(result);

        // Check if the file exists, and delete it if it does
        if (file.exists()) {
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Create a FileWriter object to write to the file
        FileWriter fw = new FileWriter(file, true);

        // Create a BufferedWriter object to write text efficiently
        BufferedWriter bw = new BufferedWriter(fw);

        // Get the first page of the PDF file
        PdfPageBase page = doc.getPages().get(0);

        // Initialize a variable to store search results
        List<PdfTextFragment> results = null;

        // Create text find options for searching
        PdfTextFindOptions findOptions = new PdfTextFindOptions();

        // Set search parameters
        findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

        // Create a PdfTextFinder object with the specified page
        PdfTextFinder textFinder = new PdfTextFinder(page);

        // Find the specified text using the given find options
        textFinder.find("Spire.PDF for Java", findOptions);

        // Iterate over each found text fragment
        for (PdfTextFragment find : results) {

            bw.write("==================================================================================");

            // Wrtie the matched text
            bw.write(" Match Text: " + find.getText());

            // Write the size of matched text
            bw.write(" Size: " + find.getSizes()[0]);

            // Write the position of matched text
            bw.write(" Position: " + find.getPositions()[0]);

            // Write the page index
            bw.write(" The index of page which is including the searched text : " + doc.getPages().indexOf(find.getPage()));

            // Write the line that contains the searched text
            bw.write(" The line that contains the searched text : " + find.getLineText());
        }

        // Flush and close the BufferedWriter and FileWriter
        bw.flush();
        bw.close();
        fw.close();

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
