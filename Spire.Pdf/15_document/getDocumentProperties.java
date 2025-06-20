import com.spire.pdf.*;
import java.io.*;

public class getDocumentProperties {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        // Retrieve the document information
        PdfDocumentInformation docInfo = doc.getDocumentInformation();

        // Create a StringBuilder to store the document properties
        StringBuilder builder = new StringBuilder();
        builder.append("Author: " + docInfo.getAuthor() + "\r\n");
        builder.append("Creation Date: " + docInfo.getCreationDate() + "\r\n");
        builder.append("Keywords: " + docInfo.getKeywords() + "\r\n");
        builder.append("Subject: " + docInfo.getSubject() + "\r\n");
        builder.append("Title: " + docInfo.getTitle());

        // Specify the output file path
        String output = "output/getDocumentProperties.txt";

        // Create a File object for the output file
        File file = new File(output);

        // If the file already exists, delete it
        if (file.exists()) {
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Create a FileWriter and BufferedWriter to write to the file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        // Write the document properties to the file
        bw.write(builder.toString());

        // Flush and close the BufferedWriter and FileWriter
        bw.flush();
        bw.close();
        fw.close();

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
