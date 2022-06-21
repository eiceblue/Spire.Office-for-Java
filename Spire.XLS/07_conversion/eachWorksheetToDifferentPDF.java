import com.spire.xls.*;

public class eachWorksheetToDifferentPDF {
    public static void main(String[] args) {
        String inputFile = "data/EachWorksheetToDifferentPDFSample.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        for(int i = 0; i < workbook.getWorksheets().getCount(); i ++)
        {
           Worksheet worksheet = workbook.getWorksheets().get(i);
           String result = "output/sheet-" + i + "-result.pdf";
           worksheet.saveToPdf(result);
        }

    }
}
