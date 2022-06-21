import com.spire.xls.*;

import java.io.*;

public class retrieveExternalFileHyperlinks {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/retrieveExternalFileHyperlinks.xlsx";
        String outputFile = "output/retrieveExternalFileHyperlinks_result.txt";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        StringBuilder content = new StringBuilder();

        //Retrieve external file hyperlinks.
        for (HyperLink item : (Iterable<HyperLink>) sheet.getHyperLinks())
        {
            String address = item.getAddress();
            String sheetName = item.getRange().getWorksheetName();
            CellRange range = item.getRange();
            content.append(String.format("Cell[%o,%o] in sheet \"" + sheetName + "\" contains File URL: %s", range.getRow(), range.getColumn(), address));
            content.append("\r\n");
        }

        //Write to txt file
        writeStringToTxt(content.toString(),outputFile);
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
