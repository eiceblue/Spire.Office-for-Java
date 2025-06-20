import com.spire.presentation.*;

public class distributeRowsColumns {
    public static void main(String[] args) throws Exception {

        //Load a PowerPoint Document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/distributeRowsColumns.pptx");

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Get the first table
        ITable table = (ITable) slide.getShapes().get(0);

        //distribute rows
        table.distributeRows(1,3);

        //distribute columns
        table.distributeColumns(0,3);

        //Save the Document
        ppt.saveToFile("out/distributeRowsColumns_result.pptx", FileFormat.PPTX_2013);
    }
}
