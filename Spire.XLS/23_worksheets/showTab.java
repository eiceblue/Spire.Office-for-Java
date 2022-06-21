import com.spire.xls.*;
public class showTab {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/WorksheetSample4.xlsx");

        //Show worksheet tab
        workbook.setShowTabs(true);

        //Save the document
        String output = "output/ShowTab_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
