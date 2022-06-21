import com.spire.xls.*;

public class getCellAddress {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/SampleB_2.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        StringBuilder builder = new StringBuilder();

        //Get a cell range
        CellRange range = sheet.getRange().get("A1:B5");

        //Get address of range
        String address = range.getRangeAddressLocal();
        builder.append("Address of range: " + address+"\n");

        //Get the cell count of range
        int count = range.getCellsCount();
        builder.append("Cell count of range: " + count+"\n");

        //Get the address of the entire column of range
        String entireColAddress = range.getEntireColumn().getRangeAddressLocal();
        builder.append("Address of entire column of the range: " + entireColAddress+"\n");

        //Get the address of the entire row of range
        String entireRowAddress = range.getEntireRow().getRangeAddressLocal();
        builder.append("Address of entire row of the range " + entireRowAddress+"\n");

        System.out.println(builder);
    }
}
