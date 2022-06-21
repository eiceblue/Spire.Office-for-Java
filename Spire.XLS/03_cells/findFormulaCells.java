import com.spire.xls.*;

import java.util.EnumSet;

public class findFormulaCells {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile( "data/FindCellsSample.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Find the cells that contain formula "=SUM(A11,A12)"
        CellRange[] ranges = sheet.findAll("=SUM(A11,A12)", EnumSet.of(FindType.Formula), EnumSet.of(ExcelFindOptions.None));
        //Create a string builder
        StringBuilder builder = new StringBuilder();

        //Append the address of found cells to builder
        String address ;
        if (ranges.length != 0) {
            for(CellRange range : ranges) {
                address = range.getRangeAddress();
                builder.append("The address of found cell is: " + address+"\n");
            }
        } else {
            builder.append("No cell contain the formula"+"\n");
        }
        System.out.println(builder.toString());
    }
}
