import com.spire.presentation.*;

public class removeRowsAndColumns {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/removeRowsAndColumns.pptx";
        String outputFile = "output/removeRowsAndColumns_result.pptx";

        //Create a ppt document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Get the table in PPT document
        ITable table = null;
        for (Object shape : presentation.getSlides().get(0).getShapes()) {
            if (shape instanceof ITable) {
                table = (ITable) shape;
                //Remove the second column
                table.getColumnsList().removeAt(1, false);
                //Remove the second row
                table.getTableRows().removeAt(1, false);
            }
        }
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
