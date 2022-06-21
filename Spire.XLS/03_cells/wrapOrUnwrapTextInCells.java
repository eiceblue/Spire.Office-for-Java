import com.spire.xls.*;

import java.awt.*;

public class wrapOrUnwrapTextInCells {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Wrap the excel text;
        sheet.getRange().get("C1").setText("e-iceblue is in facebook and welcome to like us");
        sheet.getRange().get("C1").getStyle().setWrapText(true);
        sheet.getRange().get("D1").setText("e-iceblue is in twitter and welcome to follow us");
        sheet.getRange().get("D1").getStyle().setWrapText(true);

        //Unwrap the excel text;
        sheet.getRange().get("C2").setText("http://www.facebook.com/pages/e-iceblue/139657096082266");
        sheet.getRange().get("C2").getStyle().setWrapText(false);
        sheet.getRange().get("D2").setText("https://twitter.com/eiceblue");
        sheet.getRange().get("D2").getStyle().setWrapText(false);

        //Set the text color of Range["C1:D1"]
        sheet.getRange().get("C1:D1").getStyle().getFont().setSize(15);
        sheet.getRange().get("C1:D1").getStyle().getFont().setColor(Color.blue);
        //Set the text color of Range["C2:D2"]
        sheet.getRange().get("C2:D2").getStyle().getFont().setSize(15);
        sheet.getRange().get("C2:D2").getStyle().getFont().setColor(Color.green);

        String result = "output/wrapOrUnwrapTextInExcelCells_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
