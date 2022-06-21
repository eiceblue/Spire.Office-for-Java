import java.awt.*;

import com.spire.xls.*;

public class applyStyleToWorksheet {
	public static void main(String[] args) {
		//Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a cell style
        CellStyle style = workbook.getStyles().addStyle("newStyle");
        style.setColor(Color.CYAN);
        style.getFont().setColor(Color.white);
        style.getFont().setSize(15); 
        style.getFont().isBold(true);

        //Apply the style to the first worksheet
        sheet.applyStyle(style);

        //Save the document
        String output = "output/applyStyleToWorksheet_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
	}
}
