import com.spire.pdf.*;
import com.spire.pdf.interchange.metadata.PdfXmpMetadata;
import java.io.*;

public class getXMPMetadata {
    public static void main(String[] args) throws IOException {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from a file
        doc.loadFromFile("getXMPMetadata.pdf");

        // Get the XMP metadata of the loaded PDF document
        PdfXmpMetadata xmpMetadata = doc.getMetadata();

        // Create a StringBuilder to store the XMP metadata information
        StringBuilder builder = new StringBuilder();

        // Define the namespace for Adobe PDF properties
        String nsPdf = "http://ns.adobe.com/pdf/1.3/";

        // Check if the Author property exists and append it to the StringBuilder
        if (xmpMetadata.existProperty(nsPdf, "Author"))
            builder.append("Author: " + xmpMetadata.getPropertyString(nsPdf, "Author") + "\r\n");

        // Check if the Title property exists and append it to the StringBuilder
        if (xmpMetadata.existProperty(nsPdf, "Title"))
            builder.append("Title: " + xmpMetadata.getPropertyString(nsPdf, "Title") + "\r\n");

        // Check if the Subject property exists and append it to the StringBuilder
        if (xmpMetadata.existProperty(nsPdf, "Subject"))
            builder.append("Subject: " + xmpMetadata.getPropertyString(nsPdf, "Subject") + "\r\n");

        // Check if the Producer property exists and append it to the StringBuilder
        if (xmpMetadata.existProperty(nsPdf, "Producer"))
            builder.append("Producer: " + xmpMetadata.getPropertyString(nsPdf, "Producer") + "\r\n");

        // Check if the Creator property exists and append it to the StringBuilder
        if (xmpMetadata.existProperty(nsPdf, "Creator"))
            builder.append("Creator: " + xmpMetadata.getPropertyString(nsPdf, "Creator") + "\r\n");

        // Check if the Keywords property exists and append it to the StringBuilder
        if (xmpMetadata.existProperty(nsPdf, "Keywords"))
            builder.append("Keywords: " + xmpMetadata.getPropertyString(nsPdf, "Keywords") + "\r\n");

        // Save the XMP metadata information to a text file
        String output = "output/getXMPMetadata.txt";
        File file = new File(output);

        // Delete the file if it already exists
        if (!file.exists()) {
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Create FileWriter, BufferedWriter, and FileReader objects for writing to the file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        // Write the content of the StringBuilder to the file
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
