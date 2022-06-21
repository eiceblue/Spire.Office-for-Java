import com.spire.xls.*;

public class fitWidthWhenConvertToPDF {
    public static void main(String[] args) {
        String inputFile = "data/SampleB_2.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        for(int i = 0; i < workbook.getWorksheets().getCount(); i ++)
        {
           Worksheet worksheet = workbook.getWorksheets().get(i);
            //Auto fit page height
            worksheet.getPageSetup().setFitToPagesTall(0);
            //Fit one page width
            worksheet.getPageSetup().setFitToPagesWide(1);
        }
        workbook.saveToFile("output/fitWidthWhenConvertToPDF.pdf", FileFormat.PDF);

    }
}
