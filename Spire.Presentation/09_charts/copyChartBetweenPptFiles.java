import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.geom.Rectangle2D;

public class copyChartBetweenPptFiles {
    public static void main(String[] args) throws Exception {
        String input1 = "data/template_Ppt_2.pptx";
        String input2 = "data/template_Ppt_1.pptx";
        String output = "output/copyChartBetweenPptFiles.pptx";

        //create a PPT document
        Presentation presentation1 = new Presentation();

        //load the file from disk which contains a chart.
        presentation1.loadFromFile(input1);

        //get the chart that is going to be copied.
        IChart chart =(IChart)presentation1.getSlides().get(0).getShapes().get(0);

        //load the second PowerPoint document.
        Presentation presentation2 = new Presentation();
        presentation2.loadFromFile(input2);

        //copy chart from the first document to the second document.
        presentation2.getSlides().append();
        presentation2.getSlides().get(1).getShapes().createChart(chart, new Rectangle2D.Double(100, 100, 500, 300), -1);

        //save the second PPT file.
        presentation2.saveToFile(output, FileFormat.PPTX_2013);
    }
}
