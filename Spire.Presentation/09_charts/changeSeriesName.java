import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.collections.*;

public class changeSeriesName {
    public static void main(String[] args) throws Exception {
        String input = "data/chartSample2.pptx";
        String output = "output/changeSeriesName.pptx";

        //create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //get chart on the first slide
        IChart Chart =(IChart)ppt.getSlides().get(0).getShapes().get(0);

        //get the ranges of series label
        CellRanges cr = Chart.getSeries().getSeriesLabel();

        //change the value
        cr.get(0).setValue("Changed series name");

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
