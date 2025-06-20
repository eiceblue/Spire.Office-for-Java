import com.spire.doc.*;

public class addAlternativeText {
    public static void main(String[] args) {
        String input = "data/tableSample.docx";
        String output = "output/addAlternativeText.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(input);

        // Get the first section of the document
        Section section = doc.getSections().get(0);

        // Get the first table in the section
        Table table = (Table) section.getTables().get(0);

        // Set the title of the table
        table.setTitle("Table 1");

        // Set the description of the table
        table.setTableDescription("Description Text");

        // Save the modified document to the output file
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
