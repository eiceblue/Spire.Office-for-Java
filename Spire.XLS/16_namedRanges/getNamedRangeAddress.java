import com.spire.xls.Workbook;
import com.spire.xls.core.INamedRange;

import java.io.*;

public class getNamedRangeAddress {
    public static void main(String[] args) throws IOException {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/getNamedRangeAddress_result.txt";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        StringBuilder sb = new StringBuilder();

        //Get specific named range by index
        INamedRange NamedRange = workbook.getNameRanges().get(0);

        //Get the address of the named range
        String address = NamedRange.getRefersToRange().getRangeAddress();

        sb.append("The address of the named range " + NamedRange.getName() + " is " + address);

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
