import com.spire.xls.*;

public class saveFiles {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load data from the "excelSample_N1.xlsx" file into the workbook
        workbook.loadFromFile("data/excelSample_N1.xlsx");

        // Save the workbook to "result.xls" in Excel 97-2003 format
        workbook.saveToFile("output/result.xls", ExcelVersion.Version97to2003);

        // Save the workbook to "result.xlsx" in Excel 2010 format
        workbook.saveToFile("output/result.xlsx", ExcelVersion.Version2010);

        // Save the workbook to "result.xlsb" in XLSB 2010 format
        workbook.saveToFile("output/result.xlsb", ExcelVersion.Xlsb2010);

        // Save the workbook to "result.ods" in ODS (Open Document Spreadsheet) format
        workbook.saveToFile("output/result.ods", ExcelVersion.ODS);

        // Save the workbook to "result.pdf" in PDF format
        workbook.saveToFile("output/result.pdf", FileFormat.PDF);

        // Save the workbook to "result.xml" in XML format
        workbook.saveToFile("output/result.xml", FileFormat.XML);

        // Save the workbook to "result.xps" in XPS format
        workbook.saveToFile("output/result.xps", FileFormat.XPS);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
