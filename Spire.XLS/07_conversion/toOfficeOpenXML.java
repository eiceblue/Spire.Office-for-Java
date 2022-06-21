import com.spire.xls.*;

public class toOfficeOpenXML {
    public static void main(String[] args) {
        String outputFile = "output/toOfficeOpenXML_out.xml";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set text for cell
        sheet.getCellRange("A1").setText("Hello World");
        //Set color for cell
        sheet.getCellRange("B1").getCellStyle().setKnownColor(ExcelColors.Gray25Percent);
        sheet.getCellRange("C1").getCellStyle().setKnownColor(ExcelColors.Gold);

        //Save to xml file
        workbook.saveAsXml(outputFile);
    }
}
