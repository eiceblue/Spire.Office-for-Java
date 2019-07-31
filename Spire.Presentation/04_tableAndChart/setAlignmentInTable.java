import com.spire.presentation.*;

public class setAlignmentInTable {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/setAlignmentInTable.pptx";
        String outputFile = "output/setAlignmentInTable_result.pptx";

        //Create a ppt document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        ITable table = null;
        for (Object shape : presentation.getSlides().get(0).getShapes()) {
            if (shape instanceof ITable) {
                table = (ITable) shape;
                //Horizontal Alignment
                //Set the horizontal alignment for the cells in first column
                table.get(0, 1).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.LEFT);
                table.get(0, 2).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.CENTER);
                table.get(0, 3).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.RIGHT);
                table.get(0, 4).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.JUSTIFY);
                //Vertical Alignment
                //Set the vertical alignment for the cells in second column
                table.get(1, 1).setTextAnchorType(TextAnchorType.TOP);
                table.get(1, 2).setTextAnchorType(TextAnchorType.CENTER);
                table.get(1, 3).setTextAnchorType(TextAnchorType.BOTTOM);
                table.get(1, 4).setTextAnchorType(TextAnchorType.NONE);

                //Both orientations
                //Set the both horizontal and vertical alignment for the cells in the third column
                table.get(2, 1).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.LEFT);
                table.get(2, 1).setTextAnchorType(TextAnchorType.TOP);
                table.get(2, 2).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.RIGHT);
                table.get(2, 2).setTextAnchorType(TextAnchorType.CENTER);
                table.get(2, 3).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.JUSTIFY);
                table.get(2, 3).setTextAnchorType(TextAnchorType.BOTTOM);
                table.get(2, 4).getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.CENTER);
                table.get(2, 4).setTextAnchorType(TextAnchorType.TOP);
            }
        }
        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
