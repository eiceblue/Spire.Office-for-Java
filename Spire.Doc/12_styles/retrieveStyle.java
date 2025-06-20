import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

import java.io.*;

public class retrieveStyle {
    public static void main(String[] args) throws Exception {
        // Set the input and output file paths
        String inputFile = "data/Styles.docx";
        String outputFile = "output/retrieveStyle.txt";

        // Create a new Document object and load the input file
        Document doc = new Document();
        doc.loadFromFile(inputFile);

        // Initialize a variable to store style names
        String StyleName = "";

        // Iterate through sections and paragraphs to retrieve style names
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            Section section = doc.getSections().get(i);
            for (int j = 0; j < section.getParagraphs().getCount(); j++) {
                Paragraph para = section.getParagraphs().get(j);
                StyleName += para.getStyleName();
            }
        }

        // Write the style names to a text file
        writeStringToTxt(StyleName, outputFile);

        // Dispose of the document to release resources
        doc.dispose();
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        // Create a FileWriter object to write to the text file
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            // Write the content to the text file
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // Flush and close the FileWriter
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
