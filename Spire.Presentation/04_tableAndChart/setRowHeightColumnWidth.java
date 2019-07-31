import com.spire.presentation.*;

public class setRowHeightColumnWidth {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/setRowHeightColumnWidth.pptx";
        String outputFile = "output/setRowHeightColumnWidth_result.pptx";

        //Create a ppt document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the table
        ITable table = null;
        for (Object shape : ppt.getSlides().get(0).getShapes()) {
            if (shape instanceof ITable) {
                table = (ITable) shape;
                //Set the height for the rows
                table.getTableRows().get(0).setHeight(100);
                table.getTableRows().get(1).setHeight(80);
                table.getTableRows().get(2).setHeight(60);
                table.getTableRows().get(3).setHeight(40);
                table.getTableRows().get(4).setHeight(20);
                //Set the column width
                table.getColumnsList().get(0).setWidth(60);
                table.getColumnsList().get(1).setWidth(80);
                table.getColumnsList().get(2).setWidth(120);
                table.getColumnsList().get(3).setWidth(140);
                table.getColumnsList().get(4).setWidth(160);
            }
        }
        //Save the file
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}

