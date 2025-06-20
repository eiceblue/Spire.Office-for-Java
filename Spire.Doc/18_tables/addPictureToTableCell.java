import com.spire.doc.*;
import com.spire.doc.fields.*;

public class addPictureToTableCell {
    public static void main(String[] args) {
        String input1 = "data/tableTemplate.docx";
        String input2 = "data/spireDoc.png";
        String output = "output/addPictureToTableCell.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from input1 file
        doc.loadFromFile(input1);

        // Get the first table in the first section of the document
        Table table1 = doc.getSections().get(0).getTables().get(0);

        // Get the paragraph at row 1, cell 2 of table1 and append a picture from input2
        DocPicture picture = table1.getRows().get(1).getCells().get(2).getParagraphs().get(0).appendPicture(input2);

        // Set the width and height of the picture to 100 units
        picture.setWidth(100);
        picture.setHeight(100);

        // Save the modified document to the output file
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
