import com.spire.xls.*;

public class toPDF {
    public static void main(String[] args) {
        String inputFile = "data/ExcelSampleN.xlsx";
        String outputFile = "output/ToPDF_out.pdf";

        //Create a workbook
        Workbook workbook = new Workbook();
        try
        {
            //Load a file
            workbook.loadFromFile(inputFile);
            //Fit to page
            workbook.getConverterSetting().setSheetFitToPage(true);
            //Save to PDF file
            workbook.saveToFile(outputFile, FileFormat.PDF);
        }finally {
            workbook.dispose();
        }
    }
}
