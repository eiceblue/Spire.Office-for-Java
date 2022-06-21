import com.spire.xls.*;

import java.io.File;

public class detectExcelVersion {
    public static void main(String[] args) {
        //Files
        String[] files = new String[] { "data/ExcelSample97_N.xls", "data/WorksheetSample4.xlsx", "data/ExcelSample_N.xlsb" };

        for (String file : files) {
            //Create a workbook
            Workbook workbook = new Workbook();

            //Load the document
            workbook.loadFromFile(file);

            //Get the version
            ExcelVersion version = workbook.getVersion();

            System.out.println(version);
        }
    }
}
