import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;

public class createTable {
    public static void main(String[] args) {

        String outputFile="output/createTable.docx";

        //open a blank Word document as template
        Document document = new Document();

        Section section = document.addSection();
        addTable(section);

        //save to file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
    private static void addTable(Section section) {
        String[] header = {"Name", "Capital", "Continent", "Area", "Population"};
        String[][] data =
                {
                        new String[]{"Argentina", "Buenos Aires", "South America", "2777815", "32300003"},
                        new String[]{"Bolivia", "La Paz", "South America", "1098575", "7300000"},
                        new String[]{"Brazil", "Brasilia", "South America", "8511196", "150400000"},
                        new String[]{"Canada", "Ottawa", "North America", "9976147", "26500000"},
                        new String[]{"Chile", "Santiago", "South America", "756943", "13200000"},
                        new String[]{"Colombia", "Bagota", "South America", "1138907", "33000000"},
                        new String[]{"Cuba", "Havana", "North America", "114524", "10600000"},
                        new String[]{"Ecuador", "Quito", "South America", "455502", "10600000"},
                        new String[]{"El Salvador", "San Salvador", "North America", "20865", "5300000"},
                        new String[]{"Guyana", "Georgetown", "South America", "214969", "800000"},
                        new String[]{"Jamaica", "Kingston", "North America", "11424", "2500000"},
                        new String[]{"Mexico", "Mexico City", "North America", "1967180", "88600000"},
                        new String[]{"Nicaragua", "Managua", "North America", "139000", "3900000"},
                        new String[]{"Paraguay", "Asuncion", "South America", "406576", "4660000"},
                        new String[]{"Peru", "Lima", "South America", "1285215", "21600000"},
                        new String[]{"America", "Washington", "North America", "9363130", "249200000"},
                        new String[]{"Uruguay", "Montevideo", "South America", "176140", "3002000"},
                        new String[]{"Venezuela", "Caracas", "South America", "912047", "19700000"}
                };
        Table table = section.addTable(true);
        table.resetCells(data.length + 1, header.length);

        // ***************** First Row *************************
        TableRow row = table.getRows().get(0);
        row.isHeader(true);
        row.setHeight(20);
        row.setHeightType(TableRowHeightType.Exactly);
        row.getRowFormat().setBackColor(Color.gray);
        for (int i = 0; i < header.length; i++) {
            row.getCells().get(i).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
            Paragraph p = row.getCells().get(i).addParagraph();
            p.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            TextRange txtRange = p.appendText(header[i]);
            txtRange.getCharacterFormat().setBold(true);
        }

        for (int r = 0; r < data.length; r++) {
            TableRow dataRow = table.getRows().get(r + 1);
            dataRow.setHeight(25);
            dataRow.setHeightType(TableRowHeightType.Exactly);
            dataRow.getRowFormat().setBackColor(Color.white);
            for (int c = 0; c < data[r].length; c++) {
                dataRow.getCells().get(c).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                dataRow.getCells().get(c).addParagraph().appendText(data[r][c]);
            }
        }

        for (int j = 1; j < table.getRows().getCount(); j++) {
            if (j % 2 == 0) {
                TableRow row2 = table.getRows().get(j);
                for (int f = 0; f < row2.getCells().getCount(); f++) {
                    row2.getCells().get(f).getCellFormat().setBackColor(new Color(173, 216, 230)/*Color.getLightBlue()*/);
                }
            }
        }
    }
}
