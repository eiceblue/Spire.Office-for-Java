import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class protectChart {
    public static void main(String[] args) throws Exception {
        //Create a PowerPonit document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the first shape from slide and convert it as IChart.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Set the Boolean value of IChart.IsDataProtect as true.
        chart.isDataProtect(true);

        String result = "output/protectChart_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
