import com.spire.presentation.*;

public class createTable {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/createTable.pptx";
        String outputFile = "output/createTable_result.pptx";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the document from disk
        presentation.loadFromFile(inputFile);
        Double[] widths = new Double[]{100d, 100d, 150d, 100d, 100d};
        Double[] heights = new Double[]{15d, 15d, 15d, 15d, 15d, 15d, 15d, 15d, 15d, 15d, 15d, 15d, 15d};

        //Add new table to PPT
        ITable table = presentation.getSlides().get(0).getShapes().appendTable((float) presentation.getSlideSize().getSize().getWidth() / 2 - 275, 90, widths, heights);
        String[][] dataStr = new String[][]
                {
                        {"Name", "Capital", "Continent", "Area", "Population"},
                        {"Venezuela", "Caracas", "South America", "912047", "19700000"},
                        {"Bolivia", "La Paz", "South America", "1098575", "7300000"},
                        {"Brazil", "Brasilia", "South America", "8511196", "150400000"},
                        {"Canada", "Ottawa", "North America", "9976147", "26500000"},
                        {"Chile", "Santiago", "South America", "756943", "13200000"},
                        {"Colombia", "Bagota", "South America", "1138907", "33000000"},
                        {"Cuba", "Havana", "North America", "114524", "10600000"},
                        {"Ecuador", "Quito", "South America", "455502", "10600000"},
                        {"Paraguay", "Asuncion", "South America", "406576", "4660000"},
                        {"Peru", "Lima", "South America", "1285215", "21600000"},
                        {"Jamaica", "Kingston", "North America", "11424", "2500000"},
                        {"Mexico", "Mexico City", "North America", "1967180", "88600000"}
                };
        //Add data to table
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                //Fill the table with data
                table.get(j, i).getTextFrame().setText(dataStr[i][j]);

                //Set the Font
                table.get(j, i).getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setLatinFont(new TextFont("Arial Narrow"));
            }
        }
        //Set the alignment of the first row to Center
        for (int i = 0; i < 5; i++) {
            table.get(i, 0).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.CENTER);
        }
        //Set the style of table
        table.setStylePreset(TableStylePreset.LIGHT_STYLE_3_ACCENT_1);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}