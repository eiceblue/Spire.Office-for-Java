import com.spire.xls.*;

public class expandAndCollapseGroups {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_3.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Expand the grouped rows with ExpandCollapseFlags set to expand parent
        sheet.getCellRange("A16:G19").expandGroup(GroupByType.ByRows, ExpandCollapseFlags.ExpandParent);

        //Collapse the grouped rows
        sheet.getCellRange("A10:G12").collapseGroup(GroupByType.ByRows);

        String result = "output/expandAndCollapseGroups_out.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
