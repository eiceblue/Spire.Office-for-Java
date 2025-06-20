import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class readTableFromTextBox {
    public static void main(String[] args) throws IOException {
        // Create a new Document object
        Document doc = new Document();

        // Load a Word document into the Document object
        doc.loadFromFile("data/textBoxTable.docx");

        // Get the first TextBox object from the Document
        TextBox textbox = doc.getTextBoxes().get(0);

        // Get the first Table object from the TextBox
        Table table = textbox.getBody().getTables().get(0);

        // Set the output file path and name
        String output = "output/readTableFromTextBox.txt";
        File file = new File(output);

        // If the file does not exist, delete it. Otherwise, create a new file.
        if (!file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // Create a FileWriter object to write to the file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        // Loop through each row in the table
        for (int i = 0; i < table.getRows().getCount(); i++) {
            // Get the current row
            TableRow row = table.getRows().get(i);

            // Loop through each cell in the row
            for (int j = 0; j < row.getCells().getCount(); j++) {
                // Get the current cell
                TableCell cell = row.getCells().get(j);

                // Loop through each paragraph in the cell
                for (int k = 0; k < cell.getParagraphs().getCount(); k++) {
                    // Get the current paragraph
                    Paragraph paragraph = cell.getParagraphs().get(k);

                    // Write the text of the paragraph to the file, separated by a tab character
                    bw.write(paragraph.getText() + "\t");
                }
            }

            // Write a new line character to the file after each row
            bw.write("\r\n");
        }

        // Flush and close the BufferedWriter and FileWriter objects
        bw.flush();
        bw.close();
        fw.close();

        // Dispose of the Document object
        doc.dispose();
    }
}
