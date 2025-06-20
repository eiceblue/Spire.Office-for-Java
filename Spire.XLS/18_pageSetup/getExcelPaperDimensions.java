import com.spire.xls.*;
import java.io.*;

public class getExcelPaperDimensions {
    public static void main(String[] args) throws IOException {

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a StringBuilder to hold the content
        StringBuilder content = new StringBuilder();

        // Set the paper size of the worksheet's page setup to A2Paper
        sheet.getPageSetup().setPaperSize(PaperSizeType.A2Paper);
        content.append("A2Paper: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight() + "\r\n");

        // Set the paper size of the worksheet's page setup to PaperA3
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperA3);
        content.append("PaperA3: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight() + "\r\n");

        // Set the paper size of the worksheet's page setup to PaperA4
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperA4);
        content.append("PaperA4: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight() + "\r\n");

        // Set the paper size of the worksheet's page setup to PaperLetter
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperLetter);
        content.append("PaperLetter: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight() + "\r\n");

        // Specify the output file path
        String outputFile = "output/getExcelPaperDimensions_result.txt";

        // Write the content to the output text file
        writeStringToTxt(content.toString(), outputFile);

        // Release any resources used by the workbook
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
