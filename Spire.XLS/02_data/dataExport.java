import com.spire.data.table.DataTable;
import com.spire.xls.*;

public class dataExport {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DataExport.xlsx");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Export to dataTable
        DataTable dataTable= sheet.exportDataTable();
        int rows = dataTable.getRows().size();
        int columns = dataTable.getColumns().size();
        for (int i=0; i<rows;i++)
        {
            for (int j=0; j<columns;j++)
            {
                //Print out
                System.out.println(dataTable.getRows().get(i).getString(j));
            }
        }
    }
}
