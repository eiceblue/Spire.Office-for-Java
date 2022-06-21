import com.spire.xls.*;

public class convertTextToNumber {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/Sample.xlsx");

        //Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Convert text string format to number format
        worksheet.getRange().get("D2:D8").convertToNumber();

        //String for output file
        String outputFile = "output/convertTextToNumber_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
