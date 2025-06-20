import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class extractTextFromTextBoxes {
    public static void main(String[] args) throws IOException {

        // Create a new Document object
        Document document = new Document();

        // Load the document from a file
        document.loadFromFile("data/ExtractTextFromTextBoxes.docx");

        //Set output path
        String output = "output/extractTextFromTextBoxes.txt";

        // If the document has any text boxes, extract the text from them and save it to a text file
        if (document.getTextBoxes().getCount() > 0) {

            // Create a new file for saving the extracted text
            File file = new File(output);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Loop through all sections in the document
            for (int s = 0; s < document.getSections().getCount(); s++) {
                Section section = document.getSections().get(s);

                // Loop through all paragraphs in the section
                for (int i = 0; i < section.getParagraphs().getCount(); i++) {
                    Paragraph p = section.getParagraphs().get(i);

                    // Loop through all child objects in the paragraph
                    for (int j = 0; j < p.getChildObjects().getCount(); j++) {
                        DocumentObject obj = p.getChildObjects().get(j);

                        // If the object is a text box, extract the text from it and save it to the text file
                        if (obj.getDocumentObjectType() == DocumentObjectType.Text_Box) {
                            TextBox textbox = (TextBox) obj;

                            // Loop through all child objects in the text box
                            for (int k = 0; k < textbox.getChildObjects().getCount(); k++) {
                                DocumentObject objt = textbox.getChildObjects().get(k);

                                // If the object is a paragraph, extract the text from it and save it to the text file
                                if (objt.getDocumentObjectType() == DocumentObjectType.Paragraph) {
                                    bw.write(((Paragraph) objt).getText());
                                }

                                // If the object is a table, extract the text from the cells in the table and save it to the text file
                                if (objt.getDocumentObjectType() == DocumentObjectType.Table) {
                                    Table table = (Table) objt;
                                    ExtractTextFromTables(table, bw);
                                }
                            }
                        }
                    }
                }
            }

            // Close the output file and flush the buffer
            bw.flush();
            bw.close();
            fw.close();
        }

        // Dispose the Document object
        document.dispose();
    }

    //Extract text from Table .
    static void ExtractTextFromTables(Table table, BufferedWriter sw) throws IOException {
        // Loop through all rows in the table
        for (int i = 0; i < table.getRows().getCount(); i++) {
            TableRow row = table.getRows().get(i);

            // Loop through all cells in the row
            for (int j = 0; j < row.getCells().getCount(); j++) {
                TableCell cell = row.getCells().get(i);

                // Loop through all paragraphs in the cell
                for (int k = 0; k < cell.getParagraphs().getCount(); k++) {
                    Paragraph paragraph = cell.getParagraphs().get(k);

                    // Write the text from the paragraph to the text file
                    sw.write(paragraph.getText());
                }
            }
        }
    }
}
