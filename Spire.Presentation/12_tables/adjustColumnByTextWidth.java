import com.spire.presentation.*;

public class adjustColumnByTextWidth {
    public static void main(String[] args) throws Exception {
        //Load pptx file.
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/adjustColumn.pptx");

        //Get the table object.
        ITable table = (ITable) ppt.getSlides().get(0).getShapes().get(0);

        //Adjust the first column width of table by text width.
        table.getColumnsList().get(0).adjustColumnByTextWidth();

        //Save the result pptx file.
        ppt.saveToFile("output/adjustColumn_result.pptx", FileFormat.PPTX_2013);
    }
}
