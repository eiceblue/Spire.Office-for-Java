import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

public class convertObjectToImage {
    public static void main(String[] args) throws Exception {
        // Create a new document
        Document document = new Document();

        // Load the document from a file
        document.loadFromFile("data/ConvertObjectToImage.docx");

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the body of the section
        Body body = section.getBody();

        // Get the first paragraph of the body
        Paragraph paragraph = body.getParagraphs().get(0);

        // Convert the paragraph to an image
        BufferedImage image = ConvertParagraphToImage(paragraph);

        // Save the image to a file
        File file = new File("output/convertParagraphToImage.png");
        ImageIO.write(image, "png", file);

        // Get the first table of the body
        Table table = (Table) body.getTables().get(0);

        // Convert the table to an image
        image = ConvertTableToImage(table);

        // Save the image to a file
        file = new File("output/ConvertTableToImage.png");
        ImageIO.write(image, "png", file);

        // Get the first row of the table
        TableRow row = table.getRows().get(0);

        // Convert the row to an image
        image = ConvertTableRowToImage(row);

        // Save the image to a file
        file = new File("output/convertTableRowToImage.png");
        ImageIO.write(image, "png", file);

        // Get the first cell of the row
        TableCell cell = row.getCells().get(0);

        // Convert the cell to an image
        image = ConvertTableCellToImage(cell);

        // Save the image to a file
        file = new File("output/convertTableCellToImage.png");

        // Initialize a counter variable
        int i = 0;

        // Iterate over paragraphs in the section
        for (int j = 0; j < section.getParagraphs().getCount(); j++) {
            Paragraph p = section.getParagraphs().get(j);

            // Iterate over child objects in the paragraph
            for (int k = 0; k < p.getChildObjects().getCount(); k++) {
                DocumentObject obj = p.getChildObjects().get(k);

                // Check if the object is a shape
                if (obj.getDocumentObjectType().equals(DocumentObjectType.Shape)) {
                    // Convert the shape to an image
                    image = ConvertShapeToImage((ShapeObject) obj);

                    // Save the image to a file with a unique name
                    file = new File("output/convertShapeToImage-" + i + ".png");
                    ImageIO.write(image, "png", file);

                    // Increment the counter
                    i++;
                }
            }
        }

        // Save the final image to a file
        ImageIO.write(image, "png", file);

        // Dispose of the document resources
        document.dispose();
    }

    // Convert a paragraph to an image
    private static BufferedImage ConvertParagraphToImage(Paragraph obj) {
        // Create a new document
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a deep clone of the paragraph to the section
        section.getBody().getChildObjects().add(obj.deepClone());

        // Save the document as an image
        BufferedImage image = doc.saveToImages(0, ImageType.Bitmap);
        doc.close();

        // Return the image
        return image;
    }

    // Convert a table to an image
    private static BufferedImage ConvertTableToImage(Table obj) {
        // Create a new document
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a deep clone of the table to the section
        section.getBody().getChildObjects().add(obj.deepClone());

        // Save the document as an image
        BufferedImage image = doc.saveToImages(0, ImageType.Bitmap);
        doc.close();

        // Return the image
        return image;
    }
    // Convert a table row to an image
    private static BufferedImage ConvertTableRowToImage(TableRow obj) {
        // Create a new document
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a table to the section
        Table table = section.addTable();

        // Add a deep clone of the row to the table
        table.getRows().add(obj.deepClone());

        // Save the document as an image
        BufferedImage image = doc.saveToImages(0, ImageType.Bitmap);
        doc.close();

        // Return the image
        return image;
    }

    // Convert a table cell to an image
    private static BufferedImage ConvertTableCellToImage(TableCell obj) {
        // Create a new document
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a table to the section
        Table table = section.addTable();

        // Add a new row to the table and add a deep clone of the cell to it
        table.addRow().getCells().add(obj.deepClone());

        // Save the document as an image
        BufferedImage image = doc.saveToImages(0, ImageType.Bitmap);
        doc.close();

        // Return the image
        return image;
    }

    // Convert a shape object to an image
    private static BufferedImage ConvertShapeToImage(ShapeObject obj) {
        // Create a new document
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a paragraph to the section and add a deep clone of the shape object to it
        section.addParagraph().getChildObjects().add(obj.deepClone());

        // Save the document as an image
        BufferedImage image = doc.saveToImages(0, ImageType.Bitmap);
        doc.close();

        // Return the image
        return image;
    }
}
