import com.spire.xls.*;
import com.spire.xls.collections.HyperLinksCollection;

public class modifyHyperlink {
    public static void main(String[] args) {
        String inputFile = "data/modifyHyperlink.xlsx";
        String outputFile = "output/modifyHyperlink_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(inputFile);

        //Get the collection of all hyperlinks in the worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Change the values of TextToDisplay and Address property
        HyperLinksCollection links = sheet.getHyperLinks();
        links.get(0).setTextToDisplay("Spire.XLS for JAVA");
        links.get(0).setAddress("https://www.e-iceblue.com/Introduce/xls-for-java.html");

        //Save the document
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
