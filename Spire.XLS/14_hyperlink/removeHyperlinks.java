import com.spire.xls.*;
import com.spire.xls.collections.HyperLinksCollection;

public class removeHyperlinks {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/HyperlinksSample1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the collection of all hyperlinks in the worksheet
        HyperLinksCollection links = sheet.getHyperLinks();

        //Remove all link content
        sheet.getCellRange("B1").clearAll();
        sheet.getCellRange("B2").clearAll();
        sheet.getCellRange("B3").clearAll();

        //Remove hyperlink and keep link text
        sheet.getHyperLinks().removeAt(0);
        sheet.getHyperLinks().removeAt(0);
        sheet.getHyperLinks().removeAt(0);
        //Save the document
        String output = "output/RemoveHyperlinks_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
