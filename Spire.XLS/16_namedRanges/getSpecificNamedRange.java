import com.spire.xls.Workbook;

import java.io.*;

public class getSpecificNamedRange {
    public static void main(String[] args) throws IOException {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/getSpecificNamedRange_result.txt";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        StringBuilder sb = new StringBuilder();

        //Get specific named range by index
        String name1 = workbook.getNameRanges().get(1).getName();
        sb.append("Get the specific named range " + name1 + " by index" + "\r\n");


        //Get specific named range by name
        String name2 = workbook.getNameRanges().get("NameRange3").getName();
        sb.append("Get the specific named range " + name2 + " by name" + "\r\n");

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
