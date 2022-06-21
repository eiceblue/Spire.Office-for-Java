import com.spire.xls.*;

public class toPdfWithChangePageSize {
    public static void main(String[] args) {
        String inputFile = "data/SampleB_2.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        for(int i = 0; i < workbook.getWorksheets().getCount(); i ++)
        {
           Worksheet worksheet = workbook.getWorksheets().get(i);
           //Change the page size
           worksheet.getPageSetup().setPaperSize(PaperSizeType.PaperA3);

        }
        workbook.saveToFile("output/toPdfWithChangePageSize.pdf", FileFormat.PDF);

    }
}
