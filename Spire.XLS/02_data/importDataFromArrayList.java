import com.spire.xls.*;

import java.util.ArrayList;

public class importDataFromArrayList {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Create an empty worksheet
        workbook.createEmptySheets(1);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create an ArrayList object
        ArrayList list = new ArrayList();

        //Add strings in list
        list.add("Spire.Doc for Java");
        list.add("Spire.XLS for Java");
        list.add("Spire.PDF for Java");
        list.add("Spire.Presentation for Java");

        //Insert array list in worksheet
        sheet.insertArrayList(list, 1, 1, true);

        sheet.getAllocatedRange().autoFitColumns();
        //Save the Excel file
        String result = "output/importDataFromArrayList_out.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
