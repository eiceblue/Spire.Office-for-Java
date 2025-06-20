import com.spire.doc.*;
import java.io.*;

public class htmlStringToWord {
    public static void main(String[] args) throws IOException {
        // Path to the input HTML file
        String inputHtml = "data/InputHtml.txt";
        // Path to the output Word document file
        String outputFile = "output/htmlStringToWord.docx";

        // Create a new document
        Document document = new Document();
        // Add a section to the document
        Section sec = document.addSection();

        // Read the HTML text from the input file
        String htmlText = readTextFromFile(inputHtml);
        // Append the HTML text to the section as a paragraph
        sec.addParagraph().appendHTML(htmlText);

        // Save the document to the output file in DOCX format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose of the document resources
        document.dispose();
    }

    // Method to read text from a file
    public static String readTextFromFile(String fileName) throws IOException {
        // Create a string buffer to hold the file content
        StringBuffer sb = new StringBuffer();
        // Create a buffered reader to read the file
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        // Variable to store each line of content
        String content = null;
        // Read each line from the file
        while ((content = br.readLine()) != null) {
            // Append the line to the string buffer
            sb.append(content);
        }
        // Close the buffered reader
        br.close();
        // Return the file content as a string
        return sb.toString();
    }
}
