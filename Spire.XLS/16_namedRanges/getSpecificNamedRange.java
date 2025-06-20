import com.spire.xls.Workbook;
import java.io.*;

public class getSpecificNamedRange {
    public static void main(String[] args) throws IOException {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/getSpecificNamedRange_result.txt";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Create a StringBuilder object to store the results
        StringBuilder stringBuilder = new StringBuilder();

        // Get the name of the named range at index 1 and append it to the StringBuilder
        String name1 = workbook.getNameRanges().get(1).getName();
        stringBuilder.append("Get the specific named range " + name1 + " by index" + "\r\n");

        // Get the name of the named range with the name "NameRange3" and append it to the StringBuilder
        String name2 = workbook.getNameRanges().get("NameRange3").getName();
        stringBuilder.append("Get the specific named range " + name2 + " by name" + "\r\n");

        // Write the contents of the StringBuilder to a text file using the writeStringToTxt function
        writeStringToTxt(stringBuilder.toString(), outputFile);

        // Dispose of the workbook object and release any associated resources
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
