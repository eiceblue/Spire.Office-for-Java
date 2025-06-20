import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.Color;

public class pageSetup {
    public static void main(String[] args) throws Exception {
        // Specify the output file path for the modified document
        String output = "output/result_pageSetup.doc";

        // Create a new Document object
        Document document = new Document();

        // Add a new section to the document
        Section section = document.addSection();

        // Set the page setup properties for the section
        section.getPageSetup().setPageSize(PageSize.A4);
        section.getPageSetup().getMargins().setTop(72f);
        section.getPageSetup().getMargins().setBottom(72f);
        section.getPageSetup().getMargins().setLeft(89.85f);
        section.getPageSetup().getMargins().setRight(89.85f);

        // Call methods to insert header and footer, and add a table to the section
        insertHeaderAndFooter(section);
        addTable(section);

        // Save the modified document to the specified file path in the Doc format
        document.saveToFile(output, FileFormat.Doc);

        // Dispose of the document object to release resources
        document.dispose();
    }

    // Method to add a table to the section
    private static void addTable(Section section) {
        // Define the header and data for the table
        String[] header = {"Name", "Capital", "Continent", "Area", "Population"};
        String[][] data =
                {
                        new String[]{"Argentina", "Buenos Aires", "South America", "2777815", "32300003"},
                        new String[]{"Bolivia", "La Paz", "South", "1098575", "7300000"},
                        new String[]{"Brazil", "Brasilia", "South", "8511196", "150400000"},
                        new String[]{"Canada", "Ottawa", "North", "9976147", "26500000"},
                        new String[]{"Chile", "Santiago", "South", "756943", "13200000"},
                        new String[]{"Colombia", "Bagota", "South", "1138907", "33000000"},
                        new String[]{"Cuba", "Havana", "North", "114524", "10600000"},
                        new String[]{"Ecuador", "Quito", "South", "455502", "10600000"},
                        new String[]{"El Salvador", "San Salvador", "North", "20865", "5300000"},
                        new String[]{"Guyana", "Georgetown", "South", "214969", "800000"},
                        new String[]{"Jamaica", "Kingston", "North", "11424", "2500000"},
                        new String[]{"Mexico", "Mexico City", "North", "1967180", "88600000"},
                        new String[]{"Nicaragua", "Managua", "North", "139000", "3900000"},
                        new String[]{"Paraguay", "Asuncion", "South", "406576", "4660000"},
                        new String[]{"Peru", "Lima", "South", "1285215", "21600000"},
                        new String[]{"United States", "Washington", "North", "9363130", "249200000"},
                        new String[]{"Uruguay", "Montevideo", "South", "176140", "3002000"},
                        new String[]{"Venezuela", "Caracas", "South", "912047", "19700000"}
                };

        // Create a new table with header row
        Table table = section.addTable(true);

        // Reset the number of cells in the table based on the data size
        table.resetCells(data.length + 1, header.length);

        // Customize the appearance of the header row
        TableRow headerRow = table.getRows().get(0);
        headerRow.isHeader(true);
        headerRow.setHeight(20);
        headerRow.setHeightType(TableRowHeightType.Exactly);
        headerRow.getRowFormat().setBackColor(Color.GRAY);

        // Add cells with formatted text to the header row
        for (int i = 0; i < header.length; i++) {
            // Customize cell formatting
            TableCell cell = headerRow.getCells().get(i);
            cell.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);

            // Add a paragraph to the cell and format its content
            Paragraph p = cell.addParagraph();
            p.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            TextRange txtRange = p.appendText(header[i]);
            txtRange.getCharacterFormat().setBold(true);
        }

        // Add data rows to the table
        for (int r = 0; r < data.length; r++) {
            TableRow dataRow = table.getRows().get(r + 1);
            dataRow.setHeight(20);
            dataRow.setHeightType(TableRowHeightType.Exactly);
            dataRow.getRowFormat().setBackColor(new Color(0, true));

            // Add cells with plain text to each data row
            for (int c = 0; c < data[r].length; c++) {
                TableCell cell = dataRow.getCells().get(c);
                cell.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                cell.addParagraph().appendText(data[r][c]);
            }
        }
    }

    // Method to insert header and footer into the section
    private static void insertHeaderAndFooter(Section section){
        // Access the header and footer of the section
        HeaderFooter header = section.getHeadersFooters().getHeader();
        HeaderFooter footer = section.getHeadersFooters().getFooter();

        // Add a paragraph to the header and insert a picture
        Paragraph headerParagraph = header.addParagraph();
        DocPicture headerPicture = headerParagraph.appendPicture("data/header.png");

        // Add text to the header paragraph with specific formatting
        TextRange text = headerParagraph.appendText("Demo of Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(10);
        text.getCharacterFormat().setItalic(true);

        // Set the horizontal alignment of the header paragraph
        headerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        // Set border properties for the bottom border of the header paragraph
        headerParagraph.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
        headerParagraph.getFormat().getBorders().getBottom().setSpace(0.05F);

        // Set text wrapping style for the header picture
        headerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);

        // Set the origin and alignment of the header picture
        headerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        headerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        headerPicture.setVerticalOrigin(VerticalOrigin.Page);
        headerPicture.setVerticalAlignment(ShapeVerticalAlignment.Top);

        // Add a paragraph to the footer and insert a picture
        Paragraph footerParagraph = footer.addParagraph();
        DocPicture footerPicture = footerParagraph.appendPicture("data/footer.png");

        // Set text wrapping style for the footer picture
        footerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);

        // Set the origin and alignment of the footer picture
        footerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        footerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        footerPicture.setVerticalOrigin(VerticalOrigin.Page);
        footerPicture.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

        // Add fields for page number and total number of pages in the footer
        footerParagraph.appendField("page number", FieldType.Field_Page);
        footerParagraph.appendText(" of ");
        footerParagraph.appendField("number of pages", FieldType.Field_Num_Pages);

        // Set the horizontal alignment of the footer paragraph
        footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        // Set border properties for the top border of the footer paragraph
        footerParagraph.getFormat().getBorders().getTop().setBorderType(BorderStyle.Single);
        footerParagraph.getFormat().getBorders().getTop().setSpace(0.05F);
    }
}
