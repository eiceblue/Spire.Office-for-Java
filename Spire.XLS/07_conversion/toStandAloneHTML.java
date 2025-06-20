import java.io.*;
import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.HTMLOptions;

public class toStandAloneHTML {
    public static void main(String[] args) throws IOException {
        //create a workbook
        Workbook wb = new Workbook();
        wb.loadFromFile("data/toHtml.xlsx");
		
		//set HTMLOptions
        HTMLOptions.Default.isStandAloneHtmlFile(true);
		
		//save excel to html stream
        FileOutputStream fileStream = new FileOutputStream("output/toHtml.html");
        wb.saveToStream(fileStream, FileFormat.HTML);
        fileStream.close();
    }
}
