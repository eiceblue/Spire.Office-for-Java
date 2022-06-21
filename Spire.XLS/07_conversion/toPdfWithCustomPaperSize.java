import com.spire.xls.*;

public class toPdfWithCustomPaperSize {
    public static void main(String[] args) {
        //Create a Workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/CustomPaperSize.xlsx");

        //Get the first worksheet and set the custom paper size
        workbook.getWorksheets().get(0).getPageSetup().setCustomPaperSize(100,100);

        //Save it to PDF
        String outputName = "output/CustomPaperSize_out.pdf";
        workbook.saveToFile(outputName, FileFormat.PDF);
    }
}
