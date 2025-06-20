import com.spire.doc.*;
import com.spire.doc.documents.*;

public class replaceWithTable {
    public static void main(String[] args) throws Exception {
        // Define the input file path for the document to be loaded
        String input = "data/bookmarks.docx";

        // Define the output file path for the document with replaced bookmark content
        String output = "output/replaceWithTable.docx";

        // Create a new Document instance
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create a new table instance with auto-fit behavior
        Table table = new Table(doc, true);

        // Define the data rows and columns for the table
        String[][] data = {new String[] {"Name", "Capital", "Continent", "Area", "Population"},
            new String[] {"Argentina", "Buenos Aires", "South America", "2777815", "32300003"},
            new String[] {"Bolivia", "La Paz", "South America", "1098575", "7300000"},
            new String[] {"Brazil", "Brasilia", "South America", "8511196", "150400000"},};
        table.resetCells(data.length, data[0].length);

        // Populate the table with data from the 2D array
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                // Add a new paragraph to each cell and append the corresponding data
                table.getRows().get(i).getCells().get(j).addParagraph().appendText(data[i][j]);
            }
        }

        // Create a BookmarksNavigator instance using the document
        BookmarksNavigator navigator = new BookmarksNavigator(doc);

        // Move the navigator to the bookmark named "Test2"
        navigator.moveToBookmark("Test2");

        // Create a TextBodyPart instance for the bookmark replacement content
        TextBodyPart part = new TextBodyPart(doc);
        part.getBodyItems().add(table);

        // Replace the bookmark content with the new table
        navigator.replaceBookmarkContent(part);

        // Save the modified document to the specified output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources
        doc.dispose();
    }
}
