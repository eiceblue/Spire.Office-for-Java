import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;
import com.spire.presentation.drawing.*;
import java.awt.*;
import java.awt.geom.*;

public class create100PercentStackedBarChart {
    public static void main(String[] args) throws Exception {
        String output = "output/create100PercentStackedBarChart.pptx";

        //create a PowerPoint document.
        Presentation presentation = new Presentation();

        //add a "Bar100PercentStacked" chart to the first slide.
        presentation.getSlideSize().setType(SlideSizeType.SCREEN_16_X_9);
        Dimension2D slidesize = presentation.getSlideSize().getSize();

        //get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //append a chart.
        Rectangle2D rect = new Rectangle2D.Double(20, 20, slidesize.getWidth() - 40, slidesize.getHeight()- 40);
        IChart chart = slide.getShapes().appendChart(ChartType.BAR_100_PERCENT_STACKED, rect);

        //write data to the chart data.
        String[] columnlabels = { "Series 1", "Series 2", "Series 3" };

        //insert the column labels.
        for (int c = 0; c < columnlabels.length; ++c)
        {
            chart.getChartData().get(0, c + 1).setText(columnlabels[ c ]);
        }
        //insert the row labels.
        String[] rowlabels = { "Category 1", "Category 2", "Category 3" };
        for (int r = 0; r < rowlabels.length; ++r)
        {
            chart.getChartData().get( r + 1, 0).setText(rowlabels[ r ]);
        }

        double[][] values = { { 20.83233, 10.34323, -10.354667 }, { 10.23456, -12.23456, 23.34456 }, { 12.34345, -23.34343, -13.23232 } };

        //insert the values.
        double value = 0.0;
        for (int r = 0; r < rowlabels.length; ++r)
        {
            for (int c = 0; c < columnlabels.length; ++c)
            {
                //value = Math.round(values[r][c], 2);
                value = Math.round(values[r][c]);
                chart.getChartData().get((r + 1), (c + 1)).setValue( value);
            }
        }
        chart.getSeries().setSeriesLabel(chart.getChartData().get(0, 1, 0, columnlabels.length));
        chart.getCategories().setCategoryLabels(chart.getChartData().get(1, 0, rowlabels.length, 0));

        //set the position of category axis.
        chart.getPrimaryCategoryAxis().setPosition(AxisPositionType.LEFT);
        chart.getSecondaryCategoryAxis().setPosition(AxisPositionType.LEFT);
        chart.getPrimaryCategoryAxis().setTickLabelPosition(TickLabelPositionType.TICK_LABEL_POSITION_LOW);

        //set the data, font and format for the series of each column.
        for (int c = 0; c < columnlabels.length; ++c)
        {
            chart.getSeries().get(c).setValues(chart.getChartData().get(1, c + 1, rowlabels.length, c + 1));
            chart.getSeries().get(c).getFill().setFillType(FillFormatType.SOLID);
            chart.getSeries().get(c).setInvertIfNegative(false);
            for (int r = 0; r < rowlabels.length; ++r)
            {
                ChartDataLabel label = chart.getSeries().get(c).getDataLabels().add();
                label.setLabelValueVisible(true);
                chart.getSeries().get(c).getDataLabels().get(r).hasDataSource(false);
                chart.getSeries().get(c).getDataLabels().get(r).setNumberFormat("0#\\%");
                chart.getSeries().get(c).getDataLabels().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight( 12);
            }
        }
        //set the color of the Series.
        chart.getSeries().get(0).getFill().getSolidColor().setColor( Color.YELLOW);
        chart.getSeries().get(0).getFill().getSolidColor().setColor(Color.RED);
        chart.getSeries().get(0).getFill().getSolidColor().setColor(Color.GREEN);
        TextFont font = new TextFont("Tw Cen MT");

        //set the font and size for chartlegend.
        for (int k = 0; k < chart.getChartLegend().getEntryTextProperties().length; k++)
        {
            TextCharacterProperties[] textProperties = chart.getChartLegend().getEntryTextProperties();
            textProperties[k].setLatinFont(font);
            textProperties[k].setFontHeight(20);
        }
        //save to file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
