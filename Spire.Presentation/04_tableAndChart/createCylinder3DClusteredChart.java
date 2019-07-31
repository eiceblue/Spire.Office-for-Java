import com.spire.pdf.tables.table.*;
import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.lang.Object;

public class createCylinder3DClusteredChart {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/createCylinder3DClusteredChart_result.pptx";
        String imageFile = "data/bg.png";

        //Create a presentation instance
        Presentation presentation = new Presentation();

        Rectangle2D.Double rect2 = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect2);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Insert chart
        Rectangle2D.Double rect = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 200, 85, 400, 400);
        IChart chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.CYLINDER_3_D_CLUSTERED, rect);

        //Add chart Title
        chart.getChartTitle().getTextProperties().setText("Report");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //Create a dataTable
        DataTable dataTable = new DataTable();
        dataTable.getColumns().add(new DataColumn("SalesPers", DataTypes.DATATABLE_STRING));
        dataTable.getColumns().add(new DataColumn("SaleAmt", DataTypes.DATATABLE_INT));
        dataTable.getColumns().add(new DataColumn("ComPct", DataTypes.DATATABLE_INT));
        dataTable.getColumns().add(new DataColumn("ComAmt", DataTypes.DATATABLE_INT));
        DataRow row1 = dataTable.newRow();
        row1.setString("SalesPers", "Joe");
        row1.setInt("SaleAmt", 660);
        row1.setInt("ComPct", 15);
        row1.setInt("ComAmt", 99);
        DataRow row2 = dataTable.newRow();
        row2.setString("SalesPers", "Robert");
        row2.setInt("SaleAmt", 660);
        row2.setInt("ComPct", 15);
        row2.setInt("ComAmt", 99);
        DataRow row3 = dataTable.newRow();
        row3.setString("SalesPers", "Michelle");
        row3.setInt("SaleAmt", 410);
        row3.setInt("ComPct", 12);
        row3.setInt("ComAmt", 49);
        DataRow row4 = dataTable.newRow();
        row4.setString("SalesPers", "Erich");
        row4.setInt("SaleAmt", 940);
        row4.setInt("ComPct", 12);
        row4.setInt("ComAmt", 49);
        DataRow row5 = dataTable.newRow();
        row5.setString("SalesPers", "Dafna");
        row5.setInt("SaleAmt", 940);
        row5.setInt("ComPct", 15);
        row5.setInt("ComAmt", 141);
        DataRow row6 = dataTable.newRow();
        row6.setString("SalesPers", "Rob");
        row6.setInt("SaleAmt", 900);
        row6.setInt("ComPct", 15);
        row6.setInt("ComAmt", 135);
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

        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "D1"));
        chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "A7"));
        chart.getSeries().get(0).setValues(chart.getChartData().get("B2", "B7"));
        chart.getSeries().get(0).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(0).getFill().getSolidColor().setKnownColor(KnownColors.BROWN);
        chart.getSeries().get(1).setValues(chart.getChartData().get("C2", "C7"));
        chart.getSeries().get(1).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(1).getFill().getSolidColor().setKnownColor(KnownColors.GREEN);
        chart.getSeries().get(2).setValues(chart.getChartData().get("D2", "D7"));
        chart.getSeries().get(2).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(2).getFill().getSolidColor().setKnownColor(KnownColors.ORANGE);

        //Set the 3D rotation
        chart.getRotationThreeD().setXDegree(10);
        chart.getRotationThreeD().setYDegree(10);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}