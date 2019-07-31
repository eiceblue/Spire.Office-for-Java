import com.spire.presentation.*;

public class mergeTableCell {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/mergeTableCell.pptx";
        String outputFile = "output/mergeTableCell_result.pptx";

        //Create a ppt document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        ITable table = null;
        for (Object shape : presentation.getSlides().get(0).getShapes()) {
            if (shape instanceof ITable) {
                table = (ITable) shape;
                //Merge the second row and third row of the first column
                table.mergeCells(table.get(0, 1), table.get(0, 2), false);
                table.mergeCells(table.get(3, 4), table.get(4, 4), true);
            }
        }

        //Save the file
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
