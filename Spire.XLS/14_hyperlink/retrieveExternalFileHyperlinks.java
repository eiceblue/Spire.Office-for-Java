import com.spire.xls.*;
import java.io.*;

public class retrieveExternalFileHyperlinks {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/retrieveExternalFileHyperlinks.xlsx";
        String outputFile = "output/retrieveExternalFileHyperlinks_result.txt";

        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Load the workbook from the specified input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a StringBuilder to store the content
        StringBuilder content = new StringBuilder();

        // Iterate over each hyperlink in the worksheet
        for (HyperLink item : (Iterable<HyperLink>) sheet.getHyperLinks()) {
            // Get the address of the hyperlink
            String address = item.getAddress();

            // Get the name of the worksheet containing the hyperlink
            String sheetName = item.getRange().getWorksheetName();

            // Get the range of cells associated with the hyperlink
            CellRange range = item.getRange();

            // Append the cell information, sheet name, and address to the content StringBuilder
            content.append(String.format("Cell[%o,%o] in sheet \"" + sheetName + "\" contains File URL: %s", range.getRow(), range.getColumn(), address));
            content.append("\r\n");
        }

        // Write the content to the specified output file using the writeStringToTxt() method
        writeStringToTxt(content.toString(), outputFile);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
    /**
     * Writes a string content to a text file.
     *
     * @param content     The content to be written
     * @param txtFileName The name of the text file
     * @throws IOException If an I/O error occurs
     */
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
