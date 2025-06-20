import com.spire.xls.*;

public class customSort {
    public static void main(String[] args) {
        //Create a workbook
        Workbook wb = new Workbook();
        //Get the first sheet
        Worksheet sheet = wb.getWorksheets().get(0);
        //Set header to participate in sorting
        wb.getDataSorter().isIncludeTitle(false);
        //Add data
        sheet.getCellRange("A1").setText("AA");
        sheet.getCellRange("A2").setText("BB");
        sheet.getCellRange("A3").setText("CC");
        sheet.getCellRange("A4").setText("DD");
        sheet.getCellRange("A5").setText("EE");
        sheet.getCellRange("A6").setText("FF");
        sheet.getCellRange("A7").setText("GG");
        sheet.getCellRange("A8").setText("HH");
        //Custom sort
        wb.getDataSorter().getSortColumns().add(0, new String[]
                {"DD","CC", "BB", "AA", "HH","GG","FF","EE"}
        );
        wb.getDataSorter().sort(wb.getWorksheets().get(0).getRange().get("A1:A8"));

        //Save to file
        String outputFile="output/customSort.xlsx";
        wb.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
