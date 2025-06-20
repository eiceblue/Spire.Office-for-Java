import com.spire.presentation.*;

public class setColumnsCountOfTextFrame {
    public static void main(String[] args) throws Exception {
        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ColumnsCount.pptx");

        //Get the first shape in first slide and set column count of text
        IAutoShape shape1 = (IAutoShape)ppt.getSlides().get(0).getShapes().get(0);
        shape1.getTextFrame().setColumnCount(2);

        //Get the second shape in second slide and set column count of text
        IAutoShape shape2 = (IAutoShape)ppt.getSlides().get(1).getShapes().get(0);
        shape2.getTextFrame().setColumnCount(3);

        //Save the document
        ppt.saveToFile("output/Restult.pptx", FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
