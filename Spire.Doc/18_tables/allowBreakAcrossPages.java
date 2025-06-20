import com.spire.doc.*;

public class allowBreakAcrossPages {
    public static void main(String[] args) {

        // Create a new Document instance
        Document document = new Document();

        // Load the Word document from the specified path
        document.loadFromFile("data/AllowBreakAcrossPages.docx");

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Set the "break across pages" property to true for each row in the table
        for (int i = 0; i < table.getRows().getCount(); i++) {
            TableRow row = table.getRows().get(i);
            row.getRowFormat().isBreakAcrossPages(true);
        }

        // Specify the output file path
        String output = "output/AllowBreakAcrossPages_out.docx";

        // Save the modified document to the specified output file in the Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
