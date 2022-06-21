import com.spire.xls.*;
import com.spire.xls.core.*;

public class addTextBox {
    public static void main(String[] args)throws Exception {
        String input = "data/AddTextBox.xlsx";
        String output = "output/addTextBox_output.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first chart
        Chart chart = sheet.getCharts().get(0);

        //add a textbox
        ITextBoxLinkShape textbox = chart.getShapes().addTextBox();
        textbox.setWidth(1200);
        textbox.setHeight(320);
        textbox.setLeft(1000);
        textbox.setTop(480);
        textbox.setText("This is a textbox");

        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
