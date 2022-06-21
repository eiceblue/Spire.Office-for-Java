import com.spire.xls.*;

public class getIntersectionOfTwoRanges {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the two ranges.
        CellRange range = sheet.getRange().get("A2:D7").intersect(sheet.getRange().get("B2:E8"));

        StringBuilder content = new StringBuilder();
        content.append("The intersection of the two ranges \"A2:D7\" and \"B2:E8\" is:"+"\n");

        //Get the intersection of the two ranges.
        for(CellRange r : range.getCellList())
        {
            content.append(r.getValue()+"\n");
        }

        System.out.println(content);
    }
}
