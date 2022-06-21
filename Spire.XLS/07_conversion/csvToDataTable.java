import com.spire.data.table.DataTable;

import com.spire.xls.*;


public class csvToDataTable {
    public static void main(String[] args) {
        String inputFile = "data/CSVToExcel.csv";

        //Create a workbook and load a csv file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile, ",", 1, 1);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Export to dataTable
        DataTable dataTable = sheet.exportDataTable();
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
