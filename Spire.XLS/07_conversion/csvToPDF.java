import com.spire.xls.*;

public class csvToPDF {
    public static void main(String[] args) {
        String inputFile = "data/CSVToExcel.csv";

        //Create a workbook and load a csv file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile, ",", 1, 1);

        //Set the setSheetFitToPage property as true
        workbook.getConverterSetting().setSheetFitToPage(true);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Autofit a column if the characters in the column exceed column width
        for (int i = 1; i < sheet.getColumns().length; i++)
        {
            sheet.autoFitColumn(i);
        }

        //Save to PDF document
        String output = "output/CSVToPDF.pdf";
        workbook.saveToFile(output,  FileFormat.PDF);

    }
}
