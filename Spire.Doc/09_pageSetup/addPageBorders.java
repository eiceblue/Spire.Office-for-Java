import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class addPageBorders {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load a Word document from the specified file
        document.loadFromFile("data/Template_Docx_1.docx");

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Set the border type of the page to Double_Wave
        section.getPageSetup().getBorders().setBorderType(BorderStyle.Double_Wave);

        // Set the color of the page borders to light gray
        section.getPageSetup().getBorders().setColor(Color.lightGray);

        // Set the space (margin) on the left side of the page borders to 50
        section.getPageSetup().getBorders().getLeft().setSpace(50);

        // Set the space (margin) on the right side of the page borders to 50
        section.getPageSetup().getBorders().getRight().setSpace(50);

        // Specify the output file path
        String result = "output/result-addPageBorders.docx";

        // Save the modified document to the specified file in Docx format compatible with Word 2013
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose of the Document object to release resources
        document.dispose();
    }

}