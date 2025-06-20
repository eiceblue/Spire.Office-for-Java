import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class image {
    public static void main(String[] args) throws Exception {
        String output = "output/image.docx";

        // Create a new Document object
        Document document = new Document();

        // Add a new Section to the document
        Section section = document.addSection();

        // Call the insertImage method to insert an image in the section
        insertImage(section);

        // Save the document to the specified output file
        document.saveToFile(output, FileFormat.Docx);

        // Clean up resources associated with the document
        document.dispose();
    }

    // Method to insert an image into a section
    private static void insertImage(Section section) throws Exception {
        // Specify the input image file path
        String input = "data/spireDoc.png";

        // Add a new Paragraph to the section and set horizontal alignment to Left
        Paragraph paragraph = section.addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);

        // Append the picture to the paragraph with specified width and height
        DocPicture picture = paragraph.appendPicture(input);
        picture.setWidth(100f);
        picture.setHeight(100f);

        // Add a new Paragraph to the section with line spacing and set font properties for the text range
        paragraph = section.addParagraph();
        paragraph.getFormat().setLineSpacing(20f);
        TextRange tr = paragraph.appendText("Spire.Doc for Java is a professional Word Java library specially designed for developers to create, read, write, convert and print Word document files from any Java platform with fast and high quality performance. ");
        tr.getCharacterFormat().setFontName("Arial");
        tr.getCharacterFormat().setFontSize(14);

        // Add an empty paragraph to the section for spacing
        section.addParagraph();

        // Add a new Paragraph to the section with line spacing and set font properties for the text range
        paragraph = section.addParagraph();
        paragraph.getFormat().setLineSpacing(20f);
        tr = paragraph.appendText("As an independent Word Java component, Spire.Doc for Java doesn't need Microsoft Word to be installed on the machine. However, it can incorporate Microsoft Word document creation capabilities into any developers' Java applications.");
        tr.getCharacterFormat().setFontName("Arial");
        tr.getCharacterFormat().setFontSize(14);
    }
}
