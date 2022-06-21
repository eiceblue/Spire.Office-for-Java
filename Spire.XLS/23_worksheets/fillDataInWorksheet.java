import com.spire.xls.*;

public class fillDataInWorksheet {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get first worksheet of the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Fill data
        worksheet.getRange().get("A1").getStyle().getFont().isBold(true);
        worksheet.getRange().get("B1").getStyle().getFont().isBold(true);
        worksheet.getRange().get("C1").getStyle().getFont().isBold(true);
        worksheet.getRange().get("A1").setText("Month");
        worksheet.getRange().get("A2").setText("January");
        worksheet.getRange().get("A3").setText("February");
        worksheet.getRange().get("A4").setText("March");
        worksheet.getRange().get("A5").setText("April");
        worksheet.getRange().get("B1").setText("Payments");
        worksheet.getRange().get("B2").setNumberValue(251);
        worksheet.getRange().get("B3").setNumberValue(515);
        worksheet.getRange().get("B4").setNumberValue(454);
        worksheet.getRange().get("B5").setNumberValue(874);
        worksheet.getRange().get("C1").setText("Sample");
        worksheet.getRange().get("C2").setText("Sample1");
        worksheet.getRange().get("C3").setText("Sample2");
        worksheet.getRange().get("C4").setText("Sample3");
        worksheet.getRange().get("C5").setText("Sample4");

        //Set width for the second column
        worksheet.setColumnWidth(2, 10);

        //String for output file 
        String outputFile = "output/fillDataInWorksheet_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
