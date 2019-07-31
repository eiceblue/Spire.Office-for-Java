import com.spire.presentation.*;

public class setTableStyle {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/setTableStyle.pptx";
        String outputFile = "output/setTableStyle_result.pptx";

        //Create a ppt document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get tbe table
        ITable table = null;
        for (Object shape : ppt.getSlides().get(0).getShapes()) {
            if (shape instanceof ITable) {
                table = (ITable) shape;
                //Set the table style from TableStylePreset and apply it to selected table
                table.setStylePreset(TableStylePreset.MEDIUM_STYLE_1_ACCENT_2);
            }
        }
        //Save the file
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}

