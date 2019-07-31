import com.spire.pdf.tables.table.*;
import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.lang.Object;
public class createCombinationChart {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/createCombinationChart_result.pptx";
        String imageFile = "data/bg.png";

        //Create a presentation instance
        Presentation presentation = new Presentation();

        //Set background image
        Rectangle2D.Double rect2 = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect2);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Insert a column clustered chart
        Rectangle2D.Double rect = new   Rectangle2D.Double(100, 100, 550, 320);
        IChart chart = null;
        chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.COLUMN_CLUSTERED, rect);

        //Set chart title
        chart.getChartTitle().getTextProperties().setText("Monthly Sales Report");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //Create a dataTable
        DataTable dataTable = new DataTable();
        dataTable.getColumns().add(new DataColumn("Month", DataTypes.DATATABLE_STRING));
        dataTable.getColumns().add(new DataColumn("Sales", DataTypes.DATATABLE_INT));
        dataTable.getColumns().add(new DataColumn("Growth rate", DataTypes.DATATABLE_DOUBLE));
        DataRow row1 = dataTable.newRow();
        row1.setString("Month", "January");
        row1.setInt("Sales", 200);
        row1.setDouble("Growth rate", 0.6);
        DataRow row2 = dataTable.newRow();
        row2.setString("Month", "February");
        row2.setInt("Sales", 250);
        row2.setDouble("Growth rate", 0.8);
        DataRow row3 = dataTable.newRow();
        row3.setString("Month", "March");
        row3.setInt("Sales", 300);
        row3.setDouble("Growth rate", 0.6);
        DataRow row4 = dataTable.newRow();
        row4.setString("Month", "April");
        row4.setInt("Sales", 150);
        row4.setDouble("Growth rate", 0.2);
        DataRow row5 = dataTable.newRow();
        row5.setString("Month", "May");
        row5.setInt("Sales", 200);
        row5.setDouble("Growth rate", 0.5);
        DataRow row6 = dataTable.newRow();
        row6.setString("Month", "June");
        row6.setInt("Sales", 400);
        row6.setDouble("Growth rate", 0.9);
        dataTable.getRows().add(row1);
        dataTable.getRows().add(row2);
        dataTable.getRows().add(row3);
        dataTable.getRows().add(row4);
        dataTable.getRows().add(row5);
        dataTable.getRows().add(row6);

        //Import data from dataTable to chart data
        for (int c = 0; c < dataTable.getColumns().size(); c++) {
            chart.getChartData().get(0, c).setText(dataTable.getColumns().get(c).getColumnName());
        }
        for (int r = 0; r < dataTable.getRows().size(); r++) {
            Object[] datas = dataTable.getRows().get(r).getArrayList();
            for (int c = 0; c < datas.length; c++) {
                chart.getChartData().get(r + 1, c).setValue(datas[c]);

            }
        }

        //Set series labels
        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "C1"));

        //Set categories labels
        chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "A7"));

        //Assign data to series values
        chart.getSeries().get(0).setValues(chart.getChartData().get("B2", "B7"));
        chart.getSeries().get(1).setValues(chart.getChartData().get("C2", "C7"));

        //Change the chart type of series 2 to line with markers
        chart.getSeries().get(1).setType(ChartType.LINE_MARKERS);

        //Plot data of series 2 on the secondary axis
        chart.getSeries().get(1).setUseSecondAxis(true);

        //Set the number format as percentage
        chart.getSecondaryValueAxis().setNumberFormat("0%");

        //Hide grid links of secondary axis
        chart.getSecondaryValueAxis().getMajorGridTextLines().setFillType(FillFormatType.NONE);

        //Set overlap
        chart.setOverLap(-50);

        //Set gap width
        chart.setGapDepth(200);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
