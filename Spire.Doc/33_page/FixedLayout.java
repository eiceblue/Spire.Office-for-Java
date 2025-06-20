import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.pages.*;
import java.io.*;

public class FixedLayout {
    public static void main(String[] args) throws Exception {
        // Specify the input file path
        String inputFile = "data/Template_Docx_3.docx";
        String outputFile = "output/FixedLayout.txt";

        // Create a new instance of Document
        Document doc = new Document();

        // Load the document from the specified file
        doc.loadFromFile(inputFile);

        // Create a FixedLayoutDocument object using the loaded document
        FixedLayoutDocument layoutDoc = new FixedLayoutDocument(doc);

        // Create a StringBuilder to store the extracted text
        StringBuilder stringBuilder = new StringBuilder();

        // Get the first line on the first page and append it to the StringBuilder
        FixedLayoutLine line = layoutDoc.getPages().get(0).getColumns().get(0).getLines().get(0);
        stringBuilder.append("Line: " + line.getText() + "\r\n");

        // Retrieve the original paragraph associated with the line and append its text to the StringBuilder
        Paragraph para = line.getParagraph();
        stringBuilder.append("Paragraph text: " + para.getText() + "\r\n");

        // Retrieve all the text on the first page, including headers and footers, and append it to the StringBuilder
        String pageText = layoutDoc.getPages().get(0).getText();
        stringBuilder.append(pageText + "\r\n");

        // Iterate through each page in the document and print the number of lines on each page
        for (Object obj : layoutDoc.getPages()) {
            FixedLayoutPage page = (FixedLayoutPage) obj;
            LayoutCollection<LayoutElement> lines = page.getChildEntities(LayoutElementType.Line, true);
            stringBuilder.append("Page " + page.getPageIndex() + " has " + lines.getCount() + " lines." + "\r\n");
        }

        // Perform a reverse lookup of layout entities for the first paragraph and append them to the StringBuilder
        stringBuilder.append("\r\n");
        stringBuilder.append("The lines of the first paragraph:" + "\r\n");

        for (Object object : layoutDoc.getLayoutEntitiesOfNode(((Section) doc.getFirstChild()).getBody().getParagraphs().get(0))) {
            FixedLayoutLine paragraphLine = (FixedLayoutLine) object;

            stringBuilder.append(paragraphLine.getText().trim() + "\r\n");
            stringBuilder.append(paragraphLine.getRectangle().toString() + "\r\n");
            stringBuilder.append("");
        }

        // Write the extracted text to a file
        FileWriter fileWriter = new FileWriter(new File(outputFile));
        fileWriter.write(stringBuilder.toString());
        fileWriter.flush();
        fileWriter.close();

        // Dispose of the document resources
        doc.close();
        doc.dispose();
    }
}
