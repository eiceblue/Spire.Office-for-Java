import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.*;

public class addSecondaryValueAxis {
    public static void main(String[] args) throws Exception {
        String input = "data/template_Ppt_2.pptx";
        String output = "output/addSecondaryValueAxis.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input);

        //get the chart from the PowerPoint file.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //add a secondary axis to display the value of Series 3.
        chart.getSeries().get(2).setUseSecondAxis(true);

        //set the grid line of secondary axis as invisible.
        chart.getSecondaryCategoryAxis().getMajorGridTextLines().setFillType(FillFormatType.NONE);

        //save the file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
