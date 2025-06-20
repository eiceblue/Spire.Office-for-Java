import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

public class addSVG {
    public static void main(String[] args) {
        // Specify the input SVG file path
        String inputSvg = "data/charthtml.svg";

        // Specify the output Word document file path
        String outputFile = "output/addSVG.docx";

        // Create a new Document object
        Document document = new Document();

        // Add a new Section to the document
        Section section = document.addSection();

        // Add a new Paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Append the picture (SVG) to the paragraph
        paragraph.appendPicture(inputSvg);

        // Save the document to the specified output file
        document.saveToFile(outputFile, FileFormat.Docx_2013);

        // Close the document
        document.dispose();
    }
}
