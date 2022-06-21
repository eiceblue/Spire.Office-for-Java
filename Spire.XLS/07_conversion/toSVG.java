import com.spire.xls.*;
import java.io.*;

public class toSVG {
    public static void main(String[] args) throws Exception {
        String  inputFile = "data/CreateTable.xlsx";
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);
        //Traverse worksheets
        for (int i = 0; i < workbook.getWorksheets().size(); i++)
        {
            FileOutputStream stream = new FileOutputStream("output/sheet"+i+".svg");
            //Convert worksheet to svg file
            Worksheet sheet = workbook.getWorksheets().get(i);
            sheet.toSVGStream(stream, sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());
            stream.flush();
            stream.close();
        }
    }
}
