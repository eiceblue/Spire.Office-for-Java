import com.spire.pdf.*;

import java.io.*;

public class getPageLabel {
    public static void main(String[] args) throws IOException {
        // Specify the input and output file paths
        String inputFile = "data/PageLabel.pdf";
        String outputFile = "output/PageLabel_out.txt";

        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the input file
        pdf.loadFromFile(inputFile);

        // Create a StringBuilder to store the page labels
        StringBuilder sb = new StringBuilder();

        // Iterate through each page in the document
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            // Retrieve the page label of the current page
            String pageLabel = pdf.getPages().get(i).getPageLabel();

            // Append the page label information to the StringBuilder
            sb.append("The page label of page " + (i + 1) + " is \"" + pageLabel + "\"\r\n");
        }

        // Create a FileWriter to write the page labels to the output file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(sb.toString());
        writer.flush();
        writer.close();

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
