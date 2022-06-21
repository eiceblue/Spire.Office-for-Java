import java.io.*;

import com.spire.xls.*;

public class readStream {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new Workbook();

        //Open excel from a stream
        FileInputStream fileStream = new FileInputStream("data/readStream.xlsx");

        workbook.loadFromStream(fileStream);

        String output = "output/readStream_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
