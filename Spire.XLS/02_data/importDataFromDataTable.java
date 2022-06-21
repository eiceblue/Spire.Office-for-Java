import com.spire.data.table.*;
import com.spire.xls.*;

public class importDataFromDataTable {
    public static void main(String[] args) throws Exception{
        //Create a workbook
        Workbook workbook = new Workbook();

        //Create an empty worksheet
        workbook.createEmptySheets(1);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a DataTable object
        DataTable dataTable = new DataTable();
        dataTable.getColumns().add("No", Integer.class);
        dataTable.getColumns().add("Name", String.class);
        dataTable.getColumns().add("City", String.class);

        //Create rows and add data
        DataRow dr = dataTable.newRow();
        dr.setInt(0,1);
        dr.setString(1,"Tom");
        dr.setString(2,"New York");
        dataTable.getRows().add(dr);
        dr = dataTable.newRow();
        dr.setInt(0,2);
        dr.setString(1,"Jerry");
        dr.setString(2,"China");
        dataTable.getRows().add(dr);
        dr = dataTable.newRow();
        dr.setInt(0,3);
        dr.setString(1,"Dive Time");
        dr.setString(2,"Berkely");
        dataTable.getRows().add(dr);
        dr = dataTable.newRow();
        dr.setInt(0,4);
        dr.setString(1,"Amor Aqua");
        dr.setString(2,"Florida");
        dataTable.getRows().add(dr);
        sheet.insertDataTable(dataTable, true, 1, 1);
        //Save the Excel file
        String result = "output/importDataFromDataTable_output.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
