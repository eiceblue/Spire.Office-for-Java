import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.HTMLOptions;

public class excelToHtml {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/WorkbookToHTML.xlsx");
        
        //Convert to html
        workbook.saveToFile("output/excelToHtml_result.html",FileFormat.HTML);
    }
}
