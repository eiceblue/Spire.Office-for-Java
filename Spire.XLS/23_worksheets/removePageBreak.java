import com.spire.xls.*;

public class removePageBreak {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/pageBreak.xlsx");

        //Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Clear all the vertical page breaks
        sheet.getVPageBreaks().clear();

        //Remove the firt horizontal Page Break
        sheet.getHPageBreaks().removeAt(0);

        //Set the ViewMode as Preview to see how the page breaks work
        sheet.setViewMode(ViewMode.Preview);

        //Save the document
        String output = "output/removePageBreak_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
