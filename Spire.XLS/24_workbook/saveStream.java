import java.io.*;

import com.spire.xls.*;

public class saveStream {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/saveStream.xls");

        //Save an excel workbook to stream
        FileOutputStream fileStream = new FileOutputStream("output/saveStream_result.xlsx");
        workbook.saveToStream(fileStream, FileFormat.Version2013);

        fileStream.close();
    }
}
