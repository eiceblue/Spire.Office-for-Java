package worksheets;

import com.spire.xls.*;

public class filteredValueToCSV {
    public static void main(String[] args) throws Exception {
        String input = "data/FilteredSample.xlsx";
        String output = "output/filteredValueToCSV.csv";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //save to csv file
        sheet.saveToFile(output, " ", false);
    }
}
