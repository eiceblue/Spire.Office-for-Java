import com.spire.xls.*;

public class useExplicitLineBreaks {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first default worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //Specify a cell range
        CellRange c5 = sheet1.getRange().get("C5");

        //Set the cell width for specified range
        sheet1.setColumnWidth(c5.getColumn(), 70);

        //Put the string value with explicit line breaks
        c5.setValue("Spire.XLS for Java is a professional Excel Java API\n that can be used to create, read, \nwrite, convert and print Excel files in Java application \nSpire.XLS for Java offers object model\n Excel API for speeding up Excel programming in Java platform -\n create new Excel documents from template, edit existing \nExcel documents and \nconvert Excel files.");

        //Set Text wrap
        c5.isWrapText(true);

        //String for output file
        String outputFile = "output/useExplicitLineBreaks_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
