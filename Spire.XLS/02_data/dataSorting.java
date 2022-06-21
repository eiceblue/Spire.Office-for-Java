import com.spire.xls.*;

public class dataSorting {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DataSorting.xls");

        Worksheet worksheet = workbook.getWorksheets().get(0);


        workbook.getDataSorter().getSortColumns().add(2, OrderBy.Ascending);
        workbook.getDataSorter().getSortColumns().add(3, OrderBy.Ascending);

        workbook.getDataSorter().sort(worksheet.getCellRange("A1:E19"));

        workbook.saveToFile("output/dataSorting_result.xlsx", ExcelVersion.Version2013);

    }
}
