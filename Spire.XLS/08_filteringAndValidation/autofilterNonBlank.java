import com.spire.xls.*;

public class autofilterNonBlank {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/AutofilterBlank.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Match the non blank data
        sheet.getAutoFilters().matchNonBlanks(0);

        //Filter
        sheet.getAutoFilters().filter();

        //Save the document
        String output = "output/AutofilterNonBlank_out.xlsx";
        workbook.saveToFile(output,ExcelVersion.Version2013);
    }
}
