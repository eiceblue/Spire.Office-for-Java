import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.geom.Rectangle2D;

public class copyChartWithinOnePPT {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the chart that will be copied.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Copy the chart from the first slide to the specified location of the second slide within the same document.
        ISlide slide1 = presentation.getSlides().append();
        Rectangle2D.Double rect1 = new Rectangle2D.Double(100, 100, 500, 300);
        slide1.getShapes().createChart(chart, rect1, 0);

        String result = "output/copyChartWithinAPptFile_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);

    }
}
