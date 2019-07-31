import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.Color;

public class pageSetup {
    public static void main(String[] args) throws Exception {
        String output = "output/pageSetup.doc";
        //create Word document.
        Document document = new Document();
        Section section = document.addSection();

        section.getPageSetup().setPageSize(PageSize.A4);
        section.getPageSetup().getMargins().setTop(72f);
        section.getPageSetup().getMargins().setBottom(72f);
        section.getPageSetup().getMargins().setLeft(89.85f);
        section.getPageSetup().getMargins().setRight(89.85f);

        //insert header and footer.
        insertHeaderAndFooter(section);

        addTable(section);

        //save doc file.
        document.saveToFile(output, FileFormat.Doc);
    }

    private static void addTable(Section section) {
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
        Table table = section.addTable(true);
        table.resetCells(data.length + 1, header.length);

        // ***************** First Row *************************
        TableRow row = table.getRows().get(0);
        row.isHeader(true);
        row.setHeight(20);
        row.setHeightType(TableRowHeightType.Exactly);
        row.getRowFormat().setBackColor(Color.GRAY);
        for (int i = 0; i < header.length; i++) {
            row.getCells().get(i).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
            Paragraph p = row.getCells().get(i).addParagraph();
            p.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            TextRange txtRange = p.appendText(header[i]);
            txtRange.getCharacterFormat().setBold(true);
        }

        for (int r = 0; r < data.length; r++) {
            TableRow dataRow = table.getRows().get(r + 1);
            dataRow.setHeight(20);
            dataRow.setHeightType(TableRowHeightType.Exactly);
            dataRow.getRowFormat().setBackColor(new Color(0,true));
            for (int c = 0; c < data[r].length; c++) {
                dataRow.getCells().get(c).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                dataRow.getCells().get(c).addParagraph().appendText(data[r][c]);
            }
        }
    }

    private static void insertHeaderAndFooter(Section section) throws Exception{
        HeaderFooter header = section.getHeadersFooters().getHeader();
        HeaderFooter footer = section.getHeadersFooters().getFooter();

        //insert picture and text to header.
        Paragraph headerParagraph = header.addParagraph();
        DocPicture headerPicture = headerParagraph.appendPicture("data/header.png");

        //header text.
        TextRange text = headerParagraph.appendText("Demo of Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(10);
        text.getCharacterFormat().setItalic(true);
        headerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        //border.
        headerParagraph.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
        headerParagraph.getFormat().getBorders().getBottom().setSpace(0.05F);


        //header picture layout - text wrapping.
        headerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);

        //header picture layout - position.
        headerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        headerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        headerPicture.setVerticalOrigin(VerticalOrigin.Page);
        headerPicture.setVerticalAlignment(ShapeVerticalAlignment.Top);

        //insert picture to footer.
        Paragraph footerParagraph = footer.addParagraph();
        DocPicture footerPicture = footerParagraph.appendPicture("data/footer.png");

        //footer picture layout.
        footerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);
        footerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        footerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        footerPicture.setVerticalOrigin(VerticalOrigin.Page);
        footerPicture.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

        //insert page number.
        footerParagraph.appendField("page number", FieldType.Field_Page);
        footerParagraph.appendText(" of ");
        footerParagraph.appendField("number of pages", FieldType.Field_Num_Pages);
        footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        //border.
        footerParagraph.getFormat().getBorders().getTop().setBorderType(BorderStyle.Single);
        footerParagraph.getFormat().getBorders().getTop().setSpace(0.05F);
    }
}
