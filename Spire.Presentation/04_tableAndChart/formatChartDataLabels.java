import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.ChartDataLabel;
import com.spire.presentation.collections.ChartSeriesFormatCollection;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;

public class formatChartDataLabels {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/formatChartDataLabels.pptx";
        String outputFile = "output/formatChartDataLabels_result.pptx";

        //Create a ppt document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the chart
        IChart chart = (IChart) ((ppt.getSlides().get(0).getShapes().get(0) instanceof IChart) ? ppt.getSlides().get(0).getShapes().get(0) : null);
        //Get the chart series
        ChartSeriesFormatCollection sers = chart.getSeries();

        //Initialize four instances of series label and set parameters of each label
        ChartDataLabel cd1 = sers.get(0).getDataLabels().add();
        cd1.setPercentageVisible(true);
        cd1.getTextFrame().setText("Custom Datalabel1");
        cd1.getTextFrame().getTextRange().setFontHeight(12);
        cd1.getTextFrame().getTextRange().setLatinFont(new TextFont("Lucida Sans Unicode"));
        cd1.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        cd1.getTextFrame().getTextRange().getFill().getSolidColor().setColor(Color.green);

        ChartDataLabel cd2 = sers.get(0).getDataLabels().add();
        cd2.setPosition(ChartDataLabelPosition.INSIDE_END);
        cd2.setPercentageVisible(true);
        cd2.getTextFrame().setText("Custom Datalabel2");
        cd2.getTextFrame().getTextRange().setFontHeight(10);
        cd2.getTextFrame().getTextRange().setLatinFont(new TextFont("Arial"));
        cd2.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        cd2.getTextFrame().getTextRange().getFill().getSolidColor().setColor(Color.orange);

        ChartDataLabel cd3 = sers.get(0).getDataLabels().add();
        cd3.setPosition(ChartDataLabelPosition.CENTER);
        cd3.setPercentageVisible(true);
        cd3.getTextFrame().setText("Custom Datalabel3");
        cd3.getTextFrame().getTextRange().setFontHeight(14);
        cd3.getTextFrame().getTextRange().setLatinFont(new TextFont("Calibri"));
        cd3.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        cd3.getTextFrame().getTextRange().getFill().getSolidColor().setColor(Color.blue);

        ChartDataLabel cd4 = sers.get(0).getDataLabels().add();
        cd4.setPosition(ChartDataLabelPosition.INSIDE_BASE);
        cd4.setPercentageVisible(true);
        cd4.getTextFrame().setText("Custom Datalabel4");
        cd4.getTextFrame().getTextRange().setFontHeight(12);
        cd4.getTextFrame().getTextRange().setLatinFont(new TextFont("Lucida Sans Unicode"));
        cd4.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        cd4.getTextFrame().getTextRange().getFill().getSolidColor().setColor(Color.pink);

        //Save the file
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}

