import com.spire.xls.*;
import java.io.*;

public class getHyperLinkType {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/hyperlinksSample2.xlsx";
        String outputFile = "output/getHyperLinkType_result.txt";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Iterate all hyperlinks
        StringBuilder sb = new StringBuilder();
        for (HyperLink item : (Iterable<HyperLink>) sheet.getHyperLinks()) {
            //Get hyperlink address
            String address = item.getAddress();
            //Get hyperlink type
            HyperLinkType type = item.getType();
            sb.append("Link address: " + address + "\r\n");
            sb.append("Link type: " + type.toString() + "\r\n");
        }

        //Write to txt file
        writeStringToTxt(sb.toString(), outputFile);
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file = new File(txtFileName);
        if (file.exists()) {
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
