import com.spire.xls.*;

public class findCellsWithStyleName {
    public static void main(String[] args) {
        String inputFile = "data/SampleB_2.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        Worksheet sheet  = workbook.getWorksheets().get(0);

        //Get the cell style name
        String styleName = sheet.getRange().get("A1").getCellStyleName();

        for (int i = 1; i <= sheet.getLastRow(); i ++)
        {
          for (int j =1; j <= sheet.getLastColumn(); j ++)
          {
            CellRange cr =  sheet.getCellRange(i,j);
            if (cr.getCellStyleName().equals(styleName))
            {
                cr.setValue("Same style");
            }

          }
        }

        //Save the document
        String output = "output/findCellsWithStyleName.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
