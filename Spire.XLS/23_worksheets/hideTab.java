import com.spire.xls.*;
public class hideTab {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/WorksheetSample2.xlsx");

        //Hide worksheet tab
        workbook.setShowTabs(false);

        //Save the document
        String output = "output/HideTab_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
