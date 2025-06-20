import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

import java.io.*;

public class getTextByStyleName {
    public static void main(String[] args) throws Exception {
        // Set the input file path
        String inputFile = "data/Template_N5.docx";

        // Set the output file path
        String outputFile = "output/GetTextByStyleName.txt";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(inputFile);

        // Initialize an empty string to store the extracted text
        String text = "";

        // Iterate through the sections of the document
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            // Get the current section
            Section section = doc.getSections().get(i);

            // Iterate through the paragraphs in the section
            for (int j = 0; j < section.getParagraphs().getCount(); j++) {
                // Get the current paragraph
                Paragraph para = section.getParagraphs().get(j);

                // Get the style name of the paragraph
                String name = para.getStyleName();

                // Check if the paragraph has the desired style (Heading1)
                if (para.getStyleName().equals("Heading1")) {
                    // Append the text of the paragraph to the result string
                    text += para.getText();
                }
            }
        }

        // Write the extracted text to a text file
        writeStringToTxt(text, outputFile);

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
