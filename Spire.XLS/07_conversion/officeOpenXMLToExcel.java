import com.spire.xls.*;
import java.io.*;

public class officeOpenXMLToExcel {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/OfficeOpenXMLToExcel.Xml";
        String outputFile = "output/OfficeOpenXMLToExcel_out.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load from xml file
        FileInputStream fileStream = new FileInputStream(inputFile);
        try {
            workbook.loadFromXml(fileStream);
        }finally {
            if(fileStream != null)
                fileStream.close();
        }

        //Save to Excel file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
