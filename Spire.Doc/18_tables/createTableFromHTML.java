import com.spire.doc.*;

public class createTableFromHTML {
    public static void main(String[] args) {
        // Define an HTML string representing a table
        String HTML = "<table border='2px'>" +
                "<tr>" +
                "<td>Row 1, Cell 1</td>" +
                "<td>Row 1, Cell 2</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Row 2, Cell 2</td>" +
                "<td>Row 2, Cell 2</td>" +
                "</tr>" +
                "</table>";

        // Create a new document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section and append the HTML content
        section.addParagraph().appendHTML(HTML);

        // Specify the output file path
        String output = "output/CreateTableFromHTML_out.docx";

        // Save the document to the specified file format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
