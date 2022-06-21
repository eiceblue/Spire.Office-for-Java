import com.spire.xls.*;
import com.spire.xls.core.*;

import java.io.*;

public class getAllNamedRange {
    public static void main(String[] args) throws IOException {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/getAllNamedRange_result.txt";

        //Load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        StringBuilder sb = new StringBuilder();

        //Get all named range
        INameRanges ranges = workbook.getNameRanges();
        for (INamedRange nameRange : (Iterable<INamedRange>) ranges)
        {
            sb.append(nameRange.getName() + "\r\n");
        }

        //Write to txt file
        writeStringToTxt(sb.toString(),outputFile);
    }
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file=new File(txtFileName);
        if (file.exists())
        {
            file.delete();
        }
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
