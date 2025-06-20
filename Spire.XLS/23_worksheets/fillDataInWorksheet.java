import com.spire.xls.*;

public class fillDataInWorksheet {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Set the font of cell A1 to bold
        worksheet.getRange().get("A1").getStyle().getFont().isBold(true);
        // Set the font of cell B1 to bold
        worksheet.getRange().get("B1").getStyle().getFont().isBold(true);
        // Set the font of cell C1 to bold
        worksheet.getRange().get("C1").getStyle().getFont().isBold(true);

        // Set the text of cell A1 to "Month"
        worksheet.getRange().get("A1").setText("Month");
        // Set the text of cell A2 to "January"
        worksheet.getRange().get("A2").setText("January");
        // Set the text of cell A3 to "February"
        worksheet.getRange().get("A3").setText("February");
        // Set the text of cell A4 to "March"
        worksheet.getRange().get("A4").setText("March");
        // Set the text of cell A5 to "April"
        worksheet.getRange().get("A5").setText("April");

        // Set the text of cell B1 to "Payments"
        worksheet.getRange().get("B1").setText("Payments");
        // Set the numeric value of cell B2 to 251
        worksheet.getRange().get("B2").setNumberValue(251);
        // Set the numeric value of cell B3 to 515
        worksheet.getRange().get("B3").setNumberValue(515);
        // Set the numeric value of cell B4 to 454
        worksheet.getRange().get("B4").setNumberValue(454);
        // Set the numeric value of cell B5 to 874
        worksheet.getRange().get("B5").setNumberValue(874);

        // Set the text of cell C1 to "Sample"
        worksheet.getRange().get("C1").setText("Sample");
        // Set the text of cell C2 to "Sample1"
        worksheet.getRange().get("C2").setText("Sample1");
        // Set the text of cell C3 to "Sample2"
        worksheet.getRange().get("C3").setText("Sample2");
        // Set the text of cell C4 to "Sample3"
        worksheet.getRange().get("C4").setText("Sample3");
        // Set the text of cell C5 to "Sample4"
        worksheet.getRange().get("C5").setText("Sample4");

        // Set the width of column 2 to 10
        worksheet.setColumnWidth(2, 10);

        // Specify the file path for the resulting workbook
        String outputFile = "output/fillDataInWorksheet_result.xlsx";

        // Save the workbook to the specified file path with Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release resources associated with the workbook
        workbook.dispose();
    }
}
