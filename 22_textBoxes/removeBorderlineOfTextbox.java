import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class removeBorderlineOfTextbox {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();
        workbook.setVersion(ExcelVersion.Version2013);

        //Create a new worksheet named "Remove Borderline" and add a chart to the worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("Remove Borderline");
        Chart chart = sheet.getCharts().add();

        //Create textbox1 in the chart and input text information.
        XlsTextBoxShape textbox1 = (XlsTextBoxShape)chart.getTextBoxes().addTextBox(50, 50, 100, 600);
        textbox1.setText("The solution with borderline");

        //Create textbox2 in the chart, input text information and remove borderline.
        XlsTextBoxShape textbox2 = (XlsTextBoxShape)chart.getTextBoxes().addTextBox(1000, 50, 100, 600);
        textbox2.setText("The solution without borderline");
        textbox2.getLine().setWeight(0);

        String result = "output/RemoveBorderlineOfTextbox_out.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
