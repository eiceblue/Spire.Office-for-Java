import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class toCSVWithDoubleQuotes {
    public static void main(String[] args) {
        //create a workbook.
        Workbook workbook = new Workbook();
        
        //load the document from disk
        workbook.loadFromFile("data/ToCSV.xlsx");

        //convert to CSV file,
        //When the last parameter is set to true, there are double quotes. The default parameter is flase
        workbook.saveToFile("ToCSVAddQuotation.csv",",",true);
    }
}
