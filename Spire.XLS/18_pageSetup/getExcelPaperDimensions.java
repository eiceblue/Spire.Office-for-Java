import com.spire.xls.*;

import java.io.*;

public class getExcelPaperDimensions {
    public static void main(String[] args) throws IOException {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        StringBuilder content = new StringBuilder();

        //Get the dimensions of A2 paper.
        sheet.getPageSetup().setPaperSize(PaperSizeType.A2Paper);
        content.append("A2Paper: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight()+"\r\n");

        //Get the dimensions of A3 paper.
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperA3);
        content.append("PaperA3: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight()+"\r\n");

        //Get the dimensions of A4 paper.
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperA4);
        content.append("PaperA4: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight()+"\r\n");

        //Get the dimensions of paper letter.
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperLetter);
        content.append("PaperLetter: " + sheet.getPageSetup().getPageWidth() + " x " + sheet.getPageSetup().getPageHeight()+"\r\n");

        String outputFile = "output/getExcelPaperDimensions_result.txt";

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
