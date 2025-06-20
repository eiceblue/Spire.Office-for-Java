import com.spire.data.table.DataTable;
import com.spire.xls.*;

public class exportDataKeepDataFormat {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook=new Workbook();
        //Load the file from disk
        workbook.loadFromFile("data/ExportDataKeepDataFormat.xlsx");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Export to datatable without keeping data format
        ExportTableOptions options = new ExportTableOptions();
        options.setKeepDataFormat(false);
        options.setRenameStrategy(RenameStrategy.Digit);
        DataTable table = sheet.exportDataTable(1, 1, sheet.getLastDataRow(), sheet.getLastDataColumn(), options);
        int rows = table.getRows().size();
        int columns = table.getColumns().size();
        for (int i=0; i<rows;i++)
        {
            for (int j=0; j<columns;j++)
            {
                //Print out data
                System.out.println(table.getRows().get(i).getString(j));
            }
        }
    }
}
